import java.util.Arrays;
import java.util.Comparator;

class LengthComparator implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() == o2.length())
			return o2.compareTo(o1);
		return o2.length() - o1.length();
	}
	
}
public class C20_7 {

	public static void findLongestPairWord(String[] words)
	{
		Arrays.sort(words, new LengthComparator());
		for(int i = 0 ; i < words.length; i++)
		{
			String word = words[i];
			for(int j = 1 ; j < word.length() - 1 ; j++)
			{
				String first = word.substring(0, j);
				String second = word.substring(j, word.length());
				if(findWord(words, first, i, words.length-1) && findWord(words, second, i, words.length-1))
				{
					System.out.println(words[i] + ": " + first + ", " + second);
				}
			}
		}
	}
	private static boolean findWord(String[] words, String word, int start, int end) {
		if(end < start)
			return false;
		int mid = (start + end) / 2;
		if(words[mid].equals(word))
			return true;
		if(words[mid].length() > word.length())
			return findWord(words, word, mid+1, end);
		else if(words[mid].length() < word.length())
			return findWord(words, word, start, mid-1);
		else
		{
			if(words[mid].compareTo(word) > 0)
				return findWord(words, word, mid+1, end);
			else
				return findWord(words, word, start, mid-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = {"student","graduate", "graduatestudent", "birth","birthday","day"};
		findLongestPairWord(words);
	}

}
