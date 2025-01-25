package com.dao;

import com.javabean.mydailylife;
import java.util.List;

public interface mydailylifeMapper {
    int deleteByPrimaryKey(Integer mdlid);

    int insert(mydailylife record);

    mydailylife selectByPrimaryKey(Integer mdlid);

    List<mydailylife> selectAll();

    int updateByPrimaryKey(mydailylife record);
}