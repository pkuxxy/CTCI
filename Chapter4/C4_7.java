class TreeNode
{
	public int value;
	public TreeNode left;
	public TreeNode right;
}
public class C4_7 {
	public boolean isSubTree(TreeNode r1, TreeNode r2)
	{
		if(null == r2)
			return true;
		if(null == r1)
			return false;
		if(r1.value == r2.value)
			return isEqual(r1, r2);
		else
			return isSubTree(r1.left, r2) || isSubTree(r1.right, r2);
	}

	private boolean isEqual(TreeNode r1, TreeNode r2) {
		if(null == r2)
			return true;
		if(null == r1)
			return false;
		if(r1.value == r2.value)
			return isEqual(r1.left, r2.left) && isEqual(r1.right, r2.right);
		return false;
	}
}
