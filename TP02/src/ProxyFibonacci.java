public class ProxyFibonacci extends ProxyAlgorithm {
	@Override
	public Algorithm createAlgorithm() {
		return new RecFibonacci();
	}
}