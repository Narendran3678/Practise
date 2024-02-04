package com.concurrency;


class VolatileTest implements Runnable
{
	private boolean stopAlert=false;

	public VolatileTest(boolean stopAlert) {
		super();
		this.stopAlert = stopAlert;
	}

	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread()+" Started- Stop-"+stopAlert);
		while(!stopAlert)
		{
			System.out.println(Thread.currentThread()+" Still Running");
		}	
	}

	public boolean isStopAlert() {
		return stopAlert;
	}

	public void setStopAlert(boolean stopAlert) {
		System.out.println(Thread.currentThread()+" Send Alert");
		this.stopAlert = stopAlert;
	}	
	
}
class Counter implements Runnable
{
	private volatile int counter=0;

	public int increaseCounter() {
		return counter++;
	}

	@Override
	public void run() 
	{
		for(int i=0;i<10000;i++)
		{
			System.out.println(Thread.currentThread().getName()+"-"+increaseCounter());
		}
	}
	public int getCounter() {
		return counter;
	}
}
public class VolatileDemo 
{
	public static void main(String args[]) throws InterruptedException
	{
		Counter counter = new Counter();
		Thread thread= new Thread(counter,"TA");
		Thread thread1= new Thread(counter,"TB");
		thread.start();
		thread1.start();
		Thread.sleep(1000);
		System.out.println(counter.getCounter());
			
		/*
		VolatileTest vt= new VolatileTest(false);
		Thread thread1 = new Thread(vt,"Thread-1");
		Thread thread2 = new Thread(vt,"Thread-2");
		thread1.start();
		thread2.start();
		TimeUnit.SECONDS.sleep(3);
		vt.setStopAlert(true);*/
	}

}
