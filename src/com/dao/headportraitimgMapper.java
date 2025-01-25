package com.dao;

import com.javabean.headportraitimg;

public interface headportraitimgMapper {
	int insertuserimg(headportraitimg headportraitimg);
	int deletuserimg(String  name);
	int updatauserimg(headportraitimg headportraitimg);
	
	headportraitimg selectheadportrait(String userCall);
}
