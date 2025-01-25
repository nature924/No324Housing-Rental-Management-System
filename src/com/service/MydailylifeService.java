package com.service;

import java.util.List;

import com.javabean.mydailylife;

public interface MydailylifeService {
	int deleteByPrimaryKey(Integer mdlid);

    int insert(mydailylife record);

    mydailylife selectByPrimaryKey(Integer mdlid);

    List<mydailylife> selectAll();

    int updateByPrimaryKey(mydailylife record);
}
