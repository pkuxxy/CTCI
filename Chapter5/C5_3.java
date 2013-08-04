
public class C5_3 {
	public static int getNext(int n)
	{
		String bin = Integer.toBinaryString(n);
		boolean find1 = false;
		int indexOf1 = 0;
		int indexOf0 = 0;
		int i = 0;
		for(i = bin.length() - 1; i >= 0; i--)
		{
			if(bin.charAt(i) == '1' && !find1)
			{
				find1 = true;
				indexOf1 = i;
			}
			else if(bin.charAt(i) == '0' && find1)
			{
				indexOf0 = i;
				break;
			}
		}
		if(i < 0)
		{
			if(find1 && bin.length() < 32)
			{
				bin = "0" + bin;
				indexOf0 = 0;
				indexOf1 += 1;
			}
			else
			{
				System.out.println("The number " + n + " is max, no next number!");
				return -1;
			}
		}
		StringBuffer sb = swap(new StringBuffer(bin), indexOf0, indexOf1);
		sb = reverse(sb, indexOf0 + 1, sb.length() - 1);
		return binaryString2Int(sb);
	}
	
	public static int getPre(int n)
	{
		String bin = Integer.toBinaryString(n);
		boolean find0 = false;
		int indexOf1 = 0;
		int indexOf0 = 0;
		int i = 0;
		for(i = bin.length() - 1; i >= 0; i--)
		{
			if(bin.charAt(i) == '0' && !find0)
			{
				find0 = true;
				indexOf0 = i;
			}
			else if(bin.charAt(i) == '1' && find0)
			{
				indexOf1 = i;
				break;
			}
		}
		if(i < 0)
		{
			System.out.println("The number " + n + " is min, no previous number!");
			return -1;
		}
		StringBuffer sb = swap(new StringBuffer(bin), indexOf0, indexOf1);
		sb = reverse(sb, indexOf1 + 1, sb.length() - 1);
		return binaryString2Int(sb);
	}
	
	private static StringBuffer swap(StringBuffer bin, int i, int j) {
		StringBuffer sb = new StringBuffer(bin);
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb;
	}
	private static StringBuffer reverse(StringBuffer sb, int i, int j) {
		while(i < j)
		{
			sb = swap(sb, i, j);
			i++;
			j--;
		}
		return sb;
	}

	private static int binaryString2Int(StringBuffer sb) {
		int sum = 0;
		for(int i = 0; i < sb.length(); i++)
		{
			sum *= 2;
			sum += sb.charAt(i) - '0';
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int n = 6;
		System.out.println("Number: " + Integer.toBinaryString(n));
		System.out.println("Next number: "+Integer.toBinaryString(getNext(n)));
		System.out.println("Previous number: "+Integer.toBinaryString(getPre(n)));
	}
}
