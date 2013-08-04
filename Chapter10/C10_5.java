import java.awt.Point;

class Line
{
	public Point a;
	public Point b;
	public Line(Point a, Point b)
	{
		this.a = a;
		this.b = b;
	}
}
class Square
{
	public Point lt;
	public Point rb;
	public Square(Point lt, Point rb)
	{
		this.lt = lt;
		this.rb = rb;
	}
	public Point getCenter()
	{
		return new Point((lt.x + rb.x) >> 1, (lt.y + rb.y) >> 1);
	}
	public Line getCutLine(Square other)
	{
		Point ca = getCenter();
		Point cb = other.getCenter();
		if(ca.x == cb.x && ca.y == cb.y)
			return new Line(lt, rb);
		return new Line(ca, cb);
	}
}
public class C10_5 {

}
