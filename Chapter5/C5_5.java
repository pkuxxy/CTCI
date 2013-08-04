
public class C5_5 {
	public static int bitSwapCount(int a, int b)
	{
		int count = 0;
		for(int c = a ^ b; c != 0; c >>= 1)
		{
			count += c & 1;
		}
		return count;
	}
	public static void main(String[] args)
	{
		int a = 31;
		int b = 14;
		System.out.println("bitSwapCount: " + bitSwapCount(a, b));
	}
}
