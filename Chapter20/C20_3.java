
public class C20_3 {

	public static int[] pickMNums(int[] array, int m)
	{
		int[] set = new int[m];
		int[] a = array.clone();
		for(int i = 0; i < m; i++)
		{
			int rand = (int)(Math.random()*(a.length - i));
			set[i] = a[rand];
			a[rand] = a[a.length - 1 - i];
		}
		return set;
	}
}
