package com.pradip.springbootmvc.controller;


import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pradip.springbootmvc.model.User;

import javax.servlet.*;
import java.util.*;

// Implements Filter class

@WebFilter(urlPatterns = {"/*"})
public class GeneralFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path=httpRequest.getServletPath();

		httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 

		HttpSession session=httpRequest.getSession(false);
		User userObjec=null;

		boolean notForUser=path.equals("/DeleteUser") || path.startsWith("/viewusers") || path.startsWith("/GenerateCSV");
		boolean beforeLoginPages=path.equals("/") || path.equals("/index") || path.equals("/ProcessLogin") || path.equals("/forgot") || path.equals("/ProcessForgot") || path.equals("/EmailCheck");
		if(session != null) {
			userObjec=(User) (session.getAttribute("sessionUser"));
			System.out.println("hello from filter");
		}
		if(userObjec  !=null) {
			if(userObjec.getRole().getRoleType() != 1) {

				if(beforeLoginPages || path.startsWith("/register") || path.startsWith("/viewusers") || path.startsWith("/GenerateCSV") || path.startsWith("/DeleteUser")) {
					httpResponse.sendRedirect("profile?profileEmail="+userObjec.getEmail());
				}
				else {
					chain.doFilter(request, response);
				}        		 
			}
			else {
				if(beforeLoginPages) {
					httpResponse.sendRedirect("viewusers");
				}
				else {
					chain.doFilter(request, response);
				}
			}
		}
		else {
			if(beforeLoginPages || path.startsWith("/register") || path.startsWith("/AddUser")  || path.endsWith(".css") || path.endsWith(".js")|| path.endsWith(".map")) {
				chain.doFilter(request, response);
			}
			else {
				httpResponse.sendRedirect("index");
			}
		}
	
		
    }

    public void destroy() {
    }
}
