
public class C8_8 {
	public static int n = 8;
	public static int[] array = new int[n];
	public static void placeQuene(int row)
	{
		if(row >= 8)
		{
			printChess();
			return;
		}
		for(int i = 0; i < n; i++)
		{
			if(noConflict(row, i))
			{
				array[row] = i;
				placeQuene(row+1);
			}
		}
	}
	private static boolean noConflict(int row, int col) {
		for(int i = 0; i < row; i++)
		{
			if(array[i] == col)
				return false;
			int data = array[i];
			if((i + data) == (row + col) || (i - data) == (row - col))
				return false;
		}
		return true;
	}
	private static void printChess() {
		System.out.print("Queens Arrangment:");
		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		placeQuene(0);
	}

}
