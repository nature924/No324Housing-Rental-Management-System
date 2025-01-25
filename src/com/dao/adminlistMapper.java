package com.dao;

import com.javabean.adminlist;
import java.util.List;

public interface adminlistMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(adminlist record);

    adminlist selectByPrimaryKey(Integer adminid);
    
    adminlist queryAllAdminPwd(adminlist record);

    List<adminlist> selectAll();

    int updateByPrimaryKey(adminlist record);
}