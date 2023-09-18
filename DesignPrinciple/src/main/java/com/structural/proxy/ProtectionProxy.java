package com.structural.proxy;

import java.util.*;

interface Application
{
	public void Connect();
}
class AppleDirectory implements Application{

	private Map<String,String> directoryFromDb()
	{
		Map<String,String> dir = new HashMap<>();
		dir.put("Cafe", "Aman:Naren");
		dir.put("Captcha", "Ankita:Naren");
		return dir;
	}

	private Map<String,String> getInfo() {
		
		return directoryFromDb();
	}
	@Override
	public void Connect() {
		System.out.println("AppleDirectory Connection Started");
		getInfo().forEach((k,v) -> System.out.println(k+"-"+v));
		System.out.println("AppleDirectory Connection Succeed");
	}
	
}

class AppleRadar implements Application {

	private Map<String,String> radarFromDb()
	{
		Map<String,String> rad = new HashMap<>();
		rad.put("Cafe", "A3Token");
		rad.put("Captcha", "Service Now");
		return rad;
	}
	
	private Map<String,String> getInfo() {
		
		return radarFromDb();
	}
	@Override
	public void Connect() {
		System.out.println("AppleRadar Connection Started");
		getInfo().forEach((k,v) -> System.out.println(k+"-"+v));
		System.out.println("AppleRadar Connection Succeed");
	}
	
}

interface Gateway {
	public void ConnectToApp(Application app);
}

class AppleService implements Gateway {
	
	@Override
	public void ConnectToApp(Application app) {
		app.Connect();
	}
}

class AppleProxy implements Gateway {
	private String username = "Naren";
	private String password = "Naren";
	private String cred ;
	private AppleService appleService =  new AppleService();
	public AppleProxy(String cred)
	{
		this.cred= cred;
		appleService =  new AppleService();
	}
	@Override
	public void ConnectToApp(Application app) {
		String authToken =username.concat(":").concat(password);
		if(authToken.equals(cred))
		{
			appleService.ConnectToApp(app);
		}
		else
		{
			System.out.println("Access Denied");
		}
	}
}
/*
 * If a application/call made to restrict the access to certain object, then we can make the object to talk to layer which 
 * take safety measures and provide access to object  
 */
public class ProtectionProxy {
	public static void main(String args[]) {
		Gateway gateway= new AppleProxy("Naren:Naren");
		gateway.ConnectToApp(new AppleRadar());
		System.out.println();
		gateway.ConnectToApp(new AppleDirectory());
	}
}
