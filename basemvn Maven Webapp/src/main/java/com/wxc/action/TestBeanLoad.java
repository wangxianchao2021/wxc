package com.wxc.action;

import org.springframework.cache.annotation.Cacheable;

import com.wxc.aop.AServiceImpl;

public class TestBeanLoad {

	private TestBeanParam testBeanParam;
	public void iniLoad(){
		


	}
	
	
	@Cacheable(value="menuCache",key="#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
	
	
	public TestBeanParam getTestBeanParam() {
		return testBeanParam;
	}
	public void setTestBeanParam(TestBeanParam testBeanParam) {
		this.testBeanParam = testBeanParam;
	}


}