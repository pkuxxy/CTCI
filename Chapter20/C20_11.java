class Square
{
	public int row;
	public int col;
	public int size;
	public Square(int row, int col, int size)
	{
		this.row = row;
		this.col = col;
		this.size = size;
	}
}
public class C20_11 {
	public static Square getMaxSquare(int[][] matrix)
	{
		int col = 0;
		int n = matrix.length;
		int maxSize = 0;
		Square maxSquare = null;
		while(n - col > maxSize)
		{
			for(int row = 0; row < n; row++)
			{
				int size = n - Math.max(row, col);
				while(size > maxSize)
				{
					if(isSquare(matrix, row, col, size))
					{
						maxSize = size;
						maxSquare = new Square(row, col, size);
						break;
					}
					size--;
				}
			}
			col++;
		}
		return maxSquare;
	}

	private static boolean isSquare(int[][] matrix, int row, int col, int size) {
		for(int i = 0; i < size; i++)
		{
			if(matrix[row][col+i] == 1)
				return false;
			if(matrix[row+size-1][col+i] == 1)
				return false;
			if(matrix[row+i][col] == 1)
				return false;
			if(matrix[row+i][col+size-1] == 1)
				return false;
		}
		return true;
	}
}
