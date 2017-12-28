package com.wxc.action;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.wxc.util.DecriptUtil;
import com.wxc.util.JsonToPage;


@Controller
public class UserAction {

    @RequestMapping("/admin.do")
    public ModelAndView getIndex(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("admin/admin");
        return mav;
    }




    @RequestMapping(value="/otherException.json", method=RequestMethod.POST)
    @ResponseBody  
    public String otherException(HttpServletRequest request) throws Exception {
        throw new Exception();
    }

    //跳转到登录页面
    @RequestMapping("/login.jsp")
    public ModelAndView login() throws Exception {
        ModelAndView mav = new ModelAndView("test");
        return mav;
    }

    //跳转到登录成功页面
    @RequestMapping("/loginsuccess.jhtml")
    public ModelAndView loginsuccess() throws Exception {
        ModelAndView mav = new ModelAndView("loginsuccess");
        return mav;
    }

    @RequestMapping("/newPage.jhtml")
    public ModelAndView newPage() throws Exception {
        ModelAndView mav = new ModelAndView("newPage");
        return mav;
    }

    @RequestMapping("/newPageNotAdd.jhtml")
    public ModelAndView newPageNotAdd() throws Exception {
        ModelAndView mav = new ModelAndView("newPageNotAdd");
        return mav;
    }

    /** 
     * 验证用户名和密码 
     * @param String username,String password
     * @return 
     * @throws IOException 
     */  
    @RequestMapping(value="/checkLogin.do",method=RequestMethod.POST)    
    public void checkLogin(HttpServletRequest request,
			HttpServletResponse response,String username,String password) throws IOException {  
        Map<String, Object> result = new HashMap<String, Object>();
        try{
        	password="123456";
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
            Subject currentUser = SecurityUtils.getSubject();  
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证  
                token.setRememberMe(true);  
                currentUser.login(token);//验证角色和权限  
            } 
        }catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
        result.put("success", true);
        JsonToPage.responseToPage(response, result) ;
    }
    
    //登录成功跳主页
    @RequestMapping("/success.do")
    public ModelAndView success() throws Exception {
        ModelAndView mav = new ModelAndView("success");
        return mav;
    }

}
