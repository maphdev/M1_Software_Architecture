import java.util.Hashtable;

public class AlgorithmCache implements Algorithm {
	private Algorithm delegate;
	private Hashtable<Integer, Double> cache;
	
	public AlgorithmCache(Algorithm delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public double getVal(int i) {
		if (!cache.contains(i))
			cache.put(i, delegate.getVal(i));
		return cache.get(i);
	}
}
