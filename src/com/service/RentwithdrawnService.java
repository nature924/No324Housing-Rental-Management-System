package com.service;

import java.util.List;

import com.currency.Warning;
import com.javabean.rentwithdrawn;


public interface RentwithdrawnService {

	/**
	 * 查询筛选所有租赁信息数据
	 */
	public List<rentwithdrawn> queryAllStateName(String State1,String State2,String Name);
	
	/**
	 * 删除退租记录
	 */
	public Warning deleteByPrimaryKey(Integer rwid);
	
	/**
	 * 查询所有退租记录
	 */
	public List<rentwithdrawn> selectRwState(String state);
}
