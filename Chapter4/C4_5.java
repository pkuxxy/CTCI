class TreeNode
{
	public int value;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int v)
	{
		value = v;
	}
}
public class C4_5 {

	public TreeNode findNext(TreeNode n)
	{
		if(null == n)
			return null;
		TreeNode ret = null;
		if(n.right != null)
		{
			ret = n.right;
			while(ret.left != null)
				ret = ret.left;
		}
		else
		{
			while((ret = n.parent) != null)
			{
				if(ret.left == n)
					break;
				n = n.parent;
			}
		}
		return ret;
	}

}
