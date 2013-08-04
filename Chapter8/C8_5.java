
public class C8_5 {
	public static int leftCount = 0;
	public static int rightCount = 0;
	public static int total = 4;
	public static char[] str = new char[2*total];
	public static void printAllPairs(int index)
	{
		if(index >= 2*total)
		{
			System.out.println(str);
			return;
		}
		if(leftCount < total)
		{
			if(leftCount < rightCount)
				return;
			
			str[index] = '(';
			leftCount++;
			printAllPairs(index + 1);
			leftCount--;
			
			if(leftCount == rightCount)
				return;
			
			str[index] = ')';
			rightCount++;
			printAllPairs(index + 1);
			rightCount--;
		}
		else
		{
			str[index] = ')';
			rightCount++;
			printAllPairs(index + 1);
			rightCount--;
		}
		
	}

	public static void main(String[] args)
	{
		printAllPairs(0);
	}

}
