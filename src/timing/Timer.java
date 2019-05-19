package timing;

public class Timer implements ITimer {

	private long count = 0;
	private long save = 0;

	@Override
	public void start() {
		save = 0;
		resume();
	}

	@Override
	public long stop() {
		count = System.nanoTime() - count;
		save += count;
		return save;
	}

	@Override
	public long pause() {
		count = System.nanoTime() - count;
		save += count;
		return count;
	}

	@Override
	public void resume() {
		count = System.nanoTime();
	}
}
