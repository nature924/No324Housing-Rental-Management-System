package com.service.impl;
/**
 * 报障Serviceimpl
 */
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.Warning;
import com.dao.faultMapper;
import com.javabean.QueryVo;
import com.javabean.fault;
import com.service.FaultService;
@Service("faultService")
@Transactional
public class FaultMapperImpl implements FaultService {

	@Resource
	private faultMapper faultMapper;

	@Override
	public List<fault> queryAllState(String str,String name) {
		fault fault=new fault();
		fault.setFstate(str);
		fault.setFusername(name);
		List<fault> templist=faultMapper.selectRepairStateNameAll(fault);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(fault temp:templist) {
			String date = sdf.format(temp.getFdate());
			temp.setFdatetemp(date);
		}
		return templist;
	}

	@Override
	public Warning deleteByPrimaryKey(Integer fid) {
		return faultMapper.deleteByPrimaryKey(fid)>0?new Warning(0, "删除成功!"):new Warning(2, "删除失败!");
	}

	@Override
	public Warning insert(fault record) {
		return faultMapper.insert(record)>0?new Warning(0, "报障成功!"):new Warning(2, "报障失败");
	}

	@Override
	public List<fault> AdminSelectStateAll(String state) {
		fault fault = new fault();
		fault.setFstate(state);
		List<fault> faults = faultMapper.AdminSelectStateAll(fault);
		for(fault temp:faults) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(temp.getFdate());
			temp.setFdatetemp(date);
		}
		return faults;
	}

	@Override
	public fault selectByPrimaryKey(Integer fid) {
		return faultMapper.selectByPrimaryKey(fid);
	}

	@Override
	public int updateByPrimaryKey(fault record) {
		
		return faultMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<fault> repairselect(QueryVo vo) {
		List<fault> list= faultMapper.repairselect(vo);
		return list;
	}
	
}
