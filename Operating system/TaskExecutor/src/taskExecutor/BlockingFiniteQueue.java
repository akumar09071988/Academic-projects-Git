package taskExecutor;

public class BlockingFiniteQueue <T>
{

	private final int MaxSize = 100;
	private T buffer[] = (T[])new Object[MaxSize];
	private int count = 0;
	private int nextin = 0;
	private int nextout = 0;

	// Monitors 
	private Object notfull = new Object();
	private Object notempty = new Object();

	public void append(T str) throws Exception
	{
		while (true) {
			if (count > MaxSize) {
				synchronized (notfull) {
					notfull.wait();
				}
			}
			
			synchronized (this) {
				if (count > MaxSize) {
					continue;
				}

				buffer[nextin] = str;
				nextin = (nextin + 1) % MaxSize;
				count++;
				synchronized (notempty) {
					notempty.notify();
				}
				return;
			}
		}
	}

	public T take() throws Exception
	{
		while (true) {
			if (count < 1) {
				synchronized (notempty) {
					notempty.wait();
				}
			}

			synchronized (this) {
				if (count < 1) {
					continue;
				}

				T result = buffer[nextout];
				nextout = (nextout + 1) % MaxSize;
				count--;
				synchronized (notfull) {
					notfull.notify();
				}
				return result;
			}
		}
	}
}
