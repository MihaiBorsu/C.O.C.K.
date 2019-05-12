package logging;

public enum TimeUnit {
	nano, micro, milli, sec;
	public static double toTimeUnit(long time, TimeUnit unit) {
		switch (unit) {
		case nano:
			return time;
		case micro:
			return time / 1000.0;
		case milli:
			return time / 1000000.0;
		case sec:
			return time / 1000000000.0;
		default:
			return time;
		}
	}
}
