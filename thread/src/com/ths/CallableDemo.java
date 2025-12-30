package com.ths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class SimpleMaths implements Callable<Integer>{

	private final int count;
	
	public SimpleMaths(int count) {
		this.count = count;
	}
	
	@Override
	public Integer call() throws Exception {
		
		int add =0;
		for(int i = 1; i<=count; i++) {
			add+=i;
			Thread.sleep(500);
		}
		
		System.out.println("count value: "+ add + " "+ Thread.currentThread().getName());
		
		
		return add;
	}
	
}

public class CallableDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		SimpleMaths task = new SimpleMaths(5);
		Future<Integer> future = executor.submit(task);
		System.out.println("Task submitted");
		
		
		try {
			int result = future.get();
			System.out.println("result from the callable task: "+ result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
	}

}
