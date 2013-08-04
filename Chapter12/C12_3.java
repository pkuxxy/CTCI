import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class C12_3 {
	public static int findNumber1() throws FileNotFoundException	//1GB memory
	{
		byte[] bitmap = new byte[0xfffffff/8];
		Scanner input = new Scanner(new File("input.txt"));
		while(input.hasNextInt())
		{
			int n = input.nextInt();
			bitmap[n/8] |= 1 << (n % 8);
		}
		for(int i = 0; i < bitmap.length; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if((bitmap[i] & (1 << j)) == 0)
					return i*8+j;
			}
		}
		System.out.println("All numbers exist!");
		return 0;
	}
	public static int findNumber2() throws FileNotFoundException	//10MB memory
	{
		int bitCount = 1048576;
		int blockCount = 4096;
		int[] block = new int[blockCount];
		byte[] bitmap = new byte[bitCount/8];
		Scanner input = new Scanner(new File("input.txt"));
		while(input.hasNext())
		{
			int n = input.nextInt();
			block[n/bitCount]++;
		}
		int start = -1;
		for(int i = 0; i < blockCount; i++)
		{
			if(block[i] < bitCount)
			{
				start = i*bitCount;
				break;
			}
		}
		if(start == -1)
		{
			System.out.println("All numbers exist!");
			return 0;
		}
		input = new Scanner(new File("input.txt"));
		while(input.hasNext())
		{
			int n = input.nextInt();
			if(n >= start && n < start+bitCount)
			{
				bitmap[(n-start)/8] |= 1 << ((n-start)%8);
			}
		}
		for(int i = 0; i < bitmap.length; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if((bitmap[i] & (1 << j)) == 0)
					return i*8+j+start;
			}
		}
		System.out.println("All numbers exist!");
		return 0;
			
	}
	
}
