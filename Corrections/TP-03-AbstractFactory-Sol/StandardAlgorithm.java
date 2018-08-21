
public class StandardAlgorithm implements AlgorithmFactory {

	@Override
	public Algorithm getFibonacci() {
		return new Fibonacci();
	}
	@Override
	public Algorithm getPadovan() {
		return new Padovan();
	}

}
