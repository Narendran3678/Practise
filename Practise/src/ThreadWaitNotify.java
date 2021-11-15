class Message
{
	String message;
	public Message(String message)
	{
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
class Waiter implements Runnable
{
	Message msg;
	public Waiter(Message msg)
	{
		this.msg=msg;
	}
	@Override
	public void run() 
	{
		System.out.println("Waiter Thread Reached");
		try 
		{ 
			synchronized(msg)
			{
				System.out.println("Waiter Thread Put to Hold");
				msg.wait();
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Waiter Notified with Message ["+msg.getMessage()+"]");
	}	
}
class Notifier implements Runnable
{
	Message msg;
	public Notifier(Message msg)
	{
		this.msg=msg;
	}
	@Override
	public void run() 
	{
		System.out.println("Notifer Thread Reached");
		try 
		{
			synchronized(msg)
			{
				msg.notify();
				System.out.println("Waiter Thread Notifying");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Message Displayed After Displaying Waiter Thread ["+msg.getMessage()+"]");
	}
}
public class ThreadWaitNotify 
{
	public static void main(String args[])
	{	
		Message msg = new Message("Thread Wait Notify");
		Waiter waiter= new Waiter(msg);
		Notifier notifier= new Notifier(msg);
		
		Thread waiterThread= new Thread(waiter);
		Thread notifierThread= new Thread(notifier);
		
		waiterThread.start();
		notifierThread.start();	
	}
}


