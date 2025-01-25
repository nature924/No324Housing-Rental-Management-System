package com.dao;

import com.javabean.rentwithdrawn;
import java.util.List;

public interface rentwithdrawnMapper {
    int deleteByPrimaryKey(Integer rwid);

    int insert(rentwithdrawn record);

    rentwithdrawn selectByPrimaryKey(Integer rwid);
   
    List<rentwithdrawn> selectAll();

    List<rentwithdrawn> selectStateName(rentwithdrawn record);
    
    int updateByPrimaryKey(rentwithdrawn record);
    
    List<rentwithdrawn> selectRwState(String state);
}