package com.service;
import java.util.List;

import com.currency.Warning;
import com.javabean.userlist;

public interface UserlistService {
	
	/**
	 * 用户登录
	 */
	public userlist queryAllUserPwd(userlist record);
	
	/**
	 * 查找用户称呼
	 */
	public userlist selectUserCall(String usercall);
	/**
	 * 查找用户真实姓名
	 */
	public userlist selectUserName(String username);
	/**
	 * 外键查询用户的租房信息
	 */
	public List<userlist> selectUserNameWith(String username);
	
	/**
	 * 外键查询房屋id
	 */
	public userlist selectUserCallWith(String housecall);
	
	/**
	 * 查找用户手机
	 */
	public userlist selectUserPhone(String userphone);
	
	/**
	 * 添加用户
	 * */
	public int insert(userlist record);
	
	/**
	 * 修改密码
	 * */
	public int updatepwd(userlist record);
	
	/**
	 * 修改个人信息
	 */
	public Warning updateByPrimaryCall(userlist record);
	
	/**
	 * 查找所有用户
	 */
	public List<userlist> selectAll();
	
	/**
	 * 删除用户
	 * */
	public int deleteByPrimaryKey(Integer id);
	
	/*
	 * id查找用户
	 * */
	public userlist selectUserId(Integer userid);
	
	/**
     * 我要收租--查询
     * */
    public List<userlist> rentSelectAll();
    
    /**
     * 修改联表数据
     */
    public Warning updateJointTableName(userlist record);
    
    /**
     * 取消联表间的关系
     */
    public String updateJointTabledelete(String username);
}
