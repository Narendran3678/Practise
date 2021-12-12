package com.rabbitmq.RabbitMQTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SenderApp 
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
			String message ="Welcome to Rabbit MQ";
			channel.basicPublish("", QUEUE_NAME,false,null, message.getBytes());
			System.out.println("Message ["+message+"] sent to Queue");
		} 
		catch (IOException | TimeoutException e) 
		{
			e.printStackTrace();
		}
		
	}
}
   