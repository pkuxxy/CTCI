import java.util.Random;
import java.util.Stack;

public class C3_6 {
	public static void stackSort(Stack<Integer> s) {
		if (null == s)
			return;
		Stack<Integer> s1 = new Stack<Integer>();
		int insert;
		while (true) {
			while (!s.isEmpty() && (s1.isEmpty() || s1.peek() >= s.peek())) {
				s1.push(s.pop());
			}
			if (s.isEmpty())
				break;
			insert = s.pop();
			while (!s1.isEmpty()) {
				if (s1.peek() >= insert)
					break;
				s.push(s1.pop());
			}
			s.push(insert);
			while (!s1.isEmpty())
				s.push(s1.pop());
		}
		while (!s1.isEmpty())
			s.push(s1.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			s.push(rand.nextInt(100));
		}
		System.out.println("Before sort, the stack is: ");
		printStack(s);
		stackSort(s);

		System.out.println("After sort, the stack is: ");
		printStack(s);
	}

	private static void printStack(Stack<Integer> s) {

		if (null == s || s.isEmpty())
			return;
		int data = s.pop();
		printStack(s);
		System.out.println(data);
		s.push(data);
	}

}
