class TreeNode
{
	private int value;
	private TreeNode left;
	private TreeNode right;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
public class C4_1 {
	public int maxDepth(TreeNode tree)
	{
		if(null == tree)
			return 0;
		return 1 + Math.max(maxDepth(tree.getLeft()),maxDepth(tree.getRight()));
	}
	public int minDepth(TreeNode tree)
	{
		if(null == tree)
			return 0;
		return 1 + Math.min(minDepth(tree.getLeft()), minDepth(tree.getRight()));
	}
	public boolean isBalance(TreeNode tree)
	{
		return (maxDepth(tree) - minDepth(tree)) <= 1;
	}

}
