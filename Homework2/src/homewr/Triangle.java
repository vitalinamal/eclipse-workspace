package homewr;

public class Triangle {

	private Point vertex1;
	private Point vertex2;
	private Point vertex3;

	public Triangle(Point vertex1, Point vertex2, Point vertex3) {
		super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.vertex3 = vertex3;
	}

	public Triangle() {
		super();
	}

	public Point getVertex1() {
		return vertex1;
	}

	public void setVertex1(Point vertex1) {
		this.vertex1 = vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	public void setVertex2(Point vertex2) {
		this.vertex2 = vertex2;
	}

	public Point getVertex3() {
		return vertex3;
	}

	public void setVertex3(Point vertex3) {
		this.vertex3 = vertex3;
	}

	@Override
	public String toString() {
		return "Triangle [vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", vertex3=" + vertex3 + "]";
	}

}
