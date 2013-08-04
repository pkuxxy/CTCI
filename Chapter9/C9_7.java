import java.util.Arrays;
import java.util.Comparator;

class Person
{
	public int ht;
	public int wt;
	public Person(int h, int w)
	{
		ht = h;
		wt = w;
	}
}
class HtComperator implements Comparator<Person>
{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.ht == o2.ht)
			return o1.wt - o2.wt;
		return o1.ht - o2.ht;
	}
	
}
public class C9_7 {

	private static int bSearch(int[] c, int l, int r,int value) {
		if(l == r)
			return l;
		int mid = (l + r) >> 1;
		if(c[mid] < value )
			return bSearch(c, l, mid, value);
		else
			return bSearch(c, mid+1, r, value);
	}
	
	public static int findMaxSeq(Person[] array)
	{
		Arrays.sort(array, new HtComperator());
		int[] c = new int[array.length + 1];
		int len = 0;
		c[0] = -1;
		int j = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i].wt > c[len])
				j = ++len;
			else
				j = bSearch(c,1,len,array[i].wt);
			c[j] = array[i].wt;
		}
		return len;
	}
	public static void main(String[] args)
	{
		Person[] persons = new Person[6];
		persons[0] = new Person(65, 100);
		persons[1] = new Person(70, 150);
		persons[2] = new Person(56, 90);
		persons[3] = new Person(75, 190);
		persons[4] = new Person(60, 95);
		persons[5] = new Person(68, 110);
		System.out.println("Max length: " + findMaxSeq(persons));
	}

}
