package com.dao;

import com.javabean.leaseimg;
import java.util.List;

public interface leaseimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(leaseimg record);

    leaseimg selectByPrimaryKey(Integer id);

    List<leaseimg> selectAll();

    int updateByPrimaryKey(leaseimg record);
}