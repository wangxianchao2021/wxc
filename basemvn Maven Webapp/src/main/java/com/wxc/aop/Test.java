package com.wxc.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	    public static void main(String[] args) {
	    ApplicationContext appCtx = new FileSystemXmlApplicationContext("D:\\project\\TestServlet\\WebRoot\\WEB-INF\\applicationContext.xml");
	    IService aDo = (IService) appCtx.getBean("aService");
	     aDo.fooA("hello wxc");
	    }
	
}
