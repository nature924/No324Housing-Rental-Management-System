package com.service.impl;
/**
 * 缴费Serviceimpl
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.Warning;
import com.dao.rentcollectionMapper;
import com.javabean.QueryVo;
import com.javabean.rentcollection;
import com.service.RentcollectionService;

@Service("rentcollectionService")
@Transactional
public class RentcollectionMapperImpl implements RentcollectionService {

	@Resource
	private rentcollectionMapper rentcollectionMapper;
	
	@Override
	public List<rentcollection> queryPaidStateAll(String state,String name) {
		rentcollection rentcollection=new rentcollection();
		rentcollection.setRcstate(state);
		rentcollection.setRcusername(name);
		List<rentcollection> templist=rentcollectionMapper.selectPaidStateNameAll(rentcollection);
		for(rentcollection temp:templist) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Rcdate = sdf.format(temp.getRcdate());
			temp.setRcdatetemp(Rcdate);
			if(temp.getRcpaiddate()!=null) {
				String Rcpaiddate = sdf.format(temp.getRcpaiddate());
				temp.setRcpaiddatetemp(Rcpaiddate);
			}
		}
		return templist;
	}

	@Override
	public Warning deleteByPrimaryKey(Integer rcid) {
		return rentcollectionMapper.deleteByPrimaryKey(rcid)>0?new Warning(0, "删除成功!"):new Warning(2, "删除失败");
	}

	@Override
	public void insert(rentcollection record) {
		record.setRcstate("未缴纳");
		rentcollectionMapper.insert(record);
	}

	@Override
	public List<rentcollection> selectPaidStateAll(String rcstate) {
		rentcollection record = new rentcollection();
		record.setRcstate(rcstate);
		List<rentcollection> rentlist= rentcollectionMapper.selectPaidStateAll(record);
		for(rentcollection temp:rentlist) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(temp.getRcdate());
			temp.setRcdatetemp(date);
		}
		return rentlist;
	}

	@Override
	public List<rentcollection> selectPaidAll(QueryVo vo) {
		List<rentcollection> list = rentcollectionMapper.selectPaidAll(vo);
		return list;
	}

	@Override
	public String updateUserName(String username,String rcusernametemp) {
		rentcollection record=new rentcollection();
		record.setRcusername(username);
		record.setRcusernametemp(rcusernametemp);
		return rentcollectionMapper.updateUserName(record)>0?"修改租金真实姓名成功":"修改租金真实姓名失败";
	}

	@Override
	public Warning updateState(Integer rchouseid) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datetemp=sdf.format(new Date());
		return rentcollectionMapper.updateState(rchouseid,datetemp)>0?new Warning(0, "支付成功!"):new Warning(2, "支付失败");
	}

}
