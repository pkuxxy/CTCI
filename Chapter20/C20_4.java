
public class C20_4 {

	public static int count2s(int num)
	{
		if(0 == num)
			return 0;
		int pow = 1;
		while(pow*10 < num)
			pow *= 10;
		int first = num / pow;
		int other = num % pow;
		int num2sFirst = 0;
		if(first > 2)
			num2sFirst += pow;
		else if (first == 2)
			num2sFirst += other;
		return first * count2s(pow - 1) + count2s(other) + num2sFirst;
	}
	public static void main(String[] args)
	{
		System.out.println("2s between 0 and 513:" + count2s(513));
		
	}
}
