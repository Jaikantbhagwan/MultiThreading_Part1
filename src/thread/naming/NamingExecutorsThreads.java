package thread.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import common.LoopTaskC;
import common.NamedThreadFactory;

public class NamingExecutorsThreads {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		
		 System.out.println("[" + currentThreadName + "] Main thread starts here...");	
		 
		 ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		 
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 execService.execute(new LoopTaskC());
		 
		 execService.shutdown();
		 
		 System.out.println("[" + currentThreadName +"] Main thread ends here...");
	}
}
