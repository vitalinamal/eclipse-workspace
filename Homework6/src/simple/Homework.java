package simple;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		////////////////////// task 1 //////////////////////////////////

		int numberOfArray;

		System.out.println("Input number of array:");
		numberOfArray = sc.nextInt();

		int[] array = new int[numberOfArray];

		System.out.println("Enter the elements of the array one by one: ");

		inputNumbersInArray(numberOfArray, array, sc);
		
	 

		System.out.println("The biggest number in array is " + findMax(array) + ".");
		
		System.out.println("The smallest number in array is " + findMin(array) + ".");
	   

//////////////////////task 2 //////////////////////////////////

//		int rows, columns;
//
//		System.out.print("Enter Number of Rows : ");
//		rows = sc.nextInt();
//
//		System.out.print("Enter Number of Columns : ");
//		columns = sc.nextInt();
//
//		drawRectangle(rows, columns);

//////////////////////task 3 //////////////////////////////////

//		int numberOfArr;
//		System.out.println("Input number of array:");
//		numberOfArr = sc.nextInt();
//
//		int[] array = new int[numberOfArr];
//
//		System.out.println("Enter the elements of the array one by one: ");
//		inputNumbersInArray(numberOfArr, array, sc);
//
//		System.out.println("Input number which you want to find:");
//		int numberForCheck = sc.nextInt();
//
//		System.out.println(findNumber(array, numberForCheck));
//
//	}

//////////////////////task 1 //////////////////////////////////
//
	public static int findMax(int[] array) {
		int maxNumber = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxNumber) {
				maxNumber = array[i];
			}
			
		}
		return maxNumber;
	}

	public static int findMin(int[] array) {
		int minNumber = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < minNumber) {
				minNumber = array[i];
			}
		}
		return minNumber;
	}

	////////////////////// task 2 //////////////////////////////////

//	public static void drawRectangle(int row, int col) {
//		for (int i = 1; i <= row; i++) {
//			for (int j = 1; j <= col; j++) {
//				System.out.print("* "); 
//			}
//			System.out.print("\n"); 
//		}
//	}

		
//////////////////////task 1 - 3 //////////////////////////////////
		
	public static void inputNumbersInArray(int numerOfArr, int[] arr, Scanner sc) {
		for (int i = 0; i < numerOfArr; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static int findNumber(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}

}
