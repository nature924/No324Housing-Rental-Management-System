package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.mydailylifeMapper;
import com.javabean.mydailylife;
import com.service.MydailylifeService;

@Service("mydailylifeService")
@Transactional
public class MydailylifeServiceimpl implements MydailylifeService{

	@Resource
	private mydailylifeMapper mydailylifeMapper;
	
	/**
	 * 删除日程
	 * */
	@Override
	public int deleteByPrimaryKey(Integer mdlid) {
		// TODO Auto-generated method stub
		return mydailylifeMapper.deleteByPrimaryKey(mdlid);
	}
	/**
	 * 添加日程
	 * */
	@Override
	public int insert(mydailylife record) {
		// TODO Auto-generated method stub
		return mydailylifeMapper.insert(record);
	}
	
	@Override
	public mydailylife selectByPrimaryKey(Integer mdlid) {
		// TODO Auto-generated method stub
		return mydailylifeMapper.selectByPrimaryKey(mdlid);
	}
	/**
	 * 查询日程
	 * */
	@Override
	public List<mydailylife> selectAll() {
		// TODO Auto-generated method stub
		return mydailylifeMapper.selectAll();
	}
	/**
	 * 修改日程
	 * */
	@Override
	public int updateByPrimaryKey(mydailylife record) {
		// TODO Auto-generated method stub
		return mydailylifeMapper.updateByPrimaryKey(record);
	}

}
