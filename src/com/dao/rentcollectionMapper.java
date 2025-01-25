package com.dao;


import com.javabean.QueryVo;
import com.javabean.rentcollection;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface rentcollectionMapper {
    int deleteByPrimaryKey(Integer rcid);

    void insert(rentcollection record);

    rentcollection selectByPrimaryKey(Integer rcid);

    List<rentcollection> selectAll();

    List<rentcollection> selectPaidStateNameAll(rentcollection rentcollection);
    
    int updateByPrimaryKey(rentcollection record);
    
    int updateUserName(rentcollection record);
    
    int updateState(@Param("rcid") Integer rchouseid,@Param("date") String date);
    
    List<rentcollection> selectPaidStateAll(rentcollection record);
    
    List<rentcollection>  selectPaidAll(QueryVo vo);
}