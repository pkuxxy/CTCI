import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class C20_10 {
	public static LinkedList<String> transform(String startWord, String endWord, Set<String> dictionary)
	{
		Queue<String> words = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		HashMap<String, String> backtrack = new HashMap<String, String>();
		startWord = startWord.toUpperCase();
		endWord = endWord.toUpperCase();
		words.add(startWord);
		visited.add(startWord);
		while(!words.isEmpty())
		{
			String word = words.poll();
			for(String v : getOneEditWord(word))
			{
				if(v.equals(endWord))
				{
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while(word != null)
					{
						list.add(word);
						word = backtrack.get(word);
					}
					return list;
				}
				else if(dictionary.contains(v))
				{
					if(!visited.contains(v))
					{
						words.add(v);
						visited.add(v);
						backtrack.put(v, word);
					}
				}
			}
		}
		return null;
	}

	private static Set<String> getOneEditWord(String word) {
		Set<String> words = new TreeSet<String>();
		for(int i = 0; i < word.length(); i++)
		{
			char[] wordarray = word.toCharArray();
			for(char ch = 'A'; ch < 'Z'; ch++)
			{
				if(ch != wordarray[i])
				{
					wordarray[i] = ch;
					words.add(new String(wordarray));
				}
			}
		}
		return words;
	}
}
