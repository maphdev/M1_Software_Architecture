import java.lang.reflect.*;

public class Introspection {
	public static void main(String[] argv) {
		try {
			
			// Factory instance
			Class<?> c1 = Class.forName(argv[0]);
			Method m1 = c1.getMethod("createFibonacci", (Class<?>[]) null);
			Object o1 = c1.newInstance();
			
			System.out.println(c1.getName());
			System.out.println(m1.getName());

			// Algorithm instance
			Object o2 = m1.invoke(o1, (Object[]) null);
			Class<?> c2 = Class.forName(o2.getClass().getName());
			Method m2 = c2.getMethod("getVal",  new Class<?>[] {int.class});
			
			System.out.println(c2.getName());
			System.out.println(m2.getName());

			// result
			double result = (double) m2.invoke(o2, Integer.parseInt(argv[1]));
			
			System.out.println(Double.toString(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
