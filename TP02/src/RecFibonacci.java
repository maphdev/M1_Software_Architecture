

public class RecFibonacci implements Algorithm {
	@Override
	public String getName() {
		return "Fibonacci";
	}

	@Override
	public double getVal(int i) {
		if (i < 2)
			return 1;
		else
			return getVal(i-1) + getVal(i-2);
	}
}