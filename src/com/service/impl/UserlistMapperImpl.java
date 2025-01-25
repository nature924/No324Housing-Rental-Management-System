package com.service.impl;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 用户Serviceimpl
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currency.Warning;
import com.dao.userlistMapper;
import com.javabean.fault;
import com.javabean.userlist;
import com.service.UserlistService;
@Service("userlistService")
@Transactional
public class UserlistMapperImpl implements UserlistService{

	@Resource
	private userlistMapper userlistMapper;

	@Override
	public userlist queryAllUserPwd(userlist record) {
		return userlistMapper.selectUserPwd(record);
	}

	@Override
	public userlist selectUserCall(String usercall) {
		return userlistMapper.selectUserCall(usercall);
	}

	@Override
	public List<userlist> selectUserNameWith(String username) {
		List<userlist> userlist=userlistMapper.selectUserNameWith(username);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(userlist temp:userlist) {
			String date1 = sdf.format(temp.getLeaseinformation().getHousestartingdate());
			String date2 = sdf.format(temp.getLeaseinformation().getHouseclosingdate());
			temp.getLeaseinformation().setHousestartingdatetemp(date1);
			temp.getLeaseinformation().setHouseclosingdatetemp(date2);
		}
		return userlist;
	}

	@Override
	public userlist selectUserCallWith(String housecall) {
		return userlistMapper.selectHouseCallWith(housecall);
	}
	@Override
	public int insert(userlist record) {	
		return userlistMapper.insert(record);
	}

	@Override
	public userlist selectUserPhone(String userphone) {
		return userlistMapper.selectUserPhone(userphone);
	}

	@Override
	public int updatepwd(userlist record) {
		
		return userlistMapper.updateByPrimaryKey(record);
	}

	@Override
	public Warning updateByPrimaryCall(userlist record) {
		if(record.getUsercall().equals("")&&record.getUsername().equals("")&&record.getUserid().equals("")&&record.getUserphone().equals("")) {
			return new Warning(1, "请输入真实姓名，身份证，手机号对应的有效值");
		}
		return userlistMapper.updateByPrimaryCall(record)>0?new Warning(0, "上传成功!"):new Warning(2, "上传失败!");
	}

	@Override
	public List<userlist> selectAll() {
		return userlistMapper.selectAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userlistMapper.deleteByPrimaryKey(id);
	}

	@Override
	public userlist selectUserId(Integer userid) {
		return userlistMapper.selectUserId(userid);
	}
	@Override
	public List<userlist> rentSelectAll() {
		return userlistMapper.rentSelectAll();
	}

	@Override
	public Warning updateJointTableName(userlist record) {
		if(record.getUsername().equals("")&&record.getUserid().equals("")&&record.getUserphone().equals("")) {
			return new Warning(1, "请输入真实姓名，身份证，手机号对应的有效值");
		}
		return userlistMapper.updateJointTableName(record)>0?new Warning(0, "修改成功!"):new Warning(2, "修改失败!");
	}

	@Override
	public String updateJointTabledelete(String username) {
		return userlistMapper.updateJointTabledelete(username)>0?"删除成功":"删除失败";
	}

	@Override
	public userlist selectUserName(String username) {
		return userlistMapper.selectUserName(username);
	}
}
