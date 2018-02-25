
public class ProxyFactory implements AlgorithmFactory {
	public Algorithm createFibonacci() {
		return new ProxyFibonacci();
	}
	
	public Algorithm createPadovan() {
		return new ProxyPadovan();
	}
}