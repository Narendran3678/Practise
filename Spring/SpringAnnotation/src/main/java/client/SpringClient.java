package client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import components.*;
import config.SpringAppConfig;

public class SpringClient {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
		LivingBeing livingBeing = context.getBean("LivingBeingObj",LivingBeing.class);
		System.out.println(livingBeing);
		context.close();
	}
}
