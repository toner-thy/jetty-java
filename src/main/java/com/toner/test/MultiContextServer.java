/**
 * Project Name:jetty-6.1.26
 * File Name:MultiContextServer.java
 * Package Name:com.toner.test
 * Date:2017年2月13日上午10:00:39
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.test;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * ClassName:MultiContextServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月13日 上午10:00:39 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MultiContextServer {

	public static void main(String[] args) throws Exception {  
        Server server = new Server(8080);  
  
//        ResourceHandler handler = new ResourceHandler();
//        handler.setDirectoriesListed(true);
//        handler.setResourceBase("test-web");
//        handler.setWelcomeFiles(new String[]{"index1.html"});
        
        // http://localhost:8080/hello/kongxx  
        ServletContextHandler context1 = new ServletContextHandler(ServletContextHandler.SESSIONS);  
        context1.setContextPath("/hello"); 
        context1.setClassLoader(Thread.currentThread().getContextClassLoader());  
        context1.addServlet(new ServletHolder((Servlet) new HelloServlet("Hello Kongxx!")), "/kongxx");  
  
        // http://localhost:8080/goodbye/kongxx  
        ServletContextHandler context2 = new ServletContextHandler(ServletContextHandler.SESSIONS);  
        context2.setContextPath("/goodbye");  
        context2.setResourceBase(".");  
        context2.setClassLoader(Thread.currentThread().getContextClassLoader());  
        context2.addServlet(new ServletHolder((Servlet) new GoodbyeServlet("Goodbye kongxx!")), "/kongxx");  
  
        ContextHandlerCollection contexts = new ContextHandlerCollection();  
        contexts.setHandlers(new Handler[] { context1, context2 });  
        server.setHandler(contexts); 
        
//        server.setHandler(handler);  
  
        server.start();  
        server.join();  
    }  
}

