package com.currency;
/**
 * 令牌
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Koken {

	public boolean kokenid(HttpServletRequest request,HttpSession session){
		Object token1=session.getAttribute("token");
		String token2=request.getParameter("token");
		if(token1!=null && !"".equals(token1)) {
			if(token1.toString().equals(token2)) {
				return true;
			}
		}
		return false;
	}
}
