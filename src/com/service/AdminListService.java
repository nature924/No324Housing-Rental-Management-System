package com.service;

import com.javabean.adminlist;

public interface AdminListService {

	public adminlist findAll(Integer adminid);
	
	public adminlist findAllAdminPwd(adminlist record);
}
