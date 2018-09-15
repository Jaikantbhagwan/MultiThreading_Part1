package common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable {
	
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count  = 0;
	private int instanceNumber;
	private String taskId;
	
	private ResultListener<Integer> listener;
	
	public ValueReturningTaskB(int a, int b, long sleepTme, ResultListener<Integer> listener) {
		this.a = a;
		this.b= b;
		this.sleepTime = sleepTme;
		this.listener = listener;
		
		this.instanceNumber = ++count;		
		this.taskId = "ValreturnTaskA " + instanceNumber;			
		
	}

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("#### [" + currentThreadName + "] <" + taskId + "> STARTING ####");
        
		System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for "+ sleepTime + "millis");
		
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sum = a + b;
		System.out.println("************************ [" + currentThreadName + "] <" + taskId + "> Done ******");
		
		listener.notifyResult(sum);
}

}
