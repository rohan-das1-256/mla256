package com.test;

public class GCExp1 {

	
	private int objId;
	public GCExp1(int objId) {
		this.objId = objId;
		System.out.println("object created: "+ this.objId);
	}
	
	@Override
	protected void finalize() throws Throwable{
		
		try {
			System.out.println("object released by garbage collector");			
		} finally {
			super.finalize();
		}
		
	}
	
	public void close() {
		System.out.println("closing resources");
	}
	
	public static void main(String[] args) throws Exception {

		GCExp1 obj1 = new GCExp1(1);
		GCExp1 obj2 = new GCExp1(2);
		
		obj1 = null;
		obj2 = null;
		
		Runtime.getRuntime().gc();
		
//		System.gc();
		Thread.sleep(1000);
		
		System.out.println("main mehod end");
	}

}
