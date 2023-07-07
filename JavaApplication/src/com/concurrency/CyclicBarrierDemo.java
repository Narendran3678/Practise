package com.concurrency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class Player extends Thread {
	CyclicBarrier cb = null;
	String threadName = "";

	public Player(String threadName, CyclicBarrier cb) {
		this.threadName = threadName;
		this.cb = cb;
	}

	public void run() {
		try {
			System.out.println("Player " + threadName + " Reached Stadium");
			Thread.sleep(1000);
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class Match implements Runnable {
	public void run() {
		System.out.println("Match is starting...");
	}
}

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		Match match = new Match();
		CyclicBarrier cb = new CyclicBarrier(4,match);
		
		Thread thread1 = new Thread(new Player("Lionel Messi",cb));
		Thread thread2 = new Thread(new Player("Cristiano Ronaldo",cb));
		Thread thread3 = new Thread(new Player("Killian Mbappe",cb));
		Thread thread4 = new Thread(new Player("Neymar",cb));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}
