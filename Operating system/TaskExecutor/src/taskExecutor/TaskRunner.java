package taskExecutor;

import java.util.concurrent.BlockingQueue;

public class TaskRunner implements Runnable{
	
	private  BlockingFiniteQueue blockQueue = null;
	
	
	

	public TaskRunner(BlockingFiniteQueue blockQueue) {
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
				Task tsk = (Task) this.blockQueue.take();
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
