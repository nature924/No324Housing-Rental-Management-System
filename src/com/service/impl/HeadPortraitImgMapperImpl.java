package com.service.impl;
import javax.annotation.Resource;

/**
 * 上传头像Serviceimpl
 */
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.headportraitimgMapper;
import com.javabean.headportraitimg;
import com.service.HeadPortraitImgService;
@Service("headPortraitImgService")
@Transactional
public class HeadPortraitImgMapperImpl implements HeadPortraitImgService{

	@Resource
	private headportraitimgMapper headportraitimgMapper;
	
	@Override
	public int updatauserimg(headportraitimg headportraitimg) {
		return headportraitimgMapper.updatauserimg(headportraitimg);
	}

	@Override
	public headportraitimg selectheadportrait(String user) {
		return headportraitimgMapper.selectheadportrait(user);
	}

	@Override
	public int insertuserimg(headportraitimg headportraitimg) {
		
		return headportraitimgMapper.insertuserimg(headportraitimg);
	}

	@Override
	public int deletuserimg(String name) {
		return headportraitimgMapper.deletuserimg(name);
	}
}
