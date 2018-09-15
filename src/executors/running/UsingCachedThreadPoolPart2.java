package executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import common.LoopTaskA;
import common.LoopTaskC;
import common.NamedThreadFactory;

public class UsingCachedThreadPoolPart2 {
	
   public static void main(String[] args) throws InterruptedException {
	   String currentThreadName = Thread.currentThread().getName();
		
		 System.out.println("[" + currentThreadName + "] Main thread starts here...");	
		 
		 ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		 
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 
		 TimeUnit.SECONDS.sleep(15);
		 
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 
		 execService.shutdown();
		 
		 System.out.println("[" + currentThreadName +"] Main thread ends here...");
}
}
