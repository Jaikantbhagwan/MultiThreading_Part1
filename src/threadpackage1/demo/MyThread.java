package threadpackage1.demo;

public class MyThread extends Thread {

	public static void main(String[] args) {
		MyThread my = new MyThread();
		Thread t = new Thread(my);
		t.start();
		
		double height = 5.5;
		
		if(height-- >= 5.0)
			System.out.println("tall");
		if(--height >= 4.0)
			System.out.println("average");
		if(height-- >= 3.0)
			System.out.println("short");
		else
			System.out.println("very short");
		
		char c ='a';
		
		switch(c) {
		case 'a' :
		System.out.println("a");
		}
	}
	
	public void run(){
		for(int i = 0; i< 3; i++) {
			System.out.println(i);
		}
	}
}
