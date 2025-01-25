package com.service;

import java.util.List;

import com.javabean.leaseimg;

public interface LeaseimgService {
	/*
	 * 查看所有图片
	 **/
	public List<leaseimg> selectAll();
	/*
	 *添加图片
	 **/
	public int insert(leaseimg record);
	/*
	 *删除图片
	 **/
	public int deleteByPrimaryKey(Integer id);
}
