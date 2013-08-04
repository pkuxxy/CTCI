import java.util.ArrayList;
import java.util.HashMap;

class SuffixTreeNode
{
	private HashMap<Character, SuffixTreeNode> children;
	private ArrayList<Integer> indexes;
	public SuffixTreeNode()
	{
		children = new HashMap<Character, SuffixTreeNode>();
		indexes = new ArrayList<Integer>();
	}
	public void insert(String str, int index)
	{
		indexes.add(index);
		if(str == null || str.length() == 0)
			return;
		
		char ch = str.charAt(0);
		SuffixTreeNode child = null;
		if(children.containsKey(ch))
		{
			child = children.get(ch);
		}
		else
		{
			child = new SuffixTreeNode();
			children.put(ch, child);
		}
		String sub = str.substring(1);
		child.insert(sub, index);
	}
	public ArrayList<Integer> getIndexes(String str)
	{
		if(str == null || str.length() == 0)
			return indexes;
		char ch = str.charAt(0);
		if(children.containsKey(ch))
		{
			String sub = str.substring(1);
			SuffixTreeNode child = children.get(ch);
			return child.getIndexes(sub);
		}
		return null;
	}
}

class SuffixTree
{
	private SuffixTreeNode root;
	public SuffixTree(String str)
	{
		root = new SuffixTreeNode();
		for(int i = 0; i < str.length(); i++)
		{
			String sub = str.substring(i);
			root.insert(sub, i);
		}
	}
	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}
	
}


public class C20_8 {

	public static void main(String[] args) {
		String testString = "bibs";
		String[] stringList = { "b", "ib", "s", "bib", "ibs" };
		SuffixTree tree = new SuffixTree(testString);
		for (String s : stringList) {
			ArrayList<Integer> list = tree.getIndexes(s);
			if (list != null) {
				System.out.println(s + ": " + list.toString());
			}
		}
	}
}
