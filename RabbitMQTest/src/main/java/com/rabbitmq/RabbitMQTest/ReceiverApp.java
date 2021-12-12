package com.rabbitmq.RabbitMQTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

public class ReceiverApp 
{
	public final static String QUEUE_NAME = "message_simple_queue"	;
	public static void main(String args[]) 
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try 
		{
			Connection connection = connectionFactory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			DeliverCallback deliverCallback = new DeliverCallback()
			{
				@Override
				public void handle(String consumerTag, Delivery message) throws IOException 
				{
					String sendersMessage = new String (message.getBody(),"UTF-8");
					System.out.println("Message Received ["+sendersMessage+"]");
				}
			};
			CancelCallback cancelCallback = new CancelCallback()
			{
				@Override
				public void handle(String consumerTag) throws IOException {	}
			};
			channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
		}
		catch (IOException | TimeoutException e) 
		{
			e.printStackTrace();
		}
		
	}
}
