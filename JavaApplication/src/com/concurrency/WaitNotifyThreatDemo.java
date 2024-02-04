package com.concurrency;
class JoinDemo implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("ThreatData..."+i+"->"+Thread.currentThread().getName());
		}
	}
	
}
public class WaitNotifyThreatDemo {
	public static void main(String args[]) {
		JoinDemo jd = new JoinDemo();
		Thread threat1 = new Thread(jd,"Threat1");
		Thread threat2 = new Thread(jd,"Threat2");
		Thread threat3 = new Thread(jd,"Threat3");
		threat1.start();
		threat2.start();
		threat3.start();
		try {
			threat1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
