import java.util.ArrayList;

class TreeNode
{
	public int value;
	public TreeNode left;
	public TreeNode right;
}
public class C4_8 {
	public void findSumPath(TreeNode root, int sum, ArrayList<Integer> buffer, int level)
	{
		if(null == root)
			return;
		if(null == buffer)
			buffer = new ArrayList<Integer>();
		int tmp = sum;
		buffer.add(root.value);
		for(int i = level; i >= 0; i--)
		{
			tmp -= buffer.get(i);
			if(tmp == 0)
				printPath(buffer, i, level);
		}
		ArrayList<Integer> b1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> b2 = (ArrayList<Integer>) buffer.clone();
		findSumPath(root.left, sum, b1, level + 1);
		findSumPath(root.right, sum, b2, level + 1);
	}

	private void printPath(ArrayList<Integer> buffer, int start, int end) {
		for(int i = start; i <= end; i++)
			System.out.println(buffer.get(i) + " ");
		System.out.println();
		
	}
	public void findAllPath(TreeNode root, int sum)
	{
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		findSumPath(root, sum, buffer, 0);
	}
}
