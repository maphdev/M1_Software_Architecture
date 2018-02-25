public class RecFactory implements AlgorithmFactory {
	public Algorithm createFibonacci() {
		return new RecFibonacci();
	}
	
	public Algorithm createPadovan() {
		return new RecPadovan();
	}
}