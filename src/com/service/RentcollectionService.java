package com.service;

import java.util.List;

import com.currency.Warning;
import com.javabean.QueryVo;
import com.javabean.rentcollection;

public interface RentcollectionService {

	/**
	 * 查询筛选所有缴费信息数据
	 */
	public List<rentcollection> queryPaidStateAll(String state,String name);
	
	/**
	 * 对应id删除数据
	 */
	public Warning deleteByPrimaryKey(Integer rcid);
	
	/**
	 * 添加数据
	 * */
	public void insert(rentcollection record);
	
	/**
	 * 支付租金
	 */
	public Warning updateState(Integer rchouseid);
	
	/**
	 *查询代缴租金 
	 * */
	public List<rentcollection> selectPaidStateAll(String rcstate);
	
	/**
	 * 搜索查询
	 * */
	public List<rentcollection>  selectPaidAll(QueryVo vo);
	
	/**
	 * 修改真实姓名
	 */
	public String updateUserName(String username,String rcusernametemp);
}
