package com.service.impl;
import java.text.SimpleDateFormat;
/**
 * 官网Serviceimpl
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.leaseinformationMapper;
import com.javabean.leaseinformation;
import com.service.LeaseinformationService;
@Service("leaseinformationService")
@Transactional
public class LeaseinformationMapperImpl implements LeaseinformationService {

	@Resource
	private leaseinformationMapper leaseinformationMapper;
	
	@Override
	public void addHouse(leaseinformation record) {
		leaseinformationMapper.insert(record);
	}

	@Override
	public List<leaseinformation> queryAll() {
		return leaseinformationMapper.selectAll();
	}

	@Override
	public List<leaseinformation> queryNameAll(String name) {
		return leaseinformationMapper.selectNameAll(name);
	}

	@Override
	public List<leaseinformation> queryID(Integer id) {
		return leaseinformationMapper.selectByPrimaryKey1(id);
	}

	@Override
	public List<leaseinformation> allANDimg() {
		return leaseinformationMapper.selectAllWith();
	}
	@Override
	public List<leaseinformation> allANDimg1(Integer id) {
		return leaseinformationMapper.selectByPrimaryKeyWith(id);
	}

	@Override
	public List<leaseinformation> selecthousteaseWith(String steate) {
		List<leaseinformation> list=leaseinformationMapper.selecthousteaseWith(steate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(leaseinformation temp:list) {
			String date1 = sdf.format(temp.getHousestartingdate());
			String date2 = sdf.format(temp.getHouseclosingdate());
			temp.setHousestartingdatetemp(date1);
			temp.setHouseclosingdatetemp(date2);
		}
		return list;
	}

	@Override
	public boolean updacontract(Integer id) {
		return leaseinformationMapper.updacontract(id);
	}

	@Override
	public int updateByPrimaryKey(leaseinformation record) {
		return leaseinformationMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return leaseinformationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<leaseinformation> selectRecommend() {
		return leaseinformationMapper.selectRecommend();
	}

	@Override
	public List<leaseinformation> selectHouseCall(String housecall) {
		return leaseinformationMapper.selectHouseCall(housecall);
	}

	@Override
	public List<leaseinformation> selectState(String state) {
		return leaseinformationMapper.selectState(state);
	}

	@Override
	public String updateCancelForeignKey(String housecall) {
		return leaseinformationMapper.updateCancelForeignKey(housecall)>0?"已删除该外键":"外键删除失败";
	}

	@Override
	public List<leaseinformation> selectHouseQuery(String housequery) {
		return leaseinformationMapper.selectHouseQuery(housequery);
	}

	@Override
	public List<leaseinformation> selectAllLeasable() {
		return leaseinformationMapper.selectAllLeasable();
	}

}
