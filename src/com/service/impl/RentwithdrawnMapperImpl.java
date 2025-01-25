package com.service.impl;
/**
 * 已退租记录Serviceimpl
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.Warning;
import com.dao.rentwithdrawnMapper;
import com.javabean.leaseinformation;
import com.javabean.rentwithdrawn;
import com.service.RentwithdrawnService;
@Service("rentwithdrawnService")
@Transactional
public class RentwithdrawnMapperImpl implements RentwithdrawnService {

	@Resource
	private rentwithdrawnMapper rentwithdrawnMapper;
	
	@Override
	public List<rentwithdrawn> queryAllStateName(String state1,String state2,String Name) {
		rentwithdrawn rentwithdrawn=new rentwithdrawn();
		rentwithdrawn.setState1(state1);
		rentwithdrawn.setState2(state2);
		rentwithdrawn.setRwusername(Name);
		return rentwithdrawnMapper.selectStateName(rentwithdrawn);
	}

	@Override
	public Warning deleteByPrimaryKey(Integer rwid) {
		return rentwithdrawnMapper.deleteByPrimaryKey(rwid)>0?new Warning(0, "删除成功!"):new Warning(2, "删除失败!");
	}

	@Override
	public List<rentwithdrawn> selectRwState(String state) {
		return rentwithdrawnMapper.selectRwState(state);
	}

}
