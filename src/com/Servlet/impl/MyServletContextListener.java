package com.Servlet.impl;

import javax.servlet.ServletContextEvent;

import com.Servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("===========开启==========");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("===========关闭==========");
	}

}
