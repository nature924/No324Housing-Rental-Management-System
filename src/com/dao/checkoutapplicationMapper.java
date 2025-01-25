package com.dao;

import com.javabean.checkoutapplication;

import java.util.List;

public interface checkoutapplicationMapper {
    int deleteByPrimaryKey(Integer coaid);

    int insert(checkoutapplication record);

    checkoutapplication selectByPrimaryKey(Integer coaid);

    List<checkoutapplication> selectAll();

    List<checkoutapplication> selectStateAll(checkoutapplication record);
    
    checkoutapplication selectCallState(checkoutapplication record);
    
    int updateCallState (checkoutapplication record);
    
    int updateByPrimaryKey(checkoutapplication record);
    
    int updateState(checkoutapplication record);
    
    List<checkoutapplication> selectCoaState();
    
    boolean xgaiCoaState(checkoutapplication record);
    
    List<checkoutapplication> selectCoaState1();
}