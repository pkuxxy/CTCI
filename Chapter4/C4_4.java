import java.util.ArrayList;

class TreeNode
{
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int v)
	{
		value = v;
	}
}
public class C4_4 {

	public ArrayList<ArrayList<TreeNode>> getLevelLinkedList(TreeNode root)
	{
		if(null == root)
			return null;
		int level = 0;
		ArrayList<ArrayList<TreeNode>> linkedList = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		linkedList.add(level, list);
		while(true)
		{
			ArrayList<TreeNode> curList = linkedList.get(level);
			list = new ArrayList<TreeNode>();
			for(TreeNode n : curList)
			{
				if(null != n.left)
					list.add(n.left);
				if(null != n.right)
					list.add(n.right);
			}
			if(list.size() > 0)
				linkedList.add(++level, list);
			else
				break;
		}
		return linkedList;
	}
	
}
