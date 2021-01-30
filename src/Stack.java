import java.lang.reflect.Array;

public class Stack <T>{
	private T[] stack;
	private int top;
	public Stack(Class<T> c,int size) {
		stack = (T[])Array.newInstance(c,size);
		top = -1;
	}
	
	public T[] getStack() {
		return stack;
	}
	
	public void push(T element) {
		if(stack.length != 0 && top < stack.length - 1) {
			top++;
			stack[top] = element;
		}
		else {
			if(stack.length == 0)
				System.out.println("Stack size is zero");
			else
				System.out.println("Stack is full");
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public T pop() {
		T temp = null;
		if(stack.length != 0 && top > -1) {
			temp = stack[top];
			stack[top] = null;
			top--;
			
		}else {
				if(stack.length == 0)
					System.out.println("Stack size is zero");
				else
					System.out.println("Stack is empty");
				throw new ArrayIndexOutOfBoundsException();
			}
		return temp;
	}
}
