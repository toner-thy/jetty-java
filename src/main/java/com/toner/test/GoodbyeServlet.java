/**
 * Project Name:jetty-6.1.26
 * File Name:GoodbyeServlet.java
 * Package Name:com.toner.test
 * Date:2017年2月13日上午10:01:00
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:GoodbyeServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月13日 上午10:01:00 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class GoodbyeServlet extends HttpServlet {

	 private static final long serialVersionUID = 1L;  
	    private String msg = "Goodbye!";  
	  
	    public GoodbyeServlet() {  
	    }  
	  
	    public GoodbyeServlet(String msg) {  
	        this.msg = msg;  
	    }  
	  
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        response.setStatus(HttpServletResponse.SC_OK);  
	        response.getWriter().println("<h1>" + msg + "</h1>");  
	        response.getWriter().println("session=" + request.getSession(true).getId());  
	    }  
}

