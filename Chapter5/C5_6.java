
public class C5_6 {

	public static int swapOddAndEven(int n)
	{
		return ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >> 1);
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println("swapOddAndEven: " + swapOddAndEven(n));
	}

}
