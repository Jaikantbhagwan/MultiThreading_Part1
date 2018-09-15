package threadpackage1.demo;

import java.util.concurrent.TimeUnit;

public class SecondWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
	
		new SecondTask().start();;
		Thread t = new SecondTask();
		t.start();
		System.out.println("Main thread ends here...");	
	}
}

class SecondTask extends Thread {
	
	private static int count = 0;	
	private int id;
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println("<" + id + ">TICK TICK " + i);
			try {
				TimeUnit.MICROSECONDS.sleep(200);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public SecondTask() {
		this.id = ++count;		
	}
}
