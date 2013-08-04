
public class C5_2 {
	public static void printBinary(String s)
	{
		if(null == s)
			return;
		String[] parts = s.split("\\.");
		boolean hasDecPart = true;
		if(parts.length < 2)
			hasDecPart = false;
		int intPart = Integer.parseInt(parts[0]);
		String intString = new String();
		while(intPart > 0)
		{
			intString = intPart % 2 + intString;
			intPart >>= 1;
		}
		if(!hasDecPart)
		{
			System.out.println(intString);
			return;
		}
		
		if(!canBeRepresentedInBinary(parts[1]))
		{
			System.out.println("ERROR");
			return;
		}
		double decPart = Double.parseDouble("." + parts[1]);
		String decString = new String();
		while(decPart > 0)
		{
			decPart *= 2;
			if(decPart >= 1)
			{
				decString += 1;
				decPart -= 1;
			}
			else
			{
				decString += 0;
			}
		}
		System.out.println(intString + "." + decString);
		
	}

	private static boolean canBeRepresentedInBinary(String s) {
		if(null == s)
			return false;
		int numerator = Integer.parseInt(s);
		int denominator = (int) Math.pow(10, s.length());
		int g = gcd(numerator, denominator);
		denominator /= g;
		return (denominator & (denominator - 1)) == 0;
	}

	private static int gcd(int a, int b) {
		int r = 0;
		while((r = a % b)!= 0)
		{
			a = b;
			b = r;
		}
		return b;
	}
	public static void main(String[] args)
	{
		String s = "3.125";
		printBinary(s);
	}

}
