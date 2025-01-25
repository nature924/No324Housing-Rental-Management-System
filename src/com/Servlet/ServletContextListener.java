package com.Servlet;

import javax.servlet.ServletContextEvent;

public interface ServletContextListener {
	
	public void contextInitialized(ServletContextEvent arg0);
	
	public void contextDestroyed(ServletContextEvent arg0);
}
