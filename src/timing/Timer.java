package timing;

public class Timer implements ITimer 
{

	private long count = 0;
	private long save = 0;

	public void start() 
	{
		save = 0;
		resume();
	}

	public long stop() 
	{
		count = System.nanoTime() - count;
		save += count;
		return save;
	}

	public long pause() 
	{
		count = System.nanoTime() - count;
		save += count;
		return count;
	}

	public void resume() 
	{
		count = System.nanoTime();
	}
}
