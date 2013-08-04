
public class C8_7 {
	public static int waysCount(int n, int denom)
	{
		int nextDenom = 0;
		int count = 0;
		switch(denom)
		{
		case 25:
			nextDenom = 10;
			break;
		case 10:
			nextDenom = 5;
			break;
		case 5:
			nextDenom = 1;
			break;
		case 1:
			return 1;
		}
		for(int i = 0; (i * denom) <= n; i++)
		{
			count += waysCount(n - i * denom, nextDenom);
		}
		return count;
	}
	public static void main(String[] args)
	{
		System.out.println("Ways count of representing 100 cents: "+waysCount(100, 25));
	}
}
