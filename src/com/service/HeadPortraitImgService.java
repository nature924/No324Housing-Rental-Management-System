package com.service;

import com.javabean.headportraitimg;

public interface HeadPortraitImgService {
	int insertuserimg(headportraitimg headportraitimg);
	
	int updatauserimg(headportraitimg headportraitimg);
	
	int deletuserimg(String  name);
	
	headportraitimg selectheadportrait(String user);
}
