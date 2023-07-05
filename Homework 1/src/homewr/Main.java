package homewr;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/////////////task 1 /////////////////////////////////////////////////////////
		double sideA = 0.3;
		double sideB = 0.4;
		double sideC = 0.5;

		double halfPerimeter = (sideA + sideB + sideC) / 2;

		double area = Math
				.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));

		System.out.println("The area " + area + " cm");

/////////////task 2 /////////////////////////////////////////////////////////

		int applePrice = 2;
		int soldOut = 6;

		int totalPrice = applePrice * soldOut;

		System.out.println("Total price: " + totalPrice + " $");

/////////////task 3 /////////////////////////////////////////////////////////

		double priceOneL = 1.2;
		double lForOneKm = (double) 8 / 100;
		double allL = lForOneKm * 120;

		double priceForAllTrip = allL * priceOneL;

		System.out.println("Gas price for 120 km: " + priceForAllTrip + " $");

	}

}
