
public class C20_5 {

	public static int shortest(String[] words, String word1, String word2)
	{
		int min = words.length;
		int word1Pos = -words.length;
		int word2Pos = -words.length;
		for(int i = 0; i < words.length; i++)
		{
			if(words[i].equals(word1))
			{
				word1Pos = i;
				if(word1Pos - word2Pos < min)
					min = word1Pos - word2Pos;
			}
			else if(words[i].equals(word2))
			{
				word2Pos = i;
				if(word2Pos - word1Pos < min)
					min = word2Pos - word1Pos;
			}
		}
		return min;
	}
}
