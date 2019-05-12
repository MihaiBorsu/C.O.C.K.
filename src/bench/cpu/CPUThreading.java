package bench.cpu;

import bench.IBenchmark;

public class CPUThreading implements IBenchmark {
	private int size;
	private int nThreads;
	private Thread[] threads;

	public void initialize(int size) {
		this.size = size;
	}

	public void run(Object option) {
		if (option instanceof Integer) {
			this.nThreads = ((Integer) option).intValue();
			this.threads = new Thread[this.nThreads];

			for (int i = 0; i < this.nThreads; i++) {
				SQRTW sqrtWorker = new SQRTW(i * size / nThreads, (i + 1) * size / nThreads, i + 1);
				threads[i] = new Thread(sqrtWorker);
				threads[i].start();
			}

			for (int i = 0; i < this.nThreads; i++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {
	}

	public void warmUp() {
	}

	public void warmUp(Object option) {
	}

	public void clean() {
	}

	public String getResult() {
		return null;
	}
}
