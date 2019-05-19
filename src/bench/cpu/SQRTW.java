package bench.cpu;

public class SQRTW implements Runnable {

	private int start;
	private int end;
	private int id;

	public SQRTW(int start, int end, int id) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++)
			computeSQRT(i);
	}

	private double computeSQRT(double c) {
		if (c < 0)
			return Double.NaN;
		double EPS = 1E-15;
		double t = c;
		while (Math.abs(t - c / t) > EPS * t)
			t = (c / t + t) / 2.0;
		return t;
	}
}
