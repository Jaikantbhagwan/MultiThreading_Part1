package executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTaskA;

public class UsingCachedThreadPool {
	
   public static void main(String[] args) {
	   System.out.println("Main thread starts here...");
		
		ExecutorService exeService = Executors.newCachedThreadPool();
		
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.shutdown();
		
	   System.out.println("Main thread ends here...");	
}
}
