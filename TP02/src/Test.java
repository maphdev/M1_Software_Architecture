
public class Test {
	public static void main(String[] argv) {
		AlgorithmFactory algoFac1 = new RecFactory();
		Algorithm fib1 = algoFac1.createFibonacci();
		Algorithm pad1 = algoFac1.createPadovan();
		
		AlgorithmFactory algoFac2 = new ProxyFactory();
		Algorithm fib2 = algoFac2.createFibonacci();
		Algorithm pad2 = algoFac2.createPadovan();
		
		System.out.println(fib1.getName());
		System.out.println(Double.toString(fib1.getVal(10)));
		System.out.println(pad1.getName());
		System.out.println(Double.toString(pad1.getVal(10)));
		
		System.out.println(fib2.getName());
		System.out.println(Double.toString(fib2.getVal(10)));
		System.out.println(pad2.getName());
		System.out.println(Double.toString(pad2.getVal(10)));
	}
}
