package executors.returningvalues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.CalculationTaskB;
import common.LoopTaskA;
import common.NamedThreadFactory;
import common.TaskResult;

public class ReturningValuesUsingExecutorsSecondWay {

	public static void main(String[] args) {
		
		  String currentThreadName = Thread.currentThread().getName();
			
		  System.out.println("[" + currentThreadName + "] Main thread starts here...");	
			
		  ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		  
		  CompletionService<TaskResult<String, Integer>> tasks = new ExecutorCompletionService<TaskResult<String, Integer>>(execService);
		  
		  
		  tasks.submit(new CalculationTaskB(2, 3, 2000));
		  tasks.submit(new CalculationTaskB(3, 4, 1000));
		  tasks.submit(new CalculationTaskB(4, 5, 500));
		  
		 // Future<?> result4= execService.submit(new LoopTaskA());
		  execService.submit(new LoopTaskA(),new TaskResult<String, Integer>("LoopTaskA-1", 999));
		  
		  for(int i = 0; i < 4; i++) {
			  try {
				System.out.println("Result = " + tasks.take().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  execService.shutdown();
		  
		  

		  System.out.println("[" + currentThreadName +"] Main thread ends here...");
	}
}
