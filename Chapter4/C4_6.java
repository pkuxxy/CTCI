import java.util.ArrayList;

class TreeNodeWithPar	//tree node with a parent pointer
{
	public int value;
	public TreeNodeWithPar parent;
	public TreeNodeWithPar left;
	public TreeNodeWithPar right;
}
class TreeNode
{
	public int value;
	public TreeNode left;
	public TreeNode right;
}
public class C4_6 {
	
	//find common ancestor in a tree whose tree node has a parent pointer
	public TreeNodeWithPar commonAncestor(TreeNodeWithPar root, TreeNodeWithPar p, TreeNodeWithPar q)
	{
		if(null == root || null == p || null == q)
			return null;
		if(p == q)
			return p;
		ArrayList<TreeNodeWithPar> ppath = new ArrayList<TreeNodeWithPar>();
		ArrayList<TreeNodeWithPar> qpath = new ArrayList<TreeNodeWithPar>();
		while(p != null)
		{
			ppath.add(p);
			p = p.parent;
		}
		while(q != null)
		{
			qpath.add(q);
			q = q.parent;
		}
		int i = ppath.size() - 1;
		int j = qpath.size() - 1;
		while(ppath.get(i) == qpath.get(j))
		{
			i--;
			j--;
		}
		return ppath.get(i+1);
	}
	
	//find common ancestor method 1
	public TreeNode commonAncestor1(TreeNode root, TreeNode p, TreeNode q)
	{
		if(null == root || null == p || null == q)
			return null;
		if(covers(root.left, p) && covers(root.left, q))
			return commonAncestor1(root.left, p, q);
		else if(covers(root.right, p) && covers(root.right, q))
			return commonAncestor1(root.right, p, q);
		else
			return root;
	}
	public boolean covers(TreeNode root, TreeNode n)
	{
		if(null == root || null == n)
			return false;
		if(root == n)
			return true;
		return covers(root.left, n) || covers(root.right, n);
	}
	
	//find common ancestor method 2
	public TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q)
	{
		if(null == root || null == p || null == q)
			return null;
		if(root == p || root == q)
			return root;
		int leftCover = coverCount(root.left, p, q);
		if(leftCover == 2)
			return commonAncestor2(root.left, p, q);
		
		int rightCover = coverCount(root.right, p, q);
		if(rightCover == 2)
			return commonAncestor2(root.right, p, q);
		
		if(leftCover == 1 && rightCover == 1)
			return root;
		return null;
		
	}
	public int coverCount(TreeNode root, TreeNode p, TreeNode q)
	{
		if(null == root || null == p || null == q)
			return 0;
		int ret = 0;
		if(root == p || root == q)
			ret += 1;
		ret += coverCount(root.left, p, q);
		if(ret == 2)
			return ret;
		return ret + coverCount(root.right, p, q);
	}

}
