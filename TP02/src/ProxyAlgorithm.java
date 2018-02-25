
import java.util.HashMap;
import java.util.Map;

public abstract class ProxyAlgorithm implements Algorithm {
	private Map <Integer, Double> _hm;
	private Algorithm _proxy;
	
	public ProxyAlgorithm() {
		_hm = new HashMap<>();
		_proxy = createAlgorithm();
	}
		
	public abstract Algorithm createAlgorithm();

	@Override
	public String getName() {
		return _proxy.getName();
	}

	@Override
	public double getVal(int i) {
		if (!_hm.containsKey(i)) 
			_hm.put(i, _proxy.getVal(i));
		return _hm.get(i);
	}
}