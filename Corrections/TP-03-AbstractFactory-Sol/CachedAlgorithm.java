
public class CachedAlgorithm implements AlgorithmFactory {

	@Override
	public Algorithm getFibonacci() {
		return new AlgorithmCache(new Fibonacci());
	}

	@Override
	public Algorithm getPadovan() {
		return new AlgorithmCache(new Padovan());
	}
	
}
