package bench.cpu;

import bench.IBenchmark;

public class CPUThreading implements IBenchmark 
{
	private int size;
	private int nThreads;
	private Thread[] threads;

	@Override
	public void initialize(int size) 
	{
		this.size = size;
	}

	@Override
	public void run(Object option) 
	{
		if (option instanceof Integer) 
		{			
			this.nThreads = ((Integer) option).intValue();			
			this.threads = new Thread[this.nThreads];		
			
			for (int i = 0; i < this.nThreads; i++) 
			{
				SQRTW sqrtWorker = new SQRTW(i * size / nThreads, (i + 1) * size / nThreads, i + 1);
				threads[i] = new Thread(sqrtWorker);
				threads[i].start();
			}		
			
			for (int i = 0; i < this.nThreads; i++) 
			{
				try 
				{
					threads[i].join();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		} 
	}
	
	@Override
	public void run() {}
	@Override
	public void warmUp() {}
	@Override
	public void warmUp(Object option) {}
	@Override
	public void clean() {}
	@Override
	public String getResult() {return null;}
}
