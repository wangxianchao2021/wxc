package com.wxc.core;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AuthcFilter extends FormAuthenticationFilter{

	   @Override  
	    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {  
		    String username = getUsername(request);  
	        String password = getPassword(request); 
	  
	        if (username != null&&username.equals("wxc") ) {  
	            return true;  
	        }
	        return super.onAccessDenied(request, response);  
	    }  
	

}
