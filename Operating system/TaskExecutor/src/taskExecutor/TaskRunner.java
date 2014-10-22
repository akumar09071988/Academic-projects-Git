package taskExecutor;

import java.util.concurrent.BlockingQueue;

public class TaskRunner implements Runnable{
	
	private  BlockingQueue<Task> blockQueue = null;
	
	
	

	public TaskRunner(BlockingQueue<Task> blockQueue) {
		super();
		this.blockQueue = blockQueue;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				Task tsk = this.blockQueue.take();
				if(tsk!=null)
				{
					System.out.println(Thread.currentThread().getName());
					tsk.execute();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
