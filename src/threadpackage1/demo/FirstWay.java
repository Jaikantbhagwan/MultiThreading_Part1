package threadpackage1.demo;

import java.util.concurrent.TimeUnit;

public class FirstWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
	
		new FirstTask();
		
		System.out.println("Main thread ends here...");
	
	}
}


class FirstTask extends Thread {
	
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println("TICK TICK " + i);
			try {
				TimeUnit.MICROSECONDS.sleep(200);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public FirstTask() {
		this.start();
	}
}
