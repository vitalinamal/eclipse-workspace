package homewr;

public class Vector {

	private Point startPoint;
	private Point endPoint;
	private double xComponent;
	private double yComponent;

	public Vector(Point startPoint, Point endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		calculateComponent();
	}

	public Vector() {
		super();
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
		calculateComponent();
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
		calculateComponent();
	}

	public double getxComponent() {
		return xComponent;
	}

	public double getyComponent() {
		return yComponent;
	}

	private void calculateComponent() {
		this.xComponent = this.endPoint.getX() - this.startPoint.getX();
		this.yComponent = this.endPoint.getY() - this.startPoint.getY();
	}

	@Override
	public String toString() {
		return "Vector [startPoint=" + startPoint + ", endPoint=" + endPoint + ", xComponent=" + xComponent
				+ ", yComponent=" + yComponent + "]";
	}

}
