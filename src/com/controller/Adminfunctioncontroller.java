package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.currency.DocumentConversion;
import com.currency.Msg;
import com.currency.Warning;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javabean.QueryVo;
import com.javabean.checkoutapplication;
import com.javabean.fault;
import com.javabean.leaseimg;
import com.javabean.leaseinformation;
import com.javabean.mydailylife;
import com.javabean.rentcollection;
import com.javabean.rentwithdrawn;
import com.javabean.userlist;
import com.service.AdminListService;
import com.service.CheckoutapplicationService;
import com.service.FaultService;
import com.service.HeadPortraitImgService;
import com.service.LeaseimgService;
import com.service.LeaseinformationService;
import com.service.MydailylifeService;
import com.service.RentcollectionService;
import com.service.RentwithdrawnService;
import com.service.UserlistService;

@Controller
@RequestMapping("/admin")
public class Adminfunctioncontroller {

	@Resource
	private RentwithdrawnService rentwithdrawnService;

	@Resource
	private LeaseinformationService leaseinformationService;

	@Resource
	private CheckoutapplicationService checkoutapplicationService;

	@Resource
	private MydailylifeService mydailylifeService;
	@Resource
	private RentcollectionService rentcollectionService;
	@Resource
	private FaultService faultService;

	@Resource
	private UserlistService userlistService;
	@Resource
	private LeaseimgService leaseimgService;
	@Resource
	private HeadPortraitImgService headPortraitImgService;

	/**
	 * 注销
	 */
	@RequestMapping("/admincancel")
	public String cancellation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		System.out.println("注销成功");
		return "official";
	}

	@RequestMapping("/details")
	public ModelAndView listCategory(@RequestParam int pn) {
		ModelAndView mav = new ModelAndView("rentingdel");
		// 设置分页传输
		PageHelper.startPage(pn, 10);
		// 查询所有数据
		List<rentwithdrawn> list = rentwithdrawnService.selectRwState("已退租");
		// 使用PageInFo封装查询结果
		PageInfo<rentwithdrawn> pageInfo = new PageInfo<rentwithdrawn>(list, 5);
		// 放入转发参数
		mav.addObject("cs", pageInfo);
		return mav;
	}

	@RequestMapping("/delect")
	public ModelAndView delect(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("rentingdel");
		rentwithdrawnService.deleteByPrimaryKey(id);
		return mav;
	}

	@RequestMapping("/rentinglist")
	public ModelAndView listHouseState(@RequestParam int pn) {
		ModelAndView mav = new ModelAndView("rentinglist");
		// 设置分页传输
		PageHelper.startPage(pn, 10);
		// 查询所有数据
		List<leaseinformation> list = leaseinformationService.selecthousteaseWith("出租中");
		// 使用PageInFo封装查询结果
		PageInfo<leaseinformation> pageInfo = new PageInfo<leaseinformation>(list, 5);
		// 放入转发参数
		mav.addObject("cs", pageInfo);
		return mav;
	}

	@RequestMapping("/delectcontract")
	public ModelAndView delectcontract(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("rentinglist");
		leaseinformationService.updacontract(id);
		return mav;
	}

	/**
	 * 看房申请列表
	 */
	@RequestMapping("/houseapply")
	public ModelAndView kanfansqing(@RequestParam int pn) {
		ModelAndView mav = new ModelAndView("houseapply");
		// 设置分页传输
		PageHelper.startPage(pn, 10);
		// 查询所有数据
		List<checkoutapplication> list = checkoutapplicationService.selectCoaState();
		// 使用PageInFo封装查询结果
		PageInfo<checkoutapplication> pageInfo = new PageInfo<checkoutapplication>(list, 5);
		// 放入转发参数
		mav.addObject("cs", pageInfo);
		return mav;
	}

	/**
	 * 预约看房申请
	 */
	@RequestMapping("/tonyizp")
	public ModelAndView tonyizp(@RequestParam int id, String housecall, String name) throws ParseException {
		ModelAndView mav = new ModelAndView("houseapply");
		checkoutapplicationService.xgaiCoaState("已同意", id);
		leaseinformation house = leaseinformationService.selectHouseCall(housecall).get(0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);// 计算30天后的时间
		String t1 = df.format(new Date());
		String t2 = df.format(c.getTime());
		// 格式转换date格式
		Date date1 = df.parse(t1);
		Date date2 = df.parse(t2);
		house.setHousestartingdate(date1);
		house.setHouseclosingdate(date2);
		house.setHousestate("出租中");
		house.setUsername(name);
		leaseinformationService.updateByPrimaryKey(house);
		return mav;
	}

	@RequestMapping("/jujzp")
	public ModelAndView jujzp(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("houseapply");
		checkoutapplicationService.xgaiCoaState("已拒绝", id);
		return mav;
	}

	/**
	 *	退房申请
	 */
	@RequestMapping("/tzshenqing")
	public ModelAndView tzshenqing(@RequestParam int pn) {
		ModelAndView mav = new ModelAndView("housedel");
		// 设置分页传输
		PageHelper.startPage(pn, 10);
		// 查询所有数据
		List<checkoutapplication> list = checkoutapplicationService.selectCoaState1();
		// 使用PageInFo封装查询结果
		PageInfo<checkoutapplication> pageInfo = new PageInfo<checkoutapplication>(list, 5);
		// 放入转发参数
		mav.addObject("cs", pageInfo);
		return mav;
	}

	/**
	 * 删除退房记录
	 */
	@RequestMapping("/delecttzsq")
	public ModelAndView delecttzsq(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("housedel");
		checkoutapplicationService.deleteByPrimaryKey(id);
		return mav;
	}

	/**
	 * 同意退房
	 */
	@RequestMapping("/checkoutmvc")
	public ModelAndView checkoutmvc(@RequestParam int id,String housecall) {
		ModelAndView mav = new ModelAndView("housedel");
		String news=checkoutapplicationService.updateState("已同意", id);
		if(news.equals("同意退租成功!")) {
			System.out.println(news);
			System.out.println(leaseinformationService.updateCancelForeignKey(housecall));
		}
		return mav;
	}
	
	/**
	 * 拒绝退房
	 */
	@RequestMapping("/refusemvc")
	public ModelAndView refusemvc(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("housedel");
		System.out.println(checkoutapplicationService.updateState("已拒绝", id));
		return mav;
	}
	
	/**
	 * 分页查找所有用户
	 */
	@RequestMapping("/pagingselectuser")
	public String pagingselectuser(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(required = false, defaultValue = "6") Integer pageSize) {
		PageHelper.startPage(pn, 10);
		List<userlist> userlist = userlistService.selectAll();
		PageInfo<userlist> p = new PageInfo<userlist>(userlist, 3);
		model.addAttribute("p", p);
		return "account";
	}

	/**
	 * 删除用户信息
	 */
	@RequestMapping("/deletuser")
	public String deletuser(int id,String username,HttpServletRequest request) {
		userlistService.updateJointTabledelete(username);
		headPortraitImgService.deletuserimg(userlistService.selectUserId(id).getUsercall());
		userlistService.deleteByPrimaryKey(id);
		return "redirect:pagingselectuser.do";
	}

	/**
	 * 添加房源
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("/addhouse")
	public String addhouse(String housecall, String address, String area, String rent, String housetype, String[] state,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (housecall.equals("") || address.equals("") || area.equals("") || rent.equals("") || state.equals("")
				|| housetype.equals("")) {
			request.setAttribute("erro", "输入房源信息不能缺少任意一项!");
			return "housingadd";
		}
		List<leaseinformation> list = leaseinformationService.queryAll();
		for (leaseinformation leaseinformation : list) {
			if (housecall.equals(leaseinformation.getHousecall())) {
				request.setAttribute("erro", "该房源编号已存在");
				return "housingadd";
			}
		}
		String path = "";
		String imgname = "";
		if (!file.isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = file.getContentType();
			// 获得文件后缀名称
			String imageName = contentType.substring(contentType.indexOf("/") + 1);
			path = "C://cnqf/leaseimg/" + uuid + "." + imageName;
			file.transferTo(new File(path));
			imgname = uuid + "." + imageName;
		}
		leaseimg img = new leaseimg();
		img.setImgname(address);
		img.setImgroute(imgname);
		leaseimgService.insert(img);
		int id = leaseimgService.selectAll().get(leaseimgService.selectAll().size() - 1).getId();
		leaseinformation house = new leaseinformation();
		house.setHouseaddress(address);
		house.setHousesize(Double.valueOf(area));
		house.setHousemoney(rent);
		house.setHousestate(state[0]);
		house.setHousecall(housecall);
		//获取当前时间和一个月后的时间
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String HouseStartingDate=sdf.format(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 30);
		String HouseClosingDate=sdf.format(cal.getTime());
		house.setHousestartingdate(date);
		house.setHouseclosingdate(cal.getTime());
		house.setHousestartingdatetemp(HouseStartingDate);
		house.setHouseclosingdatetemp(HouseClosingDate);
		house.setId(id);
		house.setHousetype(housetype);
		house.setHouserecommend("未设置");
		leaseinformationService.addHouse(house);
		request.setAttribute("sessce", "添加成功");
		return "housingadd";
	}

	/**
	 * 分页展示房源信息
	 */
	@RequestMapping("/pagingselecthouse")
	public String pagingselecthouse(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(required = false, defaultValue = "6") Integer pageSize) {
		PageHelper.startPage(pn, 10);
		List<leaseinformation> leaseinformation = leaseinformationService.queryAll();
		PageInfo<leaseinformation> p = new PageInfo<leaseinformation>(leaseinformation, 3);

		model.addAttribute("p", p);
		return "housinglist";
	}

	/**
	 * 获取修改房源信息
	 */
	@RequestMapping("/getupdatehouse")
	public String getupdatehouse(int houseid, HttpServletRequest request) {
		List<leaseinformation> house = leaseinformationService.queryID(houseid);
		request.setAttribute("uphouse", house);
		return "houseupdate";
	}

	/**
	 * 修改房源信息
	 */
	@RequestMapping("/updatehouse")
	public String updatehouse(Integer houseid, String housetype, String address, String area, String rent, String state,
			HttpServletRequest request) {
		leaseinformation house = leaseinformationService.queryID(houseid).get(0);
		request.removeAttribute("uphouse");
		house.setHouseaddress(address);
		house.setHousemoney(rent);
		house.setHousetype(housetype);
		house.setHousesize(Double.valueOf(area));
		house.setHousestate(state);
		house.setHouseid(houseid);
		leaseinformationService.updateByPrimaryKey(house);
		request.setAttribute("sessce", "修改成功");
		request.setAttribute("newhouse", house);
		return "houseupdate";
	}

	/**
	 * 删除房源信息
	 */
	@RequestMapping("/delethouse")
	public String delethouse(int houseid, HttpServletRequest request) {
		if (houseid >= 0) {
			int id = leaseinformationService.queryID(houseid).get(0).getId();

			leaseinformationService.deleteByPrimaryKey(houseid);
			leaseimgService.deleteByPrimaryKey(id);
		}
		return "redirect:pagingselecthouse.do";
	}

	/*
	 * 推荐房屋列表
	 */
	@RequestMapping("/recommendlist")
	public String recommendlist(Model model, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(required = false, defaultValue = "6") Integer pageSize) {
		PageHelper.startPage(pn, 10);
		List<leaseinformation> leaseinformation = leaseinformationService.selectAllLeasable();
		PageInfo<leaseinformation> p = new PageInfo<leaseinformation>(leaseinformation, 3);
		model.addAttribute("p", p);
		return "recommendhouse";
	}

	/**
	 * 修改推荐信息
	 */
	@RequestMapping("/updaterecommend")
	public String updatehouse(Integer houseid) {
		leaseinformation house = leaseinformationService.queryID(houseid).get(0);
		if (house.getHouserecommend().equals("未推荐")) {
			house.setHouserecommend("已推荐");
		} else {
			house.setHouserecommend("未推荐");
		}
		leaseinformationService.updateByPrimaryKey(house);
		return "redirect:recommendlist.do?";
	}

	/**
	 * 分页查询日程信息
	 */
	@RequestMapping("/schedulelist")
	public String mydailylifelist(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<mydailylife> mydailylifes = mydailylifeService.selectAll();
		PageInfo<mydailylife> page = new PageInfo<mydailylife>(mydailylifes, 3);
		model.addAttribute("p", page);
		return "schedulelist";
	}

	/**
	 * 添加日程
	 */
	@RequestMapping("/addmydailylife")
	public String mydailylifeadd(mydailylife mydailylife) {
		mydailylifeService.insert(mydailylife);
		return "redirect:/admin/schedulelist.do";
	}

	/**
	 * 修改日程
	 */
	@RequestMapping("/updatemydailylife")
	public String mydailylifeupdate1(Integer id, HttpServletRequest request) {
		mydailylife mydailylife = mydailylifeService.selectByPrimaryKey(id);
		request.setAttribute("mydailylife", mydailylife);
		return "scheduleupdate";
	}

	@RequestMapping("/toupdate")
	public String mydailylifeupdate2(mydailylife mydailylife) {
		mydailylifeService.updateByPrimaryKey(mydailylife);
		return "redirect:/admin/schedulelist.do";
	}

	/**
	 * 删除日程
	 */
	@RequestMapping("/delmydailylife")
	public String mydailylifedel(Integer id) {
		mydailylifeService.deleteByPrimaryKey(id);
		return "redirect:/admin/schedulelist.do";
	}

	// 报障
	/**
	 * 查询待处理报障
	 */
	@RequestMapping("/Adminselectrepairwait")
	public String selectrepairwait(String state, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		state = "未处理";
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<fault> faultlist = faultService.AdminSelectStateAll(state);
		PageInfo<fault> page = new PageInfo<fault>(faultlist, 3);
		model.addAttribute("p", page);
		return "repairwait";
	}

	/**
	 * 已完成全部报障
	 */
	@RequestMapping("/Adminselectrepairdone")
	public String selectrepairdone(String state, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		state = "已处理";
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<fault> faultdone = faultService.AdminSelectStateAll(state);
		PageInfo<fault> page = new PageInfo<fault>(faultdone, 3);
		model.addAttribute("p", page);
		return "repairdone";
	}

	/**
	 * 报障状态修改
	 */
	@RequestMapping("/adminrepairwait")
	public String updaterepairwait(Integer id) {
		fault fault = faultService.selectByPrimaryKey(id);
		String fhouseid = fault.getFhouseid();
		String fhouseaddress = fault.getFhouseaddress();
		Double fprice = fault.getFprice();
		Date fdate = fault.getFdate();
		String fcontent = fault.getFcontent();
		String fusername = fault.getFusername();
		String fuserid = fault.getFuserid();
		String fuserphone = fault.getFuserphone();
		String fstate = "已处理";
		fault f = new fault(fhouseid, fhouseaddress, fprice, fdate, fcontent, fusername, fuserid, fuserphone, fstate,
				id);
		faultService.updateByPrimaryKey(f);
		return "redirect:/admin/Adminselectrepairwait.do";
	}

	/**
	 * 报障删除
	 */
	@RequestMapping("/adminrepairdone")
	public String delrepair(Integer id) {
		faultService.deleteByPrimaryKey(id);
		return "redirect:/admin/Adminselectrepairdone.do";
	}

	/**
	 * 搜索报障
	 */
	@RequestMapping("/repairselect")
	public String repairselect(QueryVo vo, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<fault> faultdone = faultService.repairselect(vo);
		for (fault temp : faultdone) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(temp.getFdate());
			temp.setFdatetemp(date);
		}
		PageInfo<fault> page = new PageInfo<fault>(faultdone, 3);
		model.addAttribute("p", page);
		model.addAttribute("vo", vo);
		return "repairdone";
	}

	/**
	 * 我要收租
	 */
	@RequestMapping("/adminrentshou")
	public String rentshou(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<userlist> userlists = userlistService.rentSelectAll();
		PageInfo<userlist> page = new PageInfo<userlist>(userlists, 3);
		model.addAttribute("rent", page);
		return "rentshou";
	}

	/**
	 * 获取收租信息
	 */
	@RequestMapping("/adminrentselect")
	public String rentadd(String housecall, Model model) {
		userlist userlist = userlistService.selectUserCallWith(housecall);
		model.addAttribute("addrent", userlist);
		return "rentadd";
	}

	/**
	 * 添加代缴租金
	 */
	@RequestMapping("/adminrentadd")
	public String rentaddwait(rentcollection rentcollection) {
		rentcollectionService.insert(rentcollection);
		return "redirect:/admin/adminrentshou.do";
	}

	/**
	 * 代缴租金
	 */
	@RequestMapping("/adminrentwait")
	public String rentwait(String rcstate, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		rcstate = "未缴纳";
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<rentcollection> rentlists = rentcollectionService.selectPaidStateAll(rcstate);
		PageInfo<rentcollection> page = new PageInfo<rentcollection>(rentlists, 3);
		model.addAttribute("rent", page);
		return "rentwait";
	}

	/**
	 * 删除租金缴纳记录
	 */
	@RequestMapping("/admindelrent")
	public String delrent(Integer id) {
		rentcollectionService.deleteByPrimaryKey(id);
		return "redirect:/admin/adminselectPaidAll.do";
	}

	/**
	 * 搜索查询
	 */
	@RequestMapping("/adminselectPaidAll")
	public String adminselectPaidAll(QueryVo vo, @RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		// 引用PageHelper分页插件
		PageHelper.startPage(pn, 10);
		List<rentcollection> rentlists = rentcollectionService.selectPaidAll(vo);
		for (rentcollection temp : rentlists) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(temp.getRcdate());
			temp.setRcdatetemp(date);
			if(temp.getRcpaiddate()!=null) {
				String Rcpaiddate = sdf.format(temp.getRcpaiddate());
				temp.setRcpaiddatetemp(Rcpaiddate);
			}
			
		}
		PageInfo<rentcollection> page = new PageInfo<rentcollection>(rentlists, 3);
		model.addAttribute("rent", page);
		model.addAttribute("vo", vo);
		return "rentdone";
	}

	/**
	 * 查看合同
	 */
	@RequestMapping("/viewcontractadmin")
	public ModelAndView viewcontractadmin(String username, String userid, String houseaddress,
			String housestartingdatetemp, String houseclosingdatetemp, String housemoney, String userphone,
			String houseid, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("rentinglist");
		String arraytemp[] = { username, userid, houseaddress, housestartingdatetemp, houseclosingdatetemp, housemoney,
				userphone, houseid };
		System.out.println(Arrays.toString(arraytemp));
		String temp = arraytemp[7] + "pdf.pdf";
		File filetemp = new File("C://cnqf/contract/pdf/" + temp);
		if (!filetemp.exists()) {
			System.out.println(new DocumentConversion().DocumentGeneration(arraytemp));
			new DocumentConversion().PdfGeneration(arraytemp[7]);
			filetemp = new File("C://cnqf/contract/pdf/" + temp);
		}

		String pdf = filetemp.getName();
		// 放入转发参数
		mav.addObject("pdftemp", pdf);

		return mav;
	}
}
