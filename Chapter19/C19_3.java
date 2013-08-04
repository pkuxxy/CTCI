
public class C19_3 {

	public static int numZeros(int num)
	{
		int count = 0;
		for(int i = 5; num/i > 0; i *= 5)
		{
			count += num/i;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(""+numZeros(100));
	}

}
