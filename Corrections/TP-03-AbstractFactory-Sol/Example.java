
public class Example {

	public static void main(String argv[]) {
		AlgorithmFactory factory = null;
		if (argv[0].compareTo("CachedAlgorithm") ==0)
			factory = new CachedAlgorithm();
		if (argv[0].compareTo("StandardAlgorithm") ==0)
			factory = new StandardAlgorithm();
		Algorithm algo = factory.getFibonacci();
		System.out.println(algo.getVal(Integer.parseInt(argv[1])));
	}
}
