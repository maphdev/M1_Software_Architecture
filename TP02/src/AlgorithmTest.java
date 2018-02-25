import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import junit.framework.Assert;

public class AlgorithmTest {
	private Algorithm fRec;
	private ProxyAlgorithm fProxy;
	private Algorithm pRec;
	private ProxyAlgorithm pProxy;
		
	@Before
	public void Before() {
		fRec = new RecFibonacci();
		fProxy = new ProxyFibonacci();
		pRec = new RecPadovan();
		pProxy = new ProxyPadovan();
	}
	
	@Test
	public void test() {
		Assert.assertEquals("Fibonacci", fRec.getName());
		Assert.assertEquals("Padovan", pRec.getName());
		for (int i = 0; i < 10; i++) {
			Assert.assertEquals(fRec.getVal(i), fProxy.getVal(i));
			Assert.assertEquals(pRec.getVal(i), pProxy.getVal(i));
		}
	}
}

