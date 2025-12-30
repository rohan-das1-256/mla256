package com.ths;

public class Lifecycle implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("run");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) throws Exception {
		
		Lifecycle obj = new Lifecycle();
		obj.run();
		
		
		Thread t1 = new Thread(obj);
		System.out.println("current state of t1: "+ t1.getState());
		System.out.println("is t1 live: "+ t1.isAlive());
		t1.start();
		System.out.println("after start() state of t1: "+ t1.getState());
		System.out.println("after start() is t1 live: "+ t1.isAlive());
		
		Thread.sleep(5000);
		
		System.out.println("after sleep() state of t1: "+ t1.getState());
		System.out.println("after sleep() is t1 live: "+ t1.isAlive());
		
		t1.join();
		System.out.println("after join() state of t1: "+ t1.getState());
		System.out.println("after join() is t1 live: "+ t1.isAlive());
		
		
		
		Runnable t2 = () ->{
			System.out.println("inside t2.run() using runnable and lambda");
		};
		
		Thread t3 = new Thread(()-> System.out.println("inside t3 thread and lambda"));
		
		t3.start();
		t2.run();
		System.out.println("current state of t1: "+ t1.getState());
		System.out.println("is t1 live: "+ t1.isAlive());
	}


}
