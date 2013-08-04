import java.util.Stack;

class MyQueue
{
	Stack<Integer> s1, s2;
	public MyQueue()
	{
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	public void enQueue(int data)
	{
		s1.push(data);
	}
	public int deQueue()
	{
		if(!s2.isEmpty())
			return s2.pop();
		while(!s1.isEmpty())
			s2.push(s1.pop());
		return s2.pop();
	}
	public int peek()
	{
		if(!s2.isEmpty())
			return s2.peek();
		while(!s1.isEmpty())
			s2.push(s1.pop());
		return s2.peek();
	}
	public int size()
	{
		return s1.size() + s2.size();
	}
	public boolean isEmpty()
	{
		return s1.isEmpty() && s2.isEmpty();
	}
}
public class C3_5 {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		for(int i = 0; i < 10; i++)
		{
			System.out.println("q.enQueue(" + i +");");
			q.enQueue(i);
		}
		while(!q.isEmpty())
		{
			System.out.println("q.deQueue() = " + q.deQueue() + ";");
		}
	}

}
