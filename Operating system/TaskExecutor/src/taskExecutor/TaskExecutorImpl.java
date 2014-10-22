package taskExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskExecutorImpl implements TaskExecutor{
	
	private static TaskExecutorImpl instance = null; 
	private  int threadNum                 = 0;
	private  BlockingQueue<Task> blockQueue = null;
	private  Stack<Thread> threadPool;
	
	protected TaskExecutorImpl()
	{
		
	}
	
	public TaskExecutorImpl(int noThreads)
	{
		if(instance==null)
		{
			instance = new TaskExecutorImpl();
			instance.threadNum = noThreads;
			instance.blockQueue = new LinkedBlockingQueue<Task>();
			instance.threadPool = new  Stack<Thread>();
			for(int i=0;i<instance.threadNum;i++)
			{
				//instance.threadPool.add(new TaskRunnerOld("Thread- "+(i+1)));
				TaskRunner tskRunner = new TaskRunner(instance.blockQueue);
				Thread t= new Thread(tskRunner, "Thread "+i);
				t.start();
				instance.threadPool.add(t);
			}
		}
		
	}

	@Override
	public void addTask(Task task) {
		try
		{
			instance.blockQueue.put(task);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void consumeTask()
	{/*
		try
		{
			//while(true)//
			//{
				if(!instance.blockQueue.isEmpty() )
				{
					if(!instance.threadPool.isEmpty())
					{
						System.out.println(" in w hile "+ instance.blockQueue.isEmpty()+ " "+instance.threadPool.isEmpty());
						TaskRunnerOld tskRunner = instance.threadPool.pop();
						System.out.println("tskRunner "+ tskRunner);
						Task tsk = instance.blockQueue.take();
						System.out.println("task "+tsk);
						tskRunner.setTask(tsk);
					   	//instance.blockQueue.take();
						tskRunner.runLoop();
						System.out.println("b4 readding");
						instance.threadPool.add(tskRunner);
						System.out.println(instance.threadPool.size());	
						
					}
						
				}
				System.out.println("outside if");
			//}	
			//System.out.println("outside");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	*/}
	 

}
