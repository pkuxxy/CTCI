import java.util.ArrayList;
import java.util.Stack;

class SetOfStacks {
	public static final int CAPACITY = 2;
	public static final int NAN = -1000000000;
	private ArrayList<Stack<Integer>> stacks;

	public void push(int data) {
		if (null == stacks) {
			stacks = new ArrayList<Stack<Integer>>();
		}
		if (stacks.isEmpty()) {
			stacks.add(new Stack<Integer>());
		}
		if (stacks.get(stacks.size() - 1).size() >= CAPACITY) {
			stacks.add(new Stack<Integer>());
		}
		stacks.get(stacks.size() - 1).push(new Integer(data));
	}

	public int pop() {
		if (null == stacks) {
			return NAN;
		}
		if(stacks.isEmpty())
			return NAN;
		int ret = stacks.get(stacks.size()-1).pop();

		if ((stacks.size() > 0) && stacks.get(stacks.size() - 1).isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}

		return ret;
	}

	public int popAt(int index) {
		if (null == stacks || index < 0 || index >= stacks.size()) {
			return NAN;
		}
		int ret = stacks.get(index).pop();
		for(int i = index + 1; i < getStackCount(); i++)
		{
			Stack<Integer> pre = stacks.get(i - 1);
			Stack<Integer> cur = stacks.get(i);
			pre.push(cur.firstElement());
			cur.remove(cur.firstElement());
		}
		if(stacks.get(stacks.size()-1).isEmpty())
			stacks.remove(stacks.size()-1);
		return ret;
	}
	public int getStackCount()
	{
		if(null == stacks)
			return -1;
		return stacks.size();
	}
	public boolean isEmpty()
	{
		if(null == stacks)
			return true;
		return stacks.isEmpty();
	}
	public boolean isEmpty(int index)
	{
		if(null == stacks ||index < 0 || index >= stacks.size())
		{
			return true;
		}
		return stacks.get(index).isEmpty();
	}
}

public class C3_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks();
		for(int i = 0; i < 10; i++)
		{
			System.out.println("SetOfStacks.push(" + i + ");");
			stacks.push(new Integer(i));
		}
		while(!stacks.isEmpty())
		{
			System.out.println("SetOfStacks.pop() = " + stacks.pop() + ";");
		}
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println("SetOfStacks.push(" + i + ");");
			stacks.push(new Integer(i));
		}
		while(!stacks.isEmpty())
		{
			System.out.println("SetOfStacks.popAt(" + 0 + ") = " + stacks.popAt(0) + ";");
		}
	}

}
