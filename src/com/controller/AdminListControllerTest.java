package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javabean.adminlist;
import com.javabean.leaseinformation;
import com.service.AdminListService;
import com.service.LeaseinformationService;

@Controller
@RequestMapping("/adminmvc")
public class AdminListControllerTest {

	@Resource
	private AdminListService adminListService;
	
	@Resource
	private LeaseinformationService leaseinformationService;
	
	@RequestMapping("/official")
	public String official() {
		return "official";
	}
	
	@RequestMapping("/test")
	public void test() {
		adminlist adminlist=adminListService.findAll(1);
		System.out.println(adminlist.getAdminname());
		System.out.println(adminlist.getAdminpwd());
	}
	
	/**
	 * 批量添加楼房
	 */
	@RequestMapping("/add")
	public void add() {
		leaseinformation leaseinformation=new leaseinformation();
		for(int i=2;i<100;i++) {
			leaseinformation.setHouseaddress("南宁市江南区银象路"+i+"号");
			leaseinformation.setHousetype("楼房");
			leaseinformation.setHousesize(70.2);
			leaseinformation.setHousemoney("3500");
			leaseinformation.setHousestate("可出租");
			
			leaseinformationService.addHouse(leaseinformation);
		}
		System.out.println("添加成功");
	}
	
	/**
	 * 个人信息切换页面测试
	 * @throws IOException 
	 */
	@RequestMapping("/temp")
	public void temp(String txt,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		if(txt.equals("租赁信息")) {
			response.getWriter().print("/jsp/personalInformation/temp.jsp");
		}
	}
}
