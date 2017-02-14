/**
 * Project Name:jetty-6.1.26
 * File Name:ServletContextServer.java
 * Package Name:com.toner.test
 * Date:2017年2月13日上午10:01:39
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.test;

import com.toner.test.HelloServlet;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * ClassName:ServletContextServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月13日 上午10:01:39 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ServletContextServer {

	public static void main(String[] args) throws Exception {
		
	        Server server = new Server(8080);  
	  
	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);  
	        context.setContextPath("/");  
	        server.setHandler(context);  
	  
	        // http://localhost:8080/hello  
	        context.addServlet(new ServletHolder((Servlet) new HelloServlet()), "/hello");  
	        // http://localhost:8080/hello/kongxx  
	        context.addServlet(new ServletHolder((Servlet) new HelloServlet("Hello Kongxx!")), "/hello/kongxx");  
	  
	        // http://localhost:8080/goodbye  
	        context.addServlet(new ServletHolder((Servlet) new GoodbyeServlet()), "/goodbye");  
	        // http://localhost:8080/goodbye/kongxx  
	        context.addServlet(new ServletHolder((Servlet) new GoodbyeServlet("Goodbye kongxx!")), "/goodbye/kongxx");  
	          
	        server.start();  
	        server.join();  
	    }  
}

