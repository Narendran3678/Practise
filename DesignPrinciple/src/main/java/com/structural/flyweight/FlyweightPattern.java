package com.structural.flyweight;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

class Player {
	String ipAddress;
	String username;
	String password;
	long expiryTime;

	public Player(String ipAddress, String username, String password, long expiryTime) {
		super();
		this.ipAddress = ipAddress;
		this.username = username;
		this.password = password;
		this.expiryTime = expiryTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	@Override
	public String toString() {
		return "Player [ipAddress=" + ipAddress + ", username=" + username + ", password=" + password + ", expiryTime="
				+ expiryTime + "]";
	}

}

class PlayerFactory {
	private static Map<String, Player> playerCache = new HashMap<>();
	
	public static Player createPlayer(String userName, String password) {
		try
		{
			String cred = userName.concat(":").concat(password);
			if (playerCache.containsKey(cred)) {
				return playerCache.get(cred);
			} else {
				String ip = InetAddress.getLocalHost().getHostAddress();
				long expiryTime = LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				Player player = new Player(ip,userName,password,expiryTime);
				playerCache.put(cred, player);
				return player;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
/* 	1. Flyweight Design pattern is used when we used large number of similar object
	2. Less number of objects reduces the memory usage, and it manages to keep us away from errors related to memory like java.lang.OutOfMemoryError.
   	3. Although creating an object in Java is really fast, we can still reduce the execution time of our program by sharing objects.
 */

public class FlyweightPattern {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	public static void dateTesting() throws ParseException {
		String date = sdf.format(new Date());
		Date tDate = sdf.parse(date);
		System.out.println(date + "\n" + tDate);
		System.out.println();

		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.plusHours(1);
		long localDateMilli = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		LocalDateTime ldateTime = Instant.ofEpochMilli(localDateMilli).atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(ZoneId.systemDefault() + "\n" + localDateMilli + "\n" + ldateTime);
	}

	public static void main(String args[]) throws UnknownHostException {
		Player player = PlayerFactory.createPlayer("Naren","Naren");
		Player player1 = PlayerFactory.createPlayer("Naren","Naren1");
		Player player2 = PlayerFactory.createPlayer("Naren","Naren1");
		System.out.println(player.hashCode()+"\t"+player1.hashCode()+"\t"+player2.hashCode());
		System.out.println(player+"\n"+player1+"\n"+player2);
				
	}
}
