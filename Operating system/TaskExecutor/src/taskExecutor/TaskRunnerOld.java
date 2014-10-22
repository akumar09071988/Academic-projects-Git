package taskExecutor;

public class TaskRunnerOld implements Runnable{
	
	 private Thread t;
	 private String threadName;
	 private Task task;
	 

	public TaskRunnerOld(String threadName) {
		super();
		this.threadName = threadName;
		System.out.println("Creating " +  threadName );
		t = new Thread (this, threadName);
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running  "+threadName);
		try
		{
			System.out.println(this.t.getName()+" Executing Task");
			this.task.execute();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void runLoop() throws Exception
	{
		if(this.task!=null)
		{
			System.out.println("Starting " +  threadName );
			this.t.start();
			//this.t.stop();
		}
				
		
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
   
	
	
}
