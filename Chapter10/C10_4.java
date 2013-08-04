
public class C10_4 {
	public static int negate(int n)
	{
		int neg = 0;
		int d = (n > 0)? -1 : 1;
		while(n != 0)
		{
			neg += d;
			n += d;
		}
		return neg;
	}
	public static int minus(int a, int b)
	{
		return a + negate(b);
	}
	public static int abs(int n)
	{
		if(n < 0)
			n = negate(n);
		return n;
	}
	public static int times(int a, int b)
	{
		if(a > b)
			return times(b, a);
		int count = abs(a);
		int sum = 0;
		while(count-- > 0)
		{
			sum += b;
		}
		if(a < 0)
			sum = negate(sum);
		return sum;
	}
	public static boolean diffSighs(int a, int b)
	{
		if((a < 0 && b > 0) || (a > 0 && b < 0))
			return true;
		return false;
	}
	public static int divide(int a, int b) throws ArithmeticException
	{
		if(b == 0)
			throw new ArithmeticException("Divide by 0!");
		int divend = abs(a);
		int divisor = abs(b);
		int quotient = 0;
		divend -= divisor;
		while(divend >= 0)
		{
			quotient ++;
			divend -= divisor;
		}
		if(diffSighs(a, b))
			quotient = negate(quotient);
		return quotient;
			
	}
}
