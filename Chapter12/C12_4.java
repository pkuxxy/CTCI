
public class C12_4 {
	public static void printDuplicates(int[] array)
	{
		int bitCount = 32000;
		byte[] bitmap = new byte[bitCount/8];
		for(int i = 0; i < array.length; i++)
		{
			int n = array[i];
			if((bitmap[n/8] & (1 << (n%8))) == 1)
			{
				System.out.println("Duplicated: "+n);
			}
			else
			{
				bitmap[n/8] |= 1 << (n%8);
			}
		}
	}
}
