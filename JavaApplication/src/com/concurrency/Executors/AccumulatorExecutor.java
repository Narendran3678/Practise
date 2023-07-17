package com.concurrency.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Accumulator {
	private List<Integer> list = new ArrayList<>();

	public synchronized void accumulate(int i) {
		list.add(i);
	}

	public List<Integer> getList() {
		return list;
	}
}

public class AccumulatorExecutor {
	public static void main(String[] args) {
		ExecutorService s = Executors.newFixedThreadPool(1000);
		Accumulator a = new Accumulator();
		for (int i = 1; i <= 1000; i++) {
			int x = i;
			s.execute(() -> a.accumulate(x));
		}
		s.shutdown();
		System.out.println(a.getList().size());
	}
}