package com.service.impl;
/**
 * 管理员Serviceimpl
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.adminlistMapper;
import com.javabean.adminlist;
import com.service.AdminListService;
@Service("adminListService")
@Transactional
public class AdminListMapperImpl implements AdminListService{

	@Resource
	private adminlistMapper adminlistMapper;
	
	@Override
	public adminlist findAll(Integer adminid) {
		return adminlistMapper.selectByPrimaryKey(adminid);
	}

	@Override
	public adminlist findAllAdminPwd(adminlist record) {
		return adminlistMapper.queryAllAdminPwd(record);
	}
}
