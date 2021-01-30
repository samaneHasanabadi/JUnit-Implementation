import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StackTest {

	public static void main(String[] args) {
		StackUnitTest sut = new StackUnitTest();
		Method[] methods = sut.getClass().getDeclaredMethods();
		Method before = null;
		Method after = null;
		for (Method m: methods) {
			if(m.getAnnotation(Before.class) != null) {
				before = m;
			}
			if(m.getAnnotation(After.class) != null) {
				after = m;
			}
		}
		for (Method m: methods) {
			if(m.getAnnotation(Test.class) != null) {
				try {
					if(before!=null)
						before.invoke(sut);
					m.invoke(sut);
					if(after!=null)
						after.invoke(sut);
					System.out.println();
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
