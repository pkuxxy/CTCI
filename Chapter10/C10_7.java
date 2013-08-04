import java.util.LinkedList;


public class C10_7 {
	public static int kthNum(int k)
	{
		if(k <= 0)
			return 0;
		int value = 1;
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		LinkedList<Integer> q7 = new LinkedList<Integer>();
		q3.add(3);
		q5.add(5);
		q7.add(7);
		while(--k > 0)
		{
			value = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
			if(value == q7.peek())
			{
				q7.remove();
			}
			else
			{
				if(value == q5.peek())
					q5.remove();
				else
				{
					q3.remove();
					q3.add(value * 3);
				}
				q5.add(value * 5);
			}
			q7.add(value * 7);
		}
		return value;
	}
	public static void main(String[] args)
	{
		System.out.println("13th magic number is: " + kthNum(13));
	}
}
