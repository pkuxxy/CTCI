import java.awt.Point;


public class C9_6 {
	public static Point findElement(int[][] array, int m, int n, int value)
	{
		int row = 0;
		int col = n - 1;
		while(row < m && col >= 0)
		{
			if(array[row][col] == value)
				return new Point(row, col);
			if(array[row][col] < value)
				row++;
			else
				col--;
		}
		return new Point(-1, -1);
	}

}
