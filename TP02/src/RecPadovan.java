
public class RecPadovan implements Algorithm {
	@Override
	public String getName() {
		return "Padovan";
	}

	@Override
	public double getVal(int i) {
		if (i < 3)
			return 1;
		else
			return getVal(i-2) + getVal(i-3);
	}
}