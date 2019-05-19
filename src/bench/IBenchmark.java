package bench;

public interface IBenchmark {
	public void initialize(int size);

	public void run();

	public void run(Object option);

	public String getResult();

	public void clean();

	public void warmUp();

	public void warmUp(Object option);
}
