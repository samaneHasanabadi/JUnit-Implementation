import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Test {

}
@Retention(RetentionPolicy.RUNTIME)
@interface Before {

}
@Retention(RetentionPolicy.RUNTIME)
@interface After {

}

public class StackUnitTest {
	
	@Before
	public void testBefore() {
		System.out.println("Stack Testing is started..");
	}
	
	@After
	public void testAfter() {
		System.out.println("Stack Testing is finieshed...");
	}

	@Test
	// Test push with Integer Type
	public void pushTest1() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,3);
		stack.push(8);
		Integer[] expected = new Integer[3];
		expected[0] = 8;
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {
				System.out.println("pushTest1 is failed");
				return;
			}
		}
		System.out.println("pushTest1 is passed");
	}

	@Test
	// Test push with String Type
	public void pushTest2() {
		Stack<String> stack = new Stack<String>(String.class,5);
		stack.push("hi");
		String[] expected = new String[5];
		expected[0] = "hi";
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("pushTest2 is failed");
				return;
			}
		}
		System.out.println("pushTest2 is passed");
	}

	@Test
	// Test push with self-defined type
	public void pushTest3() {
		Stack<Person> stack = new Stack<Person>(Person.class,10);
		stack.push(new Person("Ali", "Rezayi"));
		Person[] expected = new Person[10];
		expected[0] = new Person("Ali", "Rezayi");
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("pushTest3 is failed");
				return;
			}
		}
		System.out.println("pushTest3 is passed");
	}

	@Test
	// Test push when stack is full
	public void pushTest4() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,1);
		stack.push(3);
		try {
			stack.push(4);
			System.out.println("pushTest4 is failed");

		} catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("pushTest4 is passed");
			} else {
				System.out.println("pushTest4 is failed");
			}
		}
	}

	@Test
	// Test push when stack size is zero
	public void pushTest5() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,0);
		try {
			stack.push(4);
			System.out.println("pushTest5 is failed");

		} catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("pushTest5 is passed");
			} else {
				System.out.println("pushTest5 is failed");
			}
		}
	}

	@Test
	// Test push when stack is full and size of stack is bigger than 1
	public void pushTest6() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,6);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(35);
		stack.push(-1);
		stack.push(-40);
		try {
			stack.push(4);
			System.out.println("pushTest6 is failed");

		} catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("pushTest6 is passed");
			} else {
				System.out.println("pushTest6 is failed");
			}
		}
	}

	@Test
	// Test push when all elements in stack have value and size of the stack is
	// bigger than 1
	public void pushTest7() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,6);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(35);
		stack.push(-1);
		stack.push(-40);
		Integer[] expected = new Integer[6];
		expected[0] = 3;
		expected[1] = 2;
		expected[2] = 1;
		expected[3] = 35;
		expected[4] = -1;
		expected[5] = -40;
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("pushTest7 is failed");
				return;
			}
		}
		System.out.println("pushTest7 is passed");
	}

	@Test
	// Test push when some elements of stack have value
	public void pushTest8() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,20);
		stack.push(-1);
		stack.push(0);
		stack.push(-1);
		Integer[] expected = new Integer[20];
		expected[0] = -1;
		expected[1] = 0;
		expected[2] = -1;
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("pushTest8 is failed");
				return;
			}
		}
		System.out.println("pushTest8 is passed");
	}

	@Test
	// Test pop with Integer Type
	public void popTest1() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,2);
		stack.push(2);
		stack.push(3);
		int pop = stack.pop();
		Integer[] expected = new Integer[2];
		expected[0] = 2;
		if (pop != 3) {
			System.out.println("popTest1 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest1 is failed");
				return;
			}
		}
		System.out.println("popTest1 is passed");
	}

	@Test
	// Test pop with String Type
	public void popTest2() {
		Stack<String> stack = new Stack<String>(String.class,5);
		stack.push("hi");
		stack.push("bye");
		String pop = stack.pop();
		String[] expected = new String[5];
		expected[0] = "hi";
		if (!pop.equals("bye")) {
			System.out.println("popTest2 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest2 is failed");
				return;
			}
		}
		System.out.println("popTest2 is passed");
	}

	@Test
	// Test pop with self-defined Type
	public void popTest3() {
		Stack<Person> stack = new Stack<Person>(Person.class,4);
		stack.push(new Person("reza", "samayi"));
		stack.push(new Person("bahram", "Mirzayi"));
		Person pop = stack.pop();
		Person[] expected = new Person[4];
		expected[0] = new Person("reza", "samayi");
		if (!pop.equals(new Person("bahram", "Mirzayi"))) {
			System.out.println("popTest3 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest3 is failed");
				return;
			}
		}
		System.out.println("popTest3 is passed");
	}

	@Test
	// Test pop when stack is full
	public void popTest4() {
		Stack<Person> stack = new Stack<Person>(Person.class,1);
		stack.push(new Person("reza", "samayi"));
		Person pop = stack.pop();
		Person[] expected = new Person[1];
		if (!pop.equals(new Person("reza", "samayi"))) {
			System.out.println("popTest4 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest4 is failed");
				return;
			}
		}
		System.out.println("popTest4 is passed");
	}

	@Test
	// Test pop when stack size is zero
	public void popTest5() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,0);
		try {
			stack.pop();
			System.out.println("popTest5 is failed");

		} catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("popTest5 is passed");
			} else {
				System.out.println("popTest5 is failed");
			}
		}
	}

	@Test
	// Test pop when stack is full and size of stack is bigger than 1
	public void popTest6() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,6);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(35);
		stack.push(-1);
		stack.push(-40);
		int pop = stack.pop();
		Integer[] expected = new Integer[6];
		expected[0] = 3;
		expected[1] = 2;
		expected[2] = 1;
		expected[3] = 35;
		expected[4] = -1;
		if (pop != -40) {
			System.out.println("popTest6 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest6 is failed");
				return;
			}
		}
		System.out.println("popTest6 is passed");
	}

	@Test
	// Test pop when some elements of stack have value
	public void popTest7() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,20);
		stack.push(-1);
		stack.push(0);
		stack.push(-1);
		int pop = stack.pop();
		Integer[] expected = new Integer[20];
		expected[0] = -1;
		expected[1] = 0;
		if (pop != -1) {
			System.out.println("popTest7 is failed");
			return;
		}
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest7 is failed");
				return;
			}
		}
		System.out.println("popTest7 is passed");
	}

	@Test
	// Test pop when Stack is empty
	public void popTest8() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,20);
		try {
			stack.pop();
			System.out.println("popTest8 is failed");

		} catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("popTest8 is passed");
			} else {
				System.out.println("popTest8 is failed");
			}
		}
	}

	@Test
	// Test push and pop together
	public void pushPopTest() {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,20);
		stack.push(-1);
		stack.push(0);
		stack.pop();
		stack.push(-1);
		stack.push(45);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(78);
		Integer[] expected = new Integer[20];
		expected[0] = 78;
		for (int i = 0; i < expected.length; i++) {
			if ((expected[i] == null && stack.getStack()[i] != null)
					|| (expected[i] != null && (stack.getStack())[i] == null)
					|| ((expected[i] != null && (stack.getStack())[i] != null)
							&& !expected[i].equals((stack.getStack())[i]))) {				System.out.println("popTest7 is failed");
				return;
			}
		}
		System.out.println("popTest7 is passed");
	}
}