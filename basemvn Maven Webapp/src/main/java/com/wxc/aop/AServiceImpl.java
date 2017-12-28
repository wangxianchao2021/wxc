package com.wxc.aop;

//使用jdk动态代理  
public class AServiceImpl implements IService {  

 public void barA() {  
     System.out.println("AServiceImpl.barA()");  
 }  

 public String fooA(String _msg) {  
     System.out.println("AServiceImpl.fooA(msg:" + _msg + ")");  
     return _msg;
 }  
}  
