
public class C9_1{
	public static void merge(int[] a, int[] b, int na, int nb)
	{
		int total = na + nb -1;
		int i = na - 1;
		int j = nb - 1;
		while(i >= 0 && j >= 0)
		{
			if(a[i] > b[j])
				a[total--] = a[i];
			else
				a[total--] = b[j];
		}
		while(i >= 0)
		{
			a[total--] = a[i--];
		}
		while(j >= 0)
			a[total--] = b[j--];
	}
}
