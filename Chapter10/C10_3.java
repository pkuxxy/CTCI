class Line
{
	public static final double epsilon = 0.0000001;
	private double slope;
	private double yIntercept;
	public Line(double s, double y)
	{
		setSlope(s);
		this.setYIntercept(y);
	}

	public double getSlope() {
		return slope;
	}
	public void setSlope(double slope) {
		this.slope = slope;
	}
	public double getYIntercept() {
		return yIntercept;
	}
	public void setYIntercept(double y) {
		this.yIntercept = y;
	}
	public boolean intersect(Line l)
	{
		if(Math.abs(getSlope() - l.getSlope()) < epsilon || Math.abs(getYIntercept() - l.getYIntercept()) < epsilon)
				return true;
		return false;
	}
}
public class C10_3 {
	//If the two lines are the same, we think they are to intersect.
}
