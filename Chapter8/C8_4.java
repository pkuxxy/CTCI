import java.util.ArrayList;


public class C8_4 {
	public static ArrayList<String> getAllPerms(String s, int index)
	{
		if(null == s)
			return null;
		if(index >= s.length())
		{
			ArrayList<String> ret = new ArrayList<String>();
			ret.add("");
			return ret;
		}
		
		ArrayList<String> allStrings = new ArrayList<String>();
		for(int i = index; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			String newStr = StringSwap(s, index, i);
			ArrayList<String> allSubStrings = getAllPerms(newStr, index + 1);
			for(String str : allSubStrings)
			{
				allStrings.add(ch+str);
			}
		}
		return allStrings;
		
	}

	private static String StringSwap(String s, int p1, int p2) {
		StringBuffer sb = new StringBuffer(s);
		char ch = sb.charAt(p1);
		sb.setCharAt(p1, sb.charAt(p2));
		sb.setCharAt(p2, ch);
		return sb.toString();
	}
	public static void main(String[] args)
	{
		String str = new String("abc");
		ArrayList<String> allPerms = getAllPerms(str, 0);
		for(String perm : allPerms)
		{
			System.out.println(perm);
		}
	}
}
