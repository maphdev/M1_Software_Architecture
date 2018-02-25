
public class ProxyPadovan extends ProxyAlgorithm {
	@Override
	public Algorithm createAlgorithm() {
		return new RecPadovan();
	}
}