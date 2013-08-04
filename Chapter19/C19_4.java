
public class C19_4 {

	public static int getMax(int a, int b)
	{
		int c = a - b;
		int sign = (c >> (Integer.SIZE-1)) & 1;
		return a - sign * (a - b);
	}
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		System.out.println("getMax(5, 10) = " + getMax(a, b));
	}

}
