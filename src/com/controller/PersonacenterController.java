package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.currency.DocumentConversion;
import com.currency.Koken;
import com.currency.Msg;
import com.currency.Warning;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javabean.checkoutapplication;
import com.javabean.fault;
import com.javabean.headportraitimg;
import com.javabean.rentcollection;
import com.javabean.rentwithdrawn;
import com.javabean.userlist;
import com.service.CheckoutapplicationService;
import com.service.FaultService;
import com.service.HeadPortraitImgService;
import com.service.LeaseinformationService;
import com.service.RentcollectionService;
import com.service.RentwithdrawnService;
import com.service.UserlistService;

/**
 * 个人中心控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/personacentermvc")
public class PersonacenterController {

	@Resource
	private RentwithdrawnService rentwithdrawnService;

	@Resource
	private UserlistService userlistService;

	@Resource
	private LeaseinformationService leaseinformationService;

	@Resource
	private CheckoutapplicationService checkoutapplicationService;

	@Resource
	private RentcollectionService rentcollectionService;

	@Resource
	private FaultService faultService;

	@Resource
	private HeadPortraitImgService headPortraitImgService;

	/**
	 * 个人信息切换页面
	 */
	@RequestMapping("/personal_switch")
	public void temp(String txt, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		switch (txt) {
		case "租赁信息":
			response.getWriter().print("/jsp/personalInformation/information.jsp");
			break;
		case "我的申请":
			response.getWriter().print("/jsp/personalInformation/myapplication.jsp");
			break;
		case "代缴租金":
			response.getWriter().print("/jsp/personalInformation/rentpayment.jsp");
			break;
		case "报障模块":
			response.getWriter().print("/jsp/personalInformation/faultreportingmodule.jsp");
			break;
		case "其他操作":
			response.getWriter().print("/jsp/personalInformation/otheroperations.jsp");
			break;
		}
	}

	/**
	 * 我的租赁分页查询
	 */
	@RequestMapping("/myRentalList")
	@ResponseBody
	public Msg myRentalList(@RequestParam(value = "pn") Integer pn, HttpSession session) {
		// 查询所有数据
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		// 设置分页传输
		PageHelper.startPage(pn, 8);
		List<userlist> leaseuser = userlistService.selectUserNameWith(user.getUsername());
		// 使用PageInFo封装查询结果
		PageInfo<userlist> pageInfo = new PageInfo<userlist>(leaseuser, 3);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 已退租赁记录分页查询
	 */
	@RequestMapping("/refundedLeaseList")
	@ResponseBody
	public Msg refundedLeaseList(@RequestParam(value = "pn") Integer pn, HttpSession session) {
		// 查询所有数据
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		// 设置分页传输
		PageHelper.startPage(pn, 8);
		List<rentwithdrawn> list = rentwithdrawnService.queryAllStateName("已退租", "", user.getUsername());

		// 使用PageInFo封装查询结果
		PageInfo<rentwithdrawn> pageInfo = new PageInfo<rentwithdrawn>(list, 3);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 申请状态记录分页查询
	 */
	@RequestMapping("/applicationAtatusList")
	@ResponseBody
	public Msg applicationAtatusList(@RequestParam(value = "pn") Integer pn, boolean flag, HttpSession session) {
		List<checkoutapplication> list = null;
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		// 设置分页传输
		PageHelper.startPage(pn, 8);
		// 查询所有数据
		if (flag) {
			list = checkoutapplicationService.selectStateAll("看房申请中", "退房申请中", "", user.getUsername());
		} else {
			list = checkoutapplicationService.selectStateAll("已拒绝", "已同意", "已取消", user.getUsername());
		}

		// 使用PageInFo封装查询结果
		PageInfo<checkoutapplication> pageInfo = new PageInfo<checkoutapplication>(list, 3);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 代缴租金分页查询
	 */
	@RequestMapping("/rentpaymentList")
	@ResponseBody
	public Msg rentpaymentList(@RequestParam(value = "pn") Integer pn, String state, HttpSession session) {
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		// 设置分页传输
		PageHelper.startPage(pn, 8);
		List<rentcollection> list = rentcollectionService.queryPaidStateAll(state, user.getUsername());
		// 使用PageInFo封装查询结果
		PageInfo<rentcollection> pageInfo = new PageInfo<rentcollection>(list, 3);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 缴纳租金
	 */
	@RequestMapping("/payrentmvc")
	public ModelAndView payrentmvc(String rchousemoney,Integer rcid,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = rentcollectionService.updateState(rcid);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}
	
	/**
	 * 已缴纳租金删除记录
	 */
	@RequestMapping("/paidrent")
	public ModelAndView paidrent(Integer rcid,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = rentcollectionService.deleteByPrimaryKey(rcid);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 共缴费费用
	 */
	@RequestMapping("/copaymentfee")
	@ResponseBody
	public Msg copaymentfee(String state, HttpSession session) {
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		List<rentcollection> list = rentcollectionService.queryPaidStateAll(state, user.getUsername());
		int num = 0;
		for (rentcollection temp : list) {
			num += Float.parseFloat(temp.getRchousemoney());
		}
		return Msg.success().add("num", num);
	}

	/**
	 * 报障分页查询
	 */
	@RequestMapping("/repairList")
	@ResponseBody
	public Msg repairList(@RequestParam(value = "pn") Integer pn, String str, HttpSession session) {
		// 使用PageInFo封装查询结果
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		// 设置分页传输
		PageHelper.startPage(pn, 8);
		if (str.equals("我要报障")) {
			List<userlist> leaseuser = userlistService.selectUserNameWith(user.getUsername());
			PageInfo<userlist> pageInfo = new PageInfo<userlist>(leaseuser, 3);
			return Msg.success().add("pageInfo", pageInfo);
		}

		List<fault> list = faultService.queryAllState(str, user.getUsername());
		PageInfo<fault> pageInfo = new PageInfo<fault>(list, 3);

		return Msg.success().add("pageInfo", pageInfo);
	}

	/**
	 * 报障提交内容
	 * 
	 * @throws ParseException
	 */
	@RequestMapping("/contentofthereport")
	public ModelAndView contentofthereport(String date, String housecall, String contentofthe,String token,HttpServletRequest request,HttpSession session) throws ParseException {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		userlist user = userlistService.selectUserCallWith(housecall);
		fault fault = new fault();
		fault.setFhouseid(housecall);
		fault.setFhouseaddress(user.getLeaseinformation().getHouseaddress());
		fault.setFprice(Double.parseDouble(user.getLeaseinformation().getHousemoney()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date t1 = sdf.parse(date);
		fault.setFdate(t1);
		fault.setFdatetemp(date);
		fault.setFcontent(contentofthe);
		fault.setFusername(user.getUsername());
		fault.setFuserid(user.getUserid());
		fault.setFuserphone(user.getUserphone());
		fault.setFstate("未处理");
		Warning news = faultService.insert(fault);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 报障删除记录
	 */
	@RequestMapping("/deleterepair")
	public ModelAndView deleterepair(Integer fid,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = faultService.deleteByPrimaryKey(fid);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 头像上传 用户真实姓名，身份证号，手机号上传
	 * 
	 * @throws FileNotFoundException
	 */
	@RequestMapping("/file")
	public ModelAndView file(String username,String userid,String userphone,HttpServletRequest request,HttpSession session,@RequestParam MultipartFile file) throws Exception {
		System.out.println(username);
		
		ModelAndView mav = new ModelAndView("personacenter");
		userlist usere=userlistService.selectUserName(username);
		if (usere==null) {
			session.setAttribute("modifyerro",null);
			System.out.println("可修改");
		}else {
			Warning news=new Warning(2, "修改失败!该姓名用户已注册");
			mav.addObject("news", news);
			return mav;
		}
		
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		// 获取文件的名称
		String fName = file.getOriginalFilename();
		System.out.println(fName);
		if (!fName.equals("")) {
			// 保存图片的目录
			String path = "C://cnqf/headPortraitImg";
			File filepath = new File(path);
			// 如果目录不存在，创建
			if (!filepath.exists()) {
				filepath.mkdir();
			}

			File f = new File(path, fName);

			// 更改用户头像
			headportraitimg headportraitimg = new headportraitimg();
			String user = (String) session.getAttribute("user");
			headportraitimg.setHeadportraitimgusername(user);
			headportraitimg.setHeadportraitimgaddress(fName);
			// 图片路径上传到数据库
			headPortraitImgService.updatauserimg(headportraitimg);
			// 更换头像
			session.setAttribute("headportraitimg", headportraitimg.getHeadportraitimgaddress());
			// 上传文件
			file.transferTo(f);
		}

		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		//暂时储存需要修改的真实姓名
		String rcusernametemp=user.getUsername();
		//判断，如有真实姓名联表修改，则添加
		if(user.getUsername()==null||"".equals(user.getUsername())) {
			// 上传真实姓名，身份证，手机号
			userlist userlist = new userlist();
			userlist.setUsercall((String) session.getAttribute("user"));
			userlist.setUsername(username);
			userlist.setUserid(userid);
			userlist.setUserphone(userphone);
			Warning news = userlistService.updateByPrimaryCall(userlist);
			System.out.println(news.getWarningContent());
			// 放入转发参数
			mav.addObject("news", news);
		}else {
			// 修改真实姓名，身份证，手机号
			userlist userlist = new userlist();
			userlist.setUsername(username);
			userlist.setUserid(userid);
			userlist.setUserphone(userphone);
			userlist.setUsernametemp(user.getUsername());
			Warning news = userlistService.updateJointTableName(userlist);
			//修改租金真实姓名
			System.out.println(rentcollectionService.updateUserName(username,rcusernametemp));
			System.out.println(news.getWarningContent());
			// 放入转发参数
			mav.addObject("news", news);
		}

		return mav;
	}

	/**
	 * 删除已退租记录
	 */
	@RequestMapping("/deleterentrefund")
	public ModelAndView deleterentrefund(Integer rwid,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = rentwithdrawnService.deleteByPrimaryKey(rwid);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 查看合同
	 */
	@RequestMapping("/viewcontract")
	public ModelAndView viewcontract(String username, String userid, String houseaddress, String housestartingdatetemp,
			String houseclosingdatetemp, String housemoney, String userphone, String houseid,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		String arraytemp[] = { username, userid, houseaddress, housestartingdatetemp, houseclosingdatetemp, housemoney,
				userphone, houseid };
		String temp = (arraytemp[0]+arraytemp[7]) + "pdf.pdf";
		File filetemp = new File("C://cnqf/contract/pdf/" + temp);
		if (!filetemp.exists()) {
//			System.out.println(new DocumentConversion().DocumentGeneration(arraytemp));
			new DocumentConversion().PdfGeneration((arraytemp[0]+arraytemp[7]));
			filetemp = new File("C://cnqf/contract/pdf/" + temp);
		}
		
		String pdf = filetemp.getName();
		// 放入转发参数
		mav.addObject("pdftemp", pdf);

		return mav;
	}

	/**
	 * 终止合同
	 */
	@RequestMapping("/termination")
	public ModelAndView termination(String call,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		userlist leaseuser = userlistService.selectUserCallWith(call);
		Warning news = checkoutapplicationService.insert(leaseuser);
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 终止申请
	 */
	@RequestMapping("/stopapplying")
	public ModelAndView stopapplying(String call,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = checkoutapplicationService.updateCallState("已取消", call);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}

	/**
	 * 删除申请记录
	 */
	@RequestMapping("/deleterecord")
	public ModelAndView deleterecord(Integer coaid,String token,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("personacenter");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		Warning news = checkoutapplicationService.deleteByPrimaryKey(coaid);
		System.out.println(news.getWarningContent());
		// 放入转发参数
		mav.addObject("news", news);
		return mav;
	}
}
