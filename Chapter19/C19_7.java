
public class C19_7 {

	public static int getMaxSum(int[] array)
	{
		int max = 0;
		int sum = 0;
		for(int i = 0 ;i < array.length; i++)
		{
			sum += array[i];
			if(sum < 0)
			{
				sum = 0;
			}
			if(max < sum)
				max = sum;
		}
		return max;
	}

}
