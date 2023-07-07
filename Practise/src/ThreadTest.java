import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadDemo extends Thread 
{
	String threadName;
	public ThreadDemo(String threadName)
	{
		this.threadName=threadName;
	}
	@Override
	public void run()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(this.threadName+"-"+i+"-"+LocalDateTime.now());
		}
	}
}
class ThreadDemo1 implements Runnable
{
	String threadName="";
	public ThreadDemo1(String threadName)
	{
		this.threadName=threadName;
	}
	@Override
	public synchronized void run()
	{
		for(int i=0;i<20;i++)
		{
			System.out.println(this.threadName+"-"+i);
		}
	}
}
class MyCallable implements Callable
{
	int sumCount=0;
	public MyCallable(int sumCount)
	{
		this.sumCount=sumCount;
	}
	@Override
	public Integer call() throws Exception 
	{
		int sum=0;
		for(int i=1;i<sumCount;i++)
		{
			sum+=i;
		}
		return sum;
	}
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
}
class PrintInfo
{
	static int val=1;
	
	public synchronized static void syncMethodPrintValue(int n)
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(n*i);
		}
	}
	public static void syncBlockPrintValue(String threadName, int i)
	{
		synchronized(PrintInfo.class)
		{
			val=val+i;
			System.out.println(threadName+" - "+val);
		}
	}
}

@SuppressWarnings("rawtypes")
public class ThreadTest 
{
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{	
		ThreadJoin();
		//SynchronizedBlockorMethod();
	}
	public static void SynchronizedBlockorMethod() throws InterruptedException, ExecutionException
	{
		Thread d = new Thread(new Runnable()
				{
					@Override
					public void run() {
						
						//PrintInfo.syncMethodPrintValue(5);
						for(int i=0;i<5;i++)
						{
							PrintInfo.syncBlockPrintValue("Thread-1",i);
						}
					}
				});
		Thread d1= new Thread(new Runnable()
		{
			@Override
			public void run() {
				//PrintInfo.syncMethodPrintValue(5);
				for(int i=0;i<5;i++)
				{
					PrintInfo.syncBlockPrintValue("Thread-2",i);
				}
			}
		});
		Thread d2 = new Thread(new Runnable()
		{
			@Override
			public void run() {
				//PrintInfo.syncMethodPrintValue(5);
				for(int i=0;i<5;i++)
				{
					PrintInfo.syncBlockPrintValue("Thread-3",i);
				}
			}
		});
		d.start();
		d1.start();
		d2.start();
	}
	public static void ThreadJoin() throws InterruptedException, ExecutionException
	{
		Thread d  = new Thread(new ThreadDemo("Thread-1"));
		Thread d2 = new Thread(new ThreadDemo("Thread-2"));
		Thread d3 = new Thread(new ThreadDemo("Thread-3"));
		System.out.println("1-"+LocalDateTime.now());
		d.start();
		
		d2.start();
		System.out.println("2-"+LocalDateTime.now());
		d2.join();
		System.out.println("4-"+LocalDateTime.now());
		d3.start();
		d.join();
		
	}
	public static void sampleExecutorService() throws InterruptedException, ExecutionException
	{
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		ExecutorService service= Executors.newFixedThreadPool(3);
		int a[]= {3,4,5,6};
		Callable[] callable = new MyCallable[a.length];
		for(int i=0;i<a.length;i++)
		{
			callable[i]= new MyCallable(a[i]);
		}
		for(int i=0;i<a.length;i++)
		{
			futureList.add(service.submit(callable[i]));
		}
		for(int i=0;i<futureList.size();i++)
		{
			Future<Integer> future= futureList.get(i);
			System.out.println("Sum of ["+a[i]+"] is ["+future.get()+"]");
		}
	}
	public static void sampleExecutors() throws InterruptedException, ExecutionException
	{
		/*Thread d = new Thread(new ThreadDemo1("Thread_1"));
		d.start();
		
		Thread d1 = new Thread(new ThreadDemo1("Thread_2"));
		d1.start();*/
		Callable callable1=new MyCallable(5);
		Callable callable2=new MyCallable(10);
		Callable callable3=new MyCallable(11);
		
		FutureTask[] futureTaskArr=new FutureTask[3];
		futureTaskArr[0]= new FutureTask(callable1);
		futureTaskArr[1]= new FutureTask(callable2);
		futureTaskArr[2]= new FutureTask(callable3);
		for(int i=0;i<futureTaskArr.length;i++)
		{
			Thread d = new Thread(futureTaskArr[i]);
			d.start();
		}
		for(int i=0;i<futureTaskArr.length;i++)
		{
			System.out.println(futureTaskArr[i].get());
		}
		Future<Integer> future;
		List<Future<Integer>> list= new ArrayList<>();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		future=executor.submit(callable1);
		list.add(future);
		future=executor.submit(callable2);
		list.add(future);
		future=executor.submit(callable3);
		list.add(future);
		
		Executor executor1 = (Executor) Executors.newFixedThreadPool(2);
		executor1.execute(new ThreadDemo1("Thread_1"));
		executor1.execute(new ThreadDemo1("Thread_2"));
		
		for(Future<Integer> fut:list)
		{
			System.out.println(fut.get());
		}
	}
}


