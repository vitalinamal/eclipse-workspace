package homewr;

public class GeometryOperation {
	private static double vectorCrossProduct(Vector v1, Vector v2) {
		return v1.getxComponent() * v2.getyComponent() - v2.getxComponent() * v1.getyComponent();
	}

	public static boolean hittingTheTriangle(Point point, Triangle triangle) {
		Point a = triangle.getVertex1();
		Point b = triangle.getVertex2();
		Point c = triangle.getVertex3();
		Vector vector1 = new Vector(a, point);
		Vector vector2 = new Vector(b, point);
		Vector vector3 = new Vector(c, point);

		double res1 = vectorCrossProduct(vector1, new Vector(a, b));
		double res2 = vectorCrossProduct(vector2, new Vector(b, c));
		double res3 = vectorCrossProduct(vector3, new Vector(c, a));

		return (res1 >= 0 && res2 >= 0 && res3 >= 0) || (res1 <= 0 && res2 <= 0 && res3 <= 0);
	}
}
