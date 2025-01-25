package com.service;

import java.util.List;

import com.currency.Warning;
import com.javabean.QueryVo;
import com.javabean.fault;

public interface FaultService {
	
	/**
	 * 状态查询报障内容
	 */
	public List<fault> queryAllState(String str,String name);
	
	/**
	 * 删除报障记录
	 */
	public Warning deleteByPrimaryKey(Integer fid);
	
	/**
	 * 添加报障内容
	 */
	public Warning insert(fault record);
	
	/**
	 * 管理员查询待处理报障内容
	 * */
	public List<fault> AdminSelectStateAll(String state);
	
	/**
	 * 管理员修改状态--查询所要修改的数据
	 * */
	public fault selectByPrimaryKey(Integer fid);
	
	/**
	 * 管理员修改状态--更改状态
	 * */
	public int updateByPrimaryKey(fault record);
	
	/**
	 * 搜索报障
	 * */
	public List<fault> repairselect(QueryVo vo);
}
