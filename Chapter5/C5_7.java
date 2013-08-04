import java.util.ArrayList;


public class C5_7 {

	public static int findMissing(ArrayList<Integer> array, int col)
	{
		if(col < 0)
			return 0;
		ArrayList<Integer> indics0 = new ArrayList<Integer>();
		ArrayList<Integer> indics1 = new ArrayList<Integer>();
		for(Integer n : array)
		{
			if(getBit(n, col) == 1)
				indics1.add(n);
			else
				indics0.add(n);
		}
		if(indics1.size() >= indics0.size())
			return (findMissing(indics0, col - 1) << 1) | 0;
		else
			return (findMissing(indics1, col - 1) << 1) | 1;
	}
	private static int getBit(Integer n, int col) {
		return n & (1 << (31 - col));
	}
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i <=5; i++)
		{
			array.add(i);
		}
		array.remove(3);
		System.out.println("" + findMissing(array, Integer.SIZE - 1));

	}

}
