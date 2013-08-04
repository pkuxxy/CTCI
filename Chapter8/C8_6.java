import java.awt.Point;


public class C8_6 {
	public static void paintFill(int[][] array, int n, Point p, int oldColor, int newColor)
	{
		if(p.x >= n || p.x <0 || p.y >= n || p.y < 0 ||  array[p.x][p.y] != oldColor)
			return;
		array[p.x][p.y] = newColor;
		paintFill(array, n, new Point(p.x-1, p.y), oldColor, newColor);
		paintFill(array, n, new Point(p.x+1, p.y), oldColor, newColor);
		paintFill(array, n, new Point(p.x, p.y-1), oldColor, newColor);
		paintFill(array, n, new Point(p.x, p.y+1), oldColor, newColor);	
	}
	public static void main(String[] args)
	{
		int n = 4;
		int[][] array = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
		System.out.println("Original screen:");
		printScreen(array,n);
		Point click = new Point(1,1);
		paintFill(array, n, click, array[click.x][click.y], 2);
		System.out.println("After Paint:");
		printScreen(array,n);
	}
	
	private static void printScreen(int[][] array, int n) {
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
				System.out.print(array[i][j]+" ");
			System.out.println();
		}
	}
}
