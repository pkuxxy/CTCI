
public class C19_6 {

	static String[] wordarr1 = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine"};
	static String[] wordarr10 = {"","", "Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] wordayy11 = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String int2String(int num)
	{
		StringBuilder sb = new StringBuilder();
		int len = 0;
		int tmp = num;
		while(tmp > 0)
		{
			len++;
			tmp >>= 1;
		}
		if(len > 3)
		{
			sb.append(get3BitString(num/1000)).append(" Thousand");
		}
		int low3Bit = num%1000;
		if(low3Bit == 0)
			return sb.toString();
		sb.append(", ");
		sb.append(get3BitString(num%1000));
		return sb.toString();
	}

	private static String get3BitString(int num) {
		StringBuilder sb = new StringBuilder();
		int bit = num/100;
		if(bit != 0)
		{
			sb.append(wordarr1[bit]).append(" Hundred");
		}
		num %= 100;
		if(num == 0)
			return sb.toString();
		sb.append(" and ");
		bit = num/10;
		if(bit == 1)
		{
			sb.append(wordayy11[num%10]);
		}
		else
		{
			sb.append(wordarr10[bit]).append(" ").append(wordarr1[num%10]);
		}
		return sb.toString();
	}
	public static void main(String[] args)
	{
		int num = 123456;
		System.out.println(int2String(num));
	}
}
