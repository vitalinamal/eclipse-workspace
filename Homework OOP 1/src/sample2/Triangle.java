package sample2;

public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public Triangle() {
		super();
	}

	public double getsideA() {
		return sideA;
	}

	public void setsideA(double sideA) {
		this.sideA = sideA;
	}

	public double getsideB() {
		return sideB;
	}

	public void setsideB(double sideB) {
		this.sideB = sideB;
	}

	public double getsideC() {
		return sideC;
	}

	public void setsideC(double sideC) {
		this.sideC = sideC;
	}

	public void areaOfTriangle() {
		double halfPerimeter = (this.sideA + this.sideB + this.sideC) / 2;

		double area = Math.sqrt(halfPerimeter * (halfPerimeter - this.sideA) * (halfPerimeter - this.sideB)
				* (halfPerimeter - this.sideC));

		System.out.println("The area of " + this.toString() + " is: " + String.format("%.2f", area));
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "]";
	}

}
