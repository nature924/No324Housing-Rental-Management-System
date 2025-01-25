package com.dao;

import com.javabean.QueryVo;
import com.javabean.fault;
import java.util.List;

public interface faultMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(fault record);

    fault selectByPrimaryKey(Integer fid);

    List<fault> selectAll();
    
    List<fault> selectRepairStateNameAll(fault record);

    int updateByPrimaryKey(fault record);
    

    /**
     * 管理员待处理报障查询
     * */
    List<fault> AdminSelectStateAll(fault record);
    
    List<fault> repairselect(QueryVo vo);
}