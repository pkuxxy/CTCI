
public class C19_1 {
	public static void swap(int a, int b)
	{
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

}
