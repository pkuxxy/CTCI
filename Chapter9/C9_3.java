
public class C9_3 {
	public static int search(int[] array, int start, int end, int value)
	{
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(array[mid] == value)
			return mid;
		if(array[start] < array[mid])
		{
			if(array[mid] < value)
				return search(array, mid+1, end, value);
			else if(array[start] > value)
				return search(array, mid+1, end, value);
			else
				return search(array, start, mid-1, value);
		}
		else
		{
			if(array[mid] > value)
				return search(array, start, mid-1, value);
			else if(array[start] > value)
				return search(array, mid+1, end, value);
			else
				return search(array, start, mid-1, value);
		}
	}
	public static void main(String[] args)
	{
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("5 is in the index: " + search(array, 0, array.length-1, 5));
	}
}
