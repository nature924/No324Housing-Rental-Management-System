package com.controller;

import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.code.Code;
import com.currency.Koken;
import com.javabean.adminlist;
import com.javabean.checkoutapplication;
import com.javabean.headportraitimg;
import com.javabean.userlist;
import com.service.AdminListService;
import com.service.CheckoutapplicationService;
import com.service.HeadPortraitImgService;
import com.service.UserlistService;

/**
 * 用户控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userlistmvc")
public class UserListController {

	private static final long serialVersionUID = -884689940866074733L;

	@Resource
	private UserlistService userlistService;

	@Resource
	private AdminListService adminListService;

	@Resource
	private HeadPortraitImgService headPortraitImgService;

	@Resource
	private CheckoutapplicationService checkoutapplicationService;

	/**
	 * 登录
	 */
	@RequestMapping("/userpwd")
	public String userpwd(String username, String pwd, String[] identity, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (username.equals("") || pwd.equals("")) {
			request.setAttribute("erorr", "输入账号密码不能为空!");
			return "login";
		}

		String tempstr = null;

		try {
			if (identity[0].equals("user")) {
				userlist temp = new userlist();
				temp.setUsercall(username);
				temp.setUserpwd(pwd);
				userlist userlist = userlistService.queryAllUserPwd(temp);
				try {
					tempstr = userlist.getUsercall();
					if (tempstr != null) {
						session.setAttribute("user", tempstr);
						headportraitimg headportraitimg = headPortraitImgService.selectheadportrait(tempstr);
						if (headportraitimg.getHeadportraitimgaddress() != null) {
							session.setAttribute("headportraitimg", headportraitimg.getHeadportraitimgaddress());
						}
						return "official";
					}
				} catch (NullPointerException e) {
					if (tempstr == null) {
						request.setAttribute("erorr", "输入账号密码有误!");
						return "login";
					} else {
						return "official";
					}
				}
			}
			if (identity[0].equals("admin")) {
				adminlist temp = new adminlist();
				temp.setAdminname(username);
				temp.setAdminpwd(pwd);
				adminlist adminlist = adminListService.findAllAdminPwd(temp);
				try {
					tempstr = adminlist.getAdminname();
					if (tempstr != null) {
						session.setAttribute("admin", tempstr);
						return "BackgroundHome";
					}
				} catch (NullPointerException e) {
					request.setAttribute("erorr", "输入账号密码有误!");
					return "login";
				}
			}
		} catch (NullPointerException e) {
			request.setAttribute("erorr", "选择登录方式!");
			e.printStackTrace();
			return "login";
		}

		return "login";
	}

	/**
	 * 注册
	 */
	@RequestMapping("/register")
	public String register(String usercall, String userpwd, String userphone, HttpServletRequest request) {
		if (usercall.equals("") || userpwd.equals("") || userphone.equals("")) {
			request.setAttribute("erorr", "输入账号密码不能为空!");
			return "register";
		}
		userlist user = new userlist();
		user.setUsercall(usercall);
		user.setUserphone(userphone);
		user.setUserpwd(userpwd);
		userlistService.insert(user);
		headportraitimg userimg = new headportraitimg();
		userimg.setHeadportraitimgusername(usercall);
		headPortraitImgService.insertuserimg(userimg);
		return "login";
	}

	/**
	 * 获取手机验证码
	 **/
	@RequestMapping("/getcode")
	public void getcode(String userphone, HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = request.getSession();
			String code = "123456";
//			String code = Code.getNum(userphone);
			System.out.println(code);
			session.setAttribute("code", code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 判断验证码输入后登陆
	 **/
	@RequestMapping("/phonecod")
	public String phonecod(String userphone, String code, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (userphone.equals("") || code.equals("")) {
			request.setAttribute("erorr", "手机号或者验证码为空!");
			return "login";
		}
		System.out.println(code);
		if (code.equals(session.getAttribute("code"))) {
			userlist user = userlistService.selectUserPhone(userphone);
			if (user != null) {
				String tempstr = null;
				userlist userlist = userlistService.selectUserPhone(userphone);
				tempstr = userlist.getUsercall();
				if (tempstr != null) {
					session.setAttribute("user", tempstr);
					headportraitimg headportraitimg = headPortraitImgService.selectheadportrait(tempstr);
					if (headportraitimg.getHeadportraitimgaddress() != null) {
						session.setAttribute("headportraitimg", headportraitimg.getHeadportraitimgaddress());
					}
					return "official";
				}
			} else {
				request.setAttribute("erorr", "该手机号未注册！");
				return "login";
			}
		} else {
			request.setAttribute("erorr", "验证码错误!");
			return "login";
		}
		return "login";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping("/updatepwd")
	public String updatepwd(String code, String userphone, String userpwd, HttpServletRequest request) {
		if (code.equals("") || userphone.equals("") || userpwd.equals("")) {
			request.setAttribute("erorr", "手机号，验证码，新密码不能为空!");
			return "updatepwd";
		}
		HttpSession session = request.getSession();
		if (code.equals(session.getAttribute("code"))) {
			userlist userlist = userlistService.selectUserPhone(userphone);
			userlist.setUserpwd(userpwd);
			userlistService.updatepwd(userlist);
			return "login";
		}
		return userpwd;
	}

	/**
	 * 注销
	 */
	@RequestMapping("/cancellation")
	public String cancellation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		System.out.println("注销成功");
		return "official";
	}

	/**
	 * 申请看房
	 */
	@RequestMapping("/apply")
	@ResponseBody
	public ModelAndView apply(HttpSession session, HttpServletRequest request, String housemoney, String housecall,
			String houseaddress,String housesize) {
		ModelAndView mav = new ModelAndView("official");
		//令牌验证
		if(!new Koken().kokenid(request, session)) {
			return mav;	
		}
		mav.addObject("news", "official");
		if ((String) session.getAttribute("user") == null) {
			mav.addObject("apply", "请先登录!");
			return mav;
		}
		// 查询所有数据
		userlist user = userlistService.selectUserCall((String) session.getAttribute("user"));
		if (user.getUsername() == null) {// 判断真实姓名是否为空
			mav.addObject("apply", "请绑定真实姓名后再租赁房屋!");
			return mav;
		} else {
			checkoutapplication coa = new checkoutapplication();
			coa.setCoausername(user.getUsername());
			coa.setCoauserid(user.getUserid());
			coa.setCoauserphone(user.getUserphone());
			coa.setCoahouseid(housecall);
			coa.setCoahouseaddress(houseaddress);
			coa.setCoahouseprice(Double.parseDouble(housemoney));
			coa.setCoahousesize(Double.parseDouble(housesize));
			coa.setCoastate("看房申请中");
			String temp=checkoutapplicationService.insertApply(coa);
			mav.addObject("apply", temp);
		}
		return mav;
	}

}
