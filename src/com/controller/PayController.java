package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabean.AlipayConfig;
import com.javabean.headportraitimg;
import com.service.HeadPortraitImgService;
import com.service.RentcollectionService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.currency.Warning;

@Controller
@RequestMapping("/alipaymvc")
public class PayController {

	@Resource
	private RentcollectionService rentcollectionService;
	
	@Resource
	private HeadPortraitImgService headPortraitImgService;
	
	/**
	 * 回调并缴纳租金
	 */
	@RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
	public ModelAndView returnUrl(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException, AlipayApiException {
		session.setAttribute("user", AlipayConfig.usercall);
		headportraitimg headportraitimg = headPortraitImgService.selectheadportrait(AlipayConfig.usercall);
		if (headportraitimg.getHeadportraitimgaddress() != null) {
			session.setAttribute("headportraitimg", headportraitimg.getHeadportraitimgaddress());
		}
		ModelAndView mav = new ModelAndView("redirect:/jsp/personacenter.jsp");
	    // 获取支付宝GET过来反馈信息
	    Map<String, String> params = new HashMap<String, String>();
	    Map<String, String[]> requestParams = request.getParameterMap();
	    for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
	        String name = (String) iter.next();
	        String[] values = (String[]) requestParams.get(name);
	        String valueStr = "";
	        for (int i = 0; i < values.length; i++) {
	            valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
	        }
	        // 乱码解决，这段代码在出现乱码时使用
	        valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
	        params.put(name, valueStr);
	    }

	    System.out.println(params);//查看参数都有哪些
	    boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,  AlipayConfig.sign_type); // 调用SDK验证签名
	    //验证签名通过
	    if(signVerified){
	        // 商户订单号
	        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
	        
	        // 支付宝交易号
	        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
	        
	        // 付款金额
	        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
	        
	        
	        System.out.println("商户订单号="+out_trade_no);
	        System.out.println("支付宝交易号="+trade_no);
	        System.out.println("付款金额="+total_amount);
	        
	        /**
	    	 * 缴纳租金
	    	 */
	        Warning news = rentcollectionService.updateState(Integer.parseInt(AlipayConfig.rcid));
			System.out.println(news.getWarningContent());
	    }else{
	    	mav.addObject("news", new Warning(2, "支付失败!"));
	    }
		return mav;
	}
	
} 