
public class C20_1 {

	public static int add(int a, int b)
	{
		if(b == 0)
			return a;
		int sum = a^b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}
	public static void main(String[] args)
	{
		int a = 123;
		int b = 987;
		System.out.println("add(123, 987):" + add(a, b));
	}
}
