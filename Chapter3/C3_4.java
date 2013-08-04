import java.util.Stack;

class Tower extends Stack<Integer> {
	private int index;

	public Tower(int index) {
		this.index = index;
	}

	private int getIndex() {
		return index;
	}

	@Override
	public Integer push(Integer item) {
		if (!this.isEmpty() && this.peek() <= item) {
			System.out.println("Error when moving disk " + item + "!");
		}
		return super.push(item);
	}

	public void moveTopTo(Tower dest) {
		int top = this.pop();
		dest.push(top);
		System.out.println("Move disk " + top + " from Tower " + this.index
				+ " to Tower " + dest.getIndex() + ";");
	}

	public void moveDisks(int n, Tower dest, Tower temp) {
		if (n <= 0)
			return;
		moveDisks(n - 1, temp, dest);
		moveTopTo(dest);
		temp.moveDisks(n - 1, dest, this);
	}

}

public class C3_4 {

	public static void main(String[] args) {
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; i++)
		{
			towers[i] = new Tower(i);
		}
		for(int i = 4; i>= 0; i--)
		{
			towers[0].push(i);
		}
		towers[0].moveDisks(4, towers[1], towers[2]);

	}

}
