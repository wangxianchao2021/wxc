package com.wxc.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.InvocationHandler;

import sun.misc.ProxyGenerator;

public class ProxyHandler implements InvocationHandler {

	  private Object proxied;   
	     
	  public ProxyHandler( Object proxied )   
	  {   
	    this.proxied = proxied;   
	  }   
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		return arg1.invoke(proxied, arg2);
	}
	public static void main( String args[] )   
	  {   
	    RealSubject real = new RealSubject();   
	    Subject proxySubject = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), 
	     new Class[]{Subject.class}, 
	     (java.lang.reflect.InvocationHandler) new ProxyHandler(real));
	         
	    proxySubject.doSomething();
	   
	    //write proxySubject class binary data to file   
	    createProxyClassFile();   
	  }   
	
	
	 public static void createProxyClassFile()   
	  {   
	    String name = "ProxySubject";   
	    byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
	    try  
	    {   
	      FileOutputStream out = new FileOutputStream( name + ".class" );   
	      out.write( data );   
	      out.close();   
	    }   
	    catch( Exception e )   
	    {   
	      e.printStackTrace();   
	    }   
	  }   
}
