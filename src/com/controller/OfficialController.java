package com.controller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.currency.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javabean.leaseinformation;
import com.service.LeaseinformationService;

/**
 * 官网控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/officialmvc")
public class OfficialController {

	@Resource
	private LeaseinformationService leaseinformationService;

	/**
	 * 分页查询
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Msg listByPage(@RequestParam(value = "pn")Integer pn) {
		//设置分页传输
		PageHelper.startPage(pn,8);
		//查询所有可租凭数据
		List<leaseinformation> list1=leaseinformationService.selectState("可租凭");
		//使用PageInFo封装查询结果
		PageInfo<leaseinformation> pageInfo=new PageInfo<leaseinformation>(list1,5);
		return Msg.success().add("pageInfo",pageInfo);
	}
	
	/**
	 * 推荐分页
	 */
	@RequestMapping("/recommend")
	@ResponseBody
	public Msg recommend(@RequestParam(value = "pn",defaultValue="1") Integer pn,
	          @RequestParam(required=false,defaultValue="6") Integer pageSize) {
				PageHelper.startPage(pn,4);
				//查询所有数据
				List<leaseinformation> recommendlist1=leaseinformationService.selectRecommend();
				PageInfo pages=new PageInfo(recommendlist1, 3); 
				return Msg.success().add("pages",pages);
		
	}
	
	/**
	 * 搜索房屋地址或类型
	 * @return 
	 */
	@RequestMapping("/housequery")
	@ResponseBody
	public Msg housequery(@RequestParam(value = "pn",defaultValue="1")Integer pn,String queryValue) {
		//设置分页传输
		PageHelper.startPage(pn,8);
		//查询所有可租凭数据
		List<leaseinformation> list1=leaseinformationService.selectHouseQuery(queryValue);
		//使用PageInFo封装查询结果
		PageInfo<leaseinformation> pageInfo=new PageInfo<leaseinformation>(list1,5);
		return Msg.success().add("pageInfo",pageInfo);
	}
}
