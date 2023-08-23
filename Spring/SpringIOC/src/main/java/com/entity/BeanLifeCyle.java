package com.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCyle implements InitializingBean, DisposableBean{
	public BeanLifeCyle()
	{
		
	}
	// InitializingBean - DisposableBean -> Implementing both will be executed when any bean invoked
	public void initMethod() {
		System.out.println("Init XML Method");
	}
	
	public void destroyMethod()
	{
		System.out.println("Destroy XML Method");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("BeanLifeCyle Implementing Method");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanLifeCyle Implementing Method");
		
	}
	@Override
	public String toString() {
		return "BeanLifeCyle [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
