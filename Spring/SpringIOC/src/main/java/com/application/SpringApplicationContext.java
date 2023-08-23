package com.application;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.autowiring.SortingApp;
import com.entity.*;
@SuppressWarnings("unchecked")
public class SpringApplicationContext {
	static ApplicationContext context = new ClassPathXmlApplicationContext("springfactory.xml");
	public static void main(String args[])
	{
		if(context!=null)
		{
			
			//singletonDemo();
			//simDemo();
			//multiObjectBean();
			//beanLifeCycle();
			//autowiring();
			messageBundle();
			((ClassPathXmlApplicationContext)context).close();
		}
	}
	public static void messageBundle()
	{
		String message = context.getMessage("welcome-message", null, Locale.CANADA);
		System.out.println(message);
	}
	public static void autowiring()
	{
		//List<Integer> list = Arrays.asList(3,4,1,5);
		List<String> list = Arrays.asList("Naren","Divi Kuty","Echo","Amir");
		
		SortingApp<String> sortingApp = context.getBean("sortingApp",SortingApp.class);
		sortingApp.sort(list);
		System.out.println(sortingApp.getSortingComplexity());
		System.out.println(sortingApp.getSortingHeapSize());
	}
	public static void beanLifeCycle()
	{
		BeanLifeCyle beanLifeCyle = (BeanLifeCyle) context.getBean("beanlifecyle");
		System.out.println(beanLifeCyle);
	}
	public static void multiObjectBean()
	{
		Organization organization = (Organization) context.getBean("organization");
		System.out.println(organization);
	}
	public static void singletonDemo()
	{
		SingletonClass singleton1 = (SingletonClass) context.getBean("singleton");
		System.out.println(singleton1);
		SingletonClass singleton2 = (SingletonClass) context.getBean("singleton");
		System.out.println(singleton2);
	}
	public static void simDemo()
	{
		Sim sim = (Sim) context.getBean("jio");
		System.out.println(sim.simType());
		System.out.println(sim.simName());
		System.out.println(sim.getBandwidth());
		sim.coverageArea().forEach((v1,v2) -> System.out.println(v1+"--"+v2));
	}
}
