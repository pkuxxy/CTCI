import java.awt.Point;
import java.util.ArrayList;


public class C8_2 {
	public static int n = 4;
	public static int[][] array = new int[n][n];
	public static int count = 0;
	public static ArrayList<Point> path = new ArrayList<Point>();
	public static void getAllPath(int row, int col, int index)
	{
		if(row >= n || col >= n || array[row][col] == 1)
			return;
		path.add(index, new Point(row, col));
		if(row == n-1 && col == n-1)
		{
			count ++;
			System.out.print("Path " + count + ": ");
			for(int i = 0; i <= index; i++)
			{
				System.out.print("(" + path.get(i).x + ", " + path.get(i).y + ") ");
			}
			System.out.println();
			return;
		}
		
		getAllPath(row+1, col, index+1);
		getAllPath(row, col+1, index+1);
	}
	public static void main(String[] args)
	{
		count = 0;
		getAllPath(0, 0, 0);
		System.out.println("Count: "+count);
	}
}
