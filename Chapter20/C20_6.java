import java.util.ArrayList;

public class C20_6 {
	static ArrayList<Integer> set = new ArrayList<Integer>();

	public static int getMLargestNumIndex(int[] array, int m, int start, int end) {
		if(start > end)
			return -1;
		int rand = (int) (Math.random() * (end - start));
		int x = array[rand];
		swap(array, start, rand);
		int i = start;
		int j = end - 1;
		while (i < j) {
			while (i < j && array[j] <= x)
				j--;
			if (i < j) {
				array[i] = array[j];
				i++;
			}
			while (i < j && array[i] >= x)
				i++;
			if (i < j) {
				array[j] = array[i];
				j--;
			}
		}
		array[i] = x;
		if(i == m)
			return i - 1;
		else if(i < m)
			return getMLargestNumIndex(array, m, i+1, end);
		else
			return getMLargestNumIndex(array, m, start, i);
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,6,8,4,1,9,7,5,3};
		int m = 4;
		if(getMLargestNumIndex(array, m, 0, array.length) == -1)
		{
			System.out.println("Error!");
		}
		for(int i = 0; i < m ;i++)
		{
			System.out.print(array[i] + " ");
		}

	}

}
