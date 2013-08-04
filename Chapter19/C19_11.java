import java.util.Arrays;


public class C19_11 {
	public static void printPairSum(int[] array, int sum)
	{
		int start = 0;
		int end = array.length;
		Arrays.sort(array);
		while(start < end)
		{
			int curSum = array[start] + array[end];
			if(curSum == sum)
			{
				System.out.println(array[start] + " " + array[end]);
				start++;
				end--;
			}
			else if(curSum < sum)
				start++;
			else
				end--;
		}
	}
}
