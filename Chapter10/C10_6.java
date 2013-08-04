import java.awt.Point;
import java.util.HashMap;

class Line
{
	public static final double epsilon = 0.0000001;
	public double slope;
	public double yIntercept;
	public boolean infiniteSlope;
	public Line(Point a, Point b)
	{
		infiniteSlope = false;
		if(Math.abs(a.x - b.x) > epsilon)
		{
			slope = (b.y - a.y) / (b.x - a.x);
			yIntercept = a.y - slope * a.x;
		}
		else
		{
			infiniteSlope = true;
			yIntercept = a.x;	//X Intercept
		}
	}
	@Override
	public boolean equals(Object obj) {
		Line o = (Line)obj;
		if(Math.abs(slope - o.slope) < epsilon && Math.abs(yIntercept - o.yIntercept) < epsilon && infiniteSlope == o.infiniteSlope)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		int sh = (int)slope * 123;
		int ih = (int)yIntercept * 321;
		return sh | ih;
	}
}
public class C10_6 {
	public static Line getPassedMostLine(Point[] array)
	{
		HashMap<Line, Integer> lineCount = new HashMap<Line, Integer>();
		Line bestLine = null;
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				Line l = new Line(array[i], array[j]);
				if(!lineCount.containsKey(l))
					lineCount.put(l, 0);
				lineCount.put(l, lineCount.get(l)+1);
				if(bestLine == null || lineCount.get(l) > lineCount.get(bestLine))
					bestLine = l;
			}
		}
		return bestLine;
	}

}
