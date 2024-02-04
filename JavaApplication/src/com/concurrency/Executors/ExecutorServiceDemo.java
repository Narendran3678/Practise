package com.concurrency.Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class CallableService implements Callable<Integer>{
	private int value1;
	private int value2;
	
	public CallableService(int value1, int value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public Integer call() throws Exception {
		
		return value1 + value2;
	}
	
}
public class ExecutorServiceDemo {
	static ExecutorService executorService1 = Executors.newSingleThreadExecutor();
	static ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(1);
	public static void scheduleExecutorService() throws InterruptedException, ExecutionException {
		CallableService cs1= new CallableService(1,2);
		CallableService cs2= new CallableService(3,4);
		CallableService cs3= new CallableService(5,6);
		
		System.out.println(executorService2.schedule(cs1,3,TimeUnit.SECONDS).get());
		System.out.println(executorService2.schedule(cs2,3,TimeUnit.SECONDS).get());
		System.out.println(executorService2.schedule(cs3,3,TimeUnit.SECONDS).get());
	}
	public static void executorService() throws InterruptedException, ExecutionException {
		CallableService cs1= new CallableService(1,2);
		CallableService cs2= new CallableService(3,4);
		CallableService cs3= new CallableService(5,6);
		
		List<Future<Integer>> futureList = executorService1.invokeAll(Arrays.asList(cs1,cs2,cs3));
		for(Future<Integer> ftr:futureList) {
			System.out.println(ftr.get());
		}
	}
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		scheduleExecutorService();
		System.exit(0);
		
	}
}	