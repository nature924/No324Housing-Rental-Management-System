package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.leaseimgMapper;
import com.javabean.leaseimg;
import com.service.LeaseimgService;
@Service("leaseimgService")
public class LeaseimgMapperImpl implements LeaseimgService {

	@Resource
	private leaseimgMapper leaseimgMapper;
	
	@Override
	public List<leaseimg> selectAll() {
		// TODO Auto-generated method stub
		return leaseimgMapper.selectAll();
	}

	@Override
	public int insert(leaseimg record) {
		// TODO Auto-generated method stub
		return leaseimgMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return leaseimgMapper.deleteByPrimaryKey(id);
	}

}
