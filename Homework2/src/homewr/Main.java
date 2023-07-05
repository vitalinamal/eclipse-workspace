package homewr;

import java.util.Scanner;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

//			  ////////////////////task 1 /////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);

//		int firstN;
//		int secondN;
//		int thirdN;
//		int fourthN;
//		int theBiggest;
//
//		System.out.println("Input first number:");
//		firstN = sc.nextInt();
//		System.out.println("Input second number:");
//		secondN = sc.nextInt();
//		System.out.println("Input third number:");
//		thirdN = sc.nextInt();
//		System.out.println("Input fourth number:");
//		fourthN = sc.nextInt();
//
//		theBiggest = firstN;
//		if (secondN > theBiggest) {
//			theBiggest = secondN;
//		}
//		if (thirdN > theBiggest) {
//			theBiggest = thirdN;
//		}
//		;
//		if (fourthN > theBiggest) {
//			theBiggest = fourthN;
//		}
//
//		System.out.println("The biggest number is " + theBiggest);

		//////////////////// task 2 ////////////////////

//		int apart;
//		int apartmentsPerEntrance = 9 * 4;
//		int floor;
//		int entrance;
//
//		System.out.println("Input apartment number :");
//		apart = sc.nextInt();
//
//		if (apart >= 1 && apart <= 180) {
//			entrance = (int) Math.ceil((double) apart / apartmentsPerEntrance);
//			floor = (int) Math.ceil(Math.abs((entrance - 1) * apartmentsPerEntrance - apart) / 4.0);
//
//			System.out.println("You are on the " + floor + ". floor of the " + entrance + ". entrance");
//		} else {
//			System.out.println("There is no apartment of this number");
//		}

		//////////////////// task 3 ////////////////////

//		int sideA;
//		int sideB;
//		int sideC;
//		System.out.println("Input the size of side A");
//		sideA = sc.nextInt();
//		System.out.println("Input the size of side B");
//		sideB = sc.nextInt();
//		System.out.println("Input the size of side C");
//		sideC = sc.nextInt();
//
//		if ((sideA + sideB) > sideC && (sideC + sideB) > sideA && (sideA + sideC) > sideB) {
//			System.out.println("A triangle exists");
//		} else {
//			System.out.println("A triangle doesn`t exists");
//		}

		//////////////////// task 1+ ////////////////////

//		int number;
//		int n1;
//		int n2;
//		int n3;
//		int n4;
//
//		System.out.println("Input a four-digit number");
//		number = sc.nextInt();
//
//		n1 = number / 1000;
//		n2 = number % 1000 / 100;
//		n3 = number % 100 / 10;
//		n4 = number % 10;
//
//		if ((n1 + n2) == (n3 + n4)) {
//			System.out.println("You have a lucky ticket!");
//		} else {
//			System.out.println("Better luck next time");
//
//		}

		//////////////////// task 2+ ////////////////////

//		int num;
//		int reversedNum = 0;
//		int remainder;
//		int originalNum;

//		System.out.println("Enter a six-digit number");
//		num = sc.nextInt();
//
//		originalNum = num;
//
//		while (num != 0) {
//			remainder = num % 10;
//			reversedNum = reversedNum * 10 + remainder;
//			num /= 10;
//		}
//
//		if (originalNum == reversedNum) {
//			System.out.println(originalNum + " is Palindrome.");
//		} else {
//			System.out.println(originalNum + " is not Palindrome.");
//		}

		//////////////////// task 3+ ////////////////////

//		int radius = 4;
//		int x;
//		int y;
//
//		System.out.println("Input the coordinates x");
//		x = sc.nextInt();
//		System.out.println("Input the coordinates y");
//		y = sc.nextInt();
//
//		if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2)) {
//			System.out.println("The point with coordinates " + x + ";" + y + " is in the circle!");
//		} else {
//			System.out.println("The point with coordinates " + x + ";" + y + " is not in the circle!");
//		}

		//////////////////// task 4+ ////////////////////

//		int xA = 0; // x1
//		int yA = 0; // y1
//		int xB = 4; // x2
//		int yB = 4; // y2
//		int xC = 6; // x3
//		int yC = 1; // y3
//
//		int xP;
//		int yP;
//
//		System.out.println("Input the coordinates x");
//		xP = sc.nextInt();
//		System.out.println("Input the coordinates y");
//		yP = sc.nextInt();
//
//		double areaABC = Math.abs((xA * (yB - yC) + xB * (yC - yA) + xC * (yA - yB)) / 2.0);
//		double areaABP = Math.abs((xA * (yB - yP) + xB * (yP - yA) + xP * (yA - yB)) / 2.0);
//		double areaACP = Math.abs((xA * (yP - yC) + xP * (yC - yA) + xC * (yA - yP)) / 2.0);
//		double areaBCP = Math.abs((xP * (yB - yC) + xB * (yC - yP) + xC * (yP - yB)) / 2.0);
//
//		if (areaABC == (areaABP + areaACP + areaBCP)) {
//			System.out.println(
//					"Coordinates of (xP,yP)=(" + xP + "," + yP + ") are inside triangle defiend by A,B,C coordinates");
//		} else {
//			System.out.println("Coordinates of (xP,yP)=(" + xP + "," + yP
//					+ ") are NOT inside triangle defiend by A,B,C coordinates");
//		}

		/// task 3 teacher way
//		Point a = new Point(0, 0);
//		Point b = new Point(4, 4);
//		Point c = new Point(6, 1);
//		Triangle triangle = new Triangle(a, b, c);
//
//		double xP;
//		double yP;
//
//		System.out.println("Input the coordinates x");
//		xP = sc.nextInt();
//		System.out.println("Input the coordinates y");
//		yP = sc.nextInt();
//
//		Point o = new Point(xP, yP);
//		System.out.println(GeometryOperation.hittingTheTriangle(o, triangle));

//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//////////////////// task 1 ////////////////////

//		int n;
//		int factorial = 1;
//
//		System.out.println("Input a number n:");
//		n = sc.nextInt();
//
//		if (n > 4 && n < 16) {
//			for (int i = 1; i <= n; i++) {
//				factorial = factorial * i;
//			}
//		} else {
//			System.out.println("Wrong input");
//		}
//
//		System.out.println(factorial);

		//////////////////// task 2 ////////////////////
//		int multiplication;
//
//		for (int i = 1; i <= 10; i++) {
//			multiplication = i * 5;
//			System.out.println(i + " x 5 = " + multiplication + ";");
//		}

////////////////////task 3 ////////////////////

//		int w;
//		int h;
//
//		System.out.println("Input width:");
//		w = sc.nextInt();
//		System.out.println("Input height:");
//		h = sc.nextInt();
//
//		for (int i = 1; i <= h; i++) {
//			for (int j = 1; j <= w; j++) {
//				if (i == 1 || i == h || j == 1 || j == w) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//
//			}
//			System.out.println();
//		}

////////////////////task 1+ ////////////////////

//		int h;
//		System.out.println("Input h:");
//		h = sc.nextInt();

//		boolean changeDirection = false;

//		for(int i = 1; i > 0 && i <= h;) {
//			System.out.print("*".repeat(i));
//			System.out.println();
//			if(i == h) {
//				changeDirection = true;
//			}
//			if(!changeDirection) {
//				i++;
//			} else {
//				i--;
//			}
//		}

//		for (int i = 1; (i > 0 && i <= h) || i < 0; i++) {
//			if (i > 0) {
//				System.out.print("*".repeat(i));
//			} else {
//				int multiplier = Math.abs(i);
//				System.out.print("*".repeat(multiplier));
//			}
//			if (i == h) {
//				i = h * (-1);
//			}
//			System.out.println();
//		}

////////////////////task 2+ ////////////////////

//		int w;
//
//		System.out.println("Input w:");
//		w = sc.nextInt();
//
//
//		for (int i = 1; i <= w; i++) {
//			for (int k = 1; k < i; k++) {
//				System.out.print(" ");
//			}
//			for (int j = i; j <= w; j++) {
//				System.out.print("*" + " ");
//			}
//			System.out.println();
//		}
//
//		for (int i = w - 1; i >= 1; i--) {
//			for (int k = 1; k <= i - 1; k++) {
//				System.out.print(" ");
//			}
//			for (int j = i; j <= w; j++) {
//				System.out.print("*" + " ");
//			}
//			System.out.println();
//		}

		//////////////////// task 1 ////////////////////

//		int[] array = new int[] { 0, 5, 2, 4, 7, 1, 3, 19 };
//
//		int numberOfEven = 0;
//		int numberOfOdd = 0;
//
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] % 2 != 0) {
//				numberOfOdd++;
//			} else {
//				numberOfEven++;
//			}
//		}

//		System.out.println("The number of odd numbers in the array:" + numberOfOdd);
//
//		System.out.println("The number of even numbers in the array:" + numberOfEven);

		//////////////////// task 2 ////////////////////
//
//		int numberOfArray;
//
//		System.out.println("Input number of array:");
//		numberOfArray = sc.nextInt();
//
//		int[] array = new int[numberOfArray];
//
//		System.out.println("Enter the elements of the array one by one: ");
//
//		for (int i = 0; i < numberOfArray; i++) {
//			array[i] = sc.nextInt();
//		}
//		System.out.println("Contents of the array are: " + Arrays.toString(array));

		//////////////////// task 3 ////////////////////

//		int[] array1 = new int[15];
//
//		for (int i = 0; i < array1.length; i++) {
//			array1[i] = i + 1;
//		}
//		System.out.println(Arrays.toString(array1));
//
//		int[] array2 = new int[30];
//
//		for (int i = 0; i < array2.length; i++) {
//			if (i > 14) {
//				array2[i] = array1[i % 15] * 2;
//			} else {
//				array2[i] = array1[i];
//
//			}
//		}
//
//		System.out.println(Arrays.toString(array2));

		//////////////////// task 1+ ////////////////////

//		sc.close();
//		
//		int[] array = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println(Arrays.toString(array));
//
//		reverseArray(array);
//		System.out.println(Arrays.toString(array));
	}

//	public static void reverseArray(int[] array) {
//		int startIndex = 0;
//		int endIndex = array.length - 1;
//		int middleIndex = (startIndex + endIndex) / 2;
//		for (int i = startIndex; i <= middleIndex; i++) {
//			int temp = array[i];
//			array[i] = array[endIndex + startIndex - i];
//			array[endIndex + startIndex - i] = temp;
//		}

//	}

}
