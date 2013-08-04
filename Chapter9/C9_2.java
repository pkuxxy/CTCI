import java.util.Arrays;
import java.util.Comparator;

class AnagramComparator implements Comparator<String>
{
	public String sortChars(String s)
	{
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}
	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(sortChars(o2));
	}
	
}
public class C9_2 {
	public static void main(String[] args)
	{
		String[] strs = {"silent","program","tnelis","grampro"};
		Arrays.sort(strs, new AnagramComparator());
		for(int i = 0; i < strs.length; i++)
		{
			System.out.println(strs[i]);
		}
	}
}
