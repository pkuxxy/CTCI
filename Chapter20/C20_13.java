
import java.util.ArrayList;
import java.util.HashMap;

class WordGroup
{
	private ArrayList<String> words;
	public WordGroup()
	{
		words = new ArrayList<String>();
	}
	public void add(String s)
	{
		words.add(s);
	}
	public String[] getWords()
	{
		return words.toArray(new String[0]);
	}
	public boolean isEmpty()
	{
		return words.isEmpty();
	}
	public static WordGroup[] createGroupList(String[] dict) {
		HashMap<Integer, WordGroup> lengthMap = new HashMap<Integer, WordGroup>();
		int maxLen = 0;
		for(String word : dict)
		{
			int len = word.length();
			if(len > maxLen)
				maxLen = len;
			WordGroup group = null;
			if(!lengthMap.containsKey(len))
			{
				group = new WordGroup();
				lengthMap.put(len, group);
			}
			group = lengthMap.get(len);
			group.add(word);
		}
		WordGroup[] grouplist = new WordGroup[maxLen];
		for(Integer len : lengthMap.keySet())
		{
			grouplist[len - 1] = lengthMap.get(len);
		}
		return grouplist;
	}
	
}
class Trie
{
	public Trie(String[] words) {
		//Construct a trie tree;
	}
	
}
class Rectangle
{
	public int length;
	public int height;
	public ArrayList<String> words;

	public Rectangle(int length) {
		this.length = length;
	}

	public boolean isComplete(WordGroup wordGroup) {
		//check if the columns of the rectangle form a word in the wordGroup
		return false;
	}

	public boolean isPartialOk(Trie trie) {
		//check if the partial columns of the rectangle can be found in trie
		return false;
	}

	public Rectangle append(String string) {
		words.add(string);
		return this;
	}
	
}
public class C20_13 {
	static WordGroup[] grouplist;
	static Trie[] trie;
	public static Rectangle getMaxRectangle(String[] dictionary)
	{
		 grouplist = WordGroup.createGroupList(dictionary);
		 int maxLen = grouplist.length;
		 trie = new Trie[maxLen];
		 int size;
		 for(size =  maxLen * maxLen; size > 0; size--)
		 {
			 for(int i = 1; i <= maxLen; i++)
			 {
				 if(size % i == 0)
				 {
					 int j = size / i;
					 Rectangle rec = makeRectangle(i, j);
					 if(rec != null)
						 return rec;
				 }
			 }
		 }
		 return null;
	}
	private static Rectangle makeRectangle(int length, int height) {
		if(grouplist[length-1].isEmpty() || grouplist[height-1].isEmpty())
			return null;
		if(trie[height - 1] == null)
		{
			trie[height - 1] = new Trie(grouplist[height-1].getWords());
		}
		return makePartialRectangle(length, height, new Rectangle(length));
	}
	private static Rectangle makePartialRectangle(int l, int h,
			Rectangle rec) {
		if(rec.height == h)
		{
			if(rec.isComplete(grouplist[h-1]))
				return rec;
			return null;
		}
		if(!rec.isPartialOk(trie[h-1]))
			return null;
		for(int i = 0; i < grouplist[l-1].getWords().length;i++)
		{
			Rectangle newRec = rec.append(grouplist[l-1].getWords()[i]);
			Rectangle rect = makePartialRectangle(l, h, newRec);
			if(rect != null)
				return rect;
		}
		return null;
	}
	
}
