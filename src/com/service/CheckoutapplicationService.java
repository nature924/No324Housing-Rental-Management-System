package com.service;

import java.util.List;

import com.currency.Warning;
import com.javabean.checkoutapplication;
import com.javabean.userlist;

public interface CheckoutapplicationService {
	
	/**
	 * 查询所有退房申请中
	 */
	public List<checkoutapplication> findAll();
	
	/**
	 * 查询退房历史记录
	 */
	public List<checkoutapplication> selectStateAll(String State1,String State2,String State3,String Name);
	
	/**
	 * 申请退房
	 */
	public Warning insert(userlist userlist);
	
	/**
	 * 终止退房申请
	 */
	public Warning updateCallState (String coastate,String coahouseid);
	
	/**
	 * 同意拒绝退房申请
	 */
	public String updateState (String coastate,Integer coaid);
	
	/**
	 * 删除申请记录
	 */
	public Warning deleteByPrimaryKey (Integer coaid);
	
	/**
	 * 添加申请
	 */
	public String insertApply (checkoutapplication checkoutapplication);
	
	/**
	 * 查询申请中的记录
	 */
	public List<checkoutapplication> selectCoaState();
	
	/**
	 * 修改状态
	 */
	public boolean xgaiCoaState(String coastate,Integer coaid);
	
	/**
	 * 查询不是申请中的记录
	 */
	public List<checkoutapplication> selectCoaState1();
	
}
