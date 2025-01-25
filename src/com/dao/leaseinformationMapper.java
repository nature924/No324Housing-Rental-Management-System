package com.dao;

import com.javabean.leaseinformation;
import java.util.List;

public interface leaseinformationMapper {
    int deleteByPrimaryKey(Integer houseid);

    void insert(leaseinformation record);

    leaseinformation selectByPrimaryKey(Integer houseid);
    List<leaseinformation> selectByPrimaryKey1(Integer houseid);

    List<leaseinformation> selectAll();
    
    List<leaseinformation> selectNameAll(String username);
    
    List<leaseinformation> selectHouseCall(String housecall);
    
    int updateByPrimaryKey(leaseinformation record);
    
    int updateCancelForeignKey(String housecall);
    
    List<leaseinformation> selectAllWith();
    
    List<leaseinformation> selectByPrimaryKeyWith(Integer houseid);
    
    List<leaseinformation> selecthousteaseWith(String state);
    
    List<leaseinformation> selectRecommend();
    
    boolean updacontract(Integer id);
    
    List<leaseinformation> selectState(String state);
    
    List<leaseinformation> selectHouseQuery(String housequery);
    
    List<leaseinformation> selectAllLeasable();
}