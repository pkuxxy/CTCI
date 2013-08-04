
public class C20_12 {
	public static int getMaxArea(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] sumMatrix = computeArea(matrix);
		int maxArea = Integer.MIN_VALUE;
		for(int row1 = 0; row1 < rows; row1++)
		{
			for(int row2 = row1; row2 < rows; row2++)
			{
				for(int col1 = 0; col1 < cols; col1++)
				{
					for(int col2 = col1; col2 < cols; col2++)
					{
						int curArea = getArea(sumMatrix, row1, row2, col1, col2);
						if(maxArea < curArea)
							maxArea = curArea;
					}
				}
			}
		}
		return maxArea;
	}

	private static int getArea(int[][] sum, int row1, int row2, int col1,
			int col2) {
		if(row1 == 0 && col1 == 0)
			return sum[row2][col2];
		else if(row1 == 0)
			return sum[row2][col2] - sum[row2][col1-1];
		else if(col1 == 0)
			return sum[row2][col2] - sum[row1-1][col2];
		else
			return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
	}

	private static int[][] computeArea(int[][] matrix) {
		int[][] sum = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < sum.length; i++)
		{
			for(int j = 0; j < sum[0].length; j++)
			{
				if(i == 0 && j == 0)
					sum[i][j] = matrix[i][j];
				else if(i == 0)
					sum[i][j] = sum[i][j-1] + matrix[i][j];
				else if(j == 0)
					sum[i][j] = sum[i-1][j] + matrix[i][j];
				else
					sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
			}
		}
		return sum;
	}
}
