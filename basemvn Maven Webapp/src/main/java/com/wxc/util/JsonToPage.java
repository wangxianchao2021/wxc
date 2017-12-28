package com.wxc.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonToPage {

	public static void responseToPage(HttpServletResponse response,Object content) throws IOException{
		
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().printf(JSON.toJSONString(content), response);
		response.getWriter().flush();
		response.getWriter().close();
		
	}
}
