package executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.LoopTaskA;

public class UsingFixedThreadPool {
	
   public static void main(String[] args) {
	   System.out.println("Main thread starts here...");
		
		ExecutorService exeService = Executors.newFixedThreadPool(3);
		
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		exeService.execute(new LoopTaskA());
		
		exeService.shutdown();
		
		exeService.execute(new LoopTaskA());
		
	   System.out.println("Main thread ends here...");	
}
}
