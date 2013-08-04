
public class C8_1 {
	public int f1(int n)	//recursive
	{
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return f1(n-1) + f1(n-2);
	}
	public int f2(int n)
	{
		if(n <= 0)
			return 0;
		int a = 1;
		int b = 1;
		for(int i = 3; i <= n; i++)
		{
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
