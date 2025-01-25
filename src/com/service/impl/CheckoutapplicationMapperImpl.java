package com.service.impl;
/**
 * 退房申请中Serviceimpl
 */
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.Warning;
import com.dao.checkoutapplicationMapper;
import com.javabean.checkoutapplication;
import com.javabean.userlist;
import com.service.CheckoutapplicationService;

@Service("checkoutapplicationService")
@Transactional
public class CheckoutapplicationMapperImpl implements CheckoutapplicationService {

	@Resource
	private checkoutapplicationMapper checkoutapplicationMapper;
	
	@Override
	public List<checkoutapplication> findAll() {
		return checkoutapplicationMapper.selectAll();
	}

	@Override
	public List<checkoutapplication> selectStateAll(String State1,String State2,String State3,String Name) {
		checkoutapplication checkoutapplication=new checkoutapplication();
		checkoutapplication.setState1(State1);
		checkoutapplication.setState2(State2);
		checkoutapplication.setState3(State3);
		checkoutapplication.setCoausername(Name);
		return checkoutapplicationMapper.selectStateAll(checkoutapplication);
	}

	@Override
	public Warning insert(userlist userlist) {
		//判断是否已经申请了
		checkoutapplication coa=new checkoutapplication();
		coa.setCoahouseid(userlist.getLeaseinformation().getHousecall());
		coa.setCoastate("申请中");
		checkoutapplication temp = checkoutapplicationMapper.selectCallState(coa);
		if(temp!=null) {
			return new Warning(1, "该房已申请过退租!请等待审批!");
		}
		checkoutapplication checkoutapplication=new checkoutapplication();
		checkoutapplication.setCoausername(userlist.getUsername());
		checkoutapplication.setCoauserid(userlist.getUserid());
		checkoutapplication.setCoauserphone(userlist.getUserphone());
		checkoutapplication.setCoahouseid(userlist.getLeaseinformation().getHousecall());
		checkoutapplication.setCoahouseaddress(userlist.getLeaseinformation().getHouseaddress());
		checkoutapplication.setCoahouseprice(Double.parseDouble(userlist.getLeaseinformation().getHousemoney()));
		checkoutapplication.setCoahousesize(userlist.getLeaseinformation().getHousesize());
		checkoutapplication.setCoastate("退房申请中");
		
		checkoutapplicationMapper.insert(checkoutapplication);
		return new Warning(1, "已申请退租!");
	}

	@Override
	public Warning updateCallState(String coastate,String coahouseid) {
		checkoutapplication checkoutapplication=new checkoutapplication();
		checkoutapplication.setCoastate(coastate);
		checkoutapplication.setCoahouseid(coahouseid);
		return checkoutapplicationMapper.updateCallState(checkoutapplication)>0?new Warning(1,"终止申请成功!"):new Warning(2,"终止申请失败!");
	}

	@Override
	public Warning deleteByPrimaryKey(Integer coaid) {
		return checkoutapplicationMapper.deleteByPrimaryKey(coaid)>0?new Warning(0,"删除成功!"):new Warning(2,"删除失败!");
	}

	@Override
	public String insertApply(checkoutapplication checkoutapplication) {
		return checkoutapplicationMapper.insert(checkoutapplication)>0?"申请成功!":"申请失败!";
	}

	@Override
	public List<checkoutapplication> selectCoaState() {
		return checkoutapplicationMapper.selectCoaState();
	}

	@Override
	public boolean xgaiCoaState(String coastate, Integer coaid) {
		checkoutapplication checkoutapplication=new checkoutapplication();
		checkoutapplication.setCoastate(coastate);
		checkoutapplication.setCoaid(coaid);
		return checkoutapplicationMapper.xgaiCoaState(checkoutapplication);
	}

	@Override
	public List<checkoutapplication> selectCoaState1() {
		return checkoutapplicationMapper.selectCoaState1();
	}

	@Override
	public String updateState(String coastate, Integer coaid) {
		checkoutapplication checkoutapplication=new checkoutapplication();
		checkoutapplication.setCoastate(coastate);
		checkoutapplication.setCoaid(coaid);
		if(coastate.equals("已同意")) {
			return checkoutapplicationMapper.updateState(checkoutapplication)>0?"同意退租成功!":"同意退租失败!";
		}else if(coastate.equals("已拒绝")){
			return checkoutapplicationMapper.updateState(checkoutapplication)>0?"拒绝退租成功!":"拒绝退租失败!";
		}
		return "异常";
	}

}
