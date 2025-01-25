package com.dao;

import com.javabean.userlist;
import java.util.List;

public interface userlistMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(userlist record);

    userlist selectByPrimaryKey(Integer userid);

    userlist selectUserPwd(userlist record);
    
    userlist selectUserId(Integer userid);
    
    userlist selectUserCall(String usercall);
    
    userlist selectUserName(String username);
    
    List<userlist> selectUserNameWith(String username);
    
    userlist selectHouseCallWith(String housecall);
    
    List<userlist> selectAll();

    int updateByPrimaryKey(userlist record);
    
    int updateByPrimaryCall(userlist record);
    
    int updateJointTableName(userlist record);
    
    int updateJointTabledelete(String username);
    
    userlist selectUserPhone(String userphone);

    List<userlist> rentSelectAll();
    
}
