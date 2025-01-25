package com.dao;

import com.javabean.registered;
import java.util.List;

public interface registeredMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(registered record);

    registered selectByPrimaryKey(Integer userid);

    List<registered> selectAll();

    int updateByPrimaryKey(registered record);
}