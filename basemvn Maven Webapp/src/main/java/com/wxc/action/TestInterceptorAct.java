package com.wxc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestInterceptorAct {

	@RequestMapping("/test.do")
	public String test() {
		//request.getParameterNames(); 
		System.out.println("*************test.do************");
        return "test";
	}
	
	public static void responseToPage(HttpServletResponse response,String url) throws IOException{
		
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().printf(url);
		response.getWriter().flush();
		response.getWriter().close();
		
	}
}
