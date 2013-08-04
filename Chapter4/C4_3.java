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
public class C4_3 {

	public static TreeNode addToTree(int[] array, int start, int end)
	{
		if(end < start)
			return null;
		int mid = (start + end)/2;
		TreeNode ret = new TreeNode(array[mid]);
		ret.left = addToTree(array, start, mid - 1);
		ret.right = addToTree(array, mid + 1, end);
		return ret;
	}
	public static TreeNode createMinDepthBST(int[] array)
	{
		return addToTree(array, 0, array.length - 1);
	}
}
