package com.service;

import java.util.List;

import com.javabean.leaseinformation;

public interface LeaseinformationService {

	/**
	 * 添加房屋
	 */
	public void addHouse(leaseinformation record);
	
	/**
	 * 查询所有房屋数据
	 */
	public List<leaseinformation> queryAll();
	
	/**
	 * 查询对应姓名的房主
	 */
	public List<leaseinformation> queryNameAll(String name);
	
	/**
	 * 查询对应房源id的房源
	 */
    List<leaseinformation> selectHouseCall(String housecall);
	
	/**
	 * 查询对应的id信息
	 */
	public List<leaseinformation> queryID(Integer id);
	
	/**
	 * 查询全部的链表
	 */
	public List<leaseinformation> allANDimg();
	
	/**
	 * 根据id查询全部的链表
	 */
	public List<leaseinformation> allANDimg1(Integer id);
	
	public List<leaseinformation> selecthousteaseWith(String steate);
	
	public boolean updacontract(Integer id);
	
	/**
	 * 修改对应id的房源信息
	 * */
	public int updateByPrimaryKey(leaseinformation record);
	
	/**
	 *删除对应id的房源信息
	 * */
	public int deleteByPrimaryKey(Integer id);
	
	/*
	 * 推荐状态查询
	 * */
	public List<leaseinformation> selectRecommend();
	
	/**
	 * 官网查看可租聘的房屋
	 */
	public List<leaseinformation> selectState(String state);
	
	/**
	 * 同意退租后删除外键
	 */
	public String updateCancelForeignKey(String housecall);
	
	/**
	 * 模糊搜索房屋
	 */
	public List<leaseinformation> selectHouseQuery(String housequery);
	
	/**
	 * 可租凭设推荐列表
	 */
	 public List<leaseinformation> selectAllLeasable();
}
