package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Homewr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		////////////////// task 1 ////////////////////////////

//		String words = "";
//		System.out.println("Type text:");
//		words = sc.nextLine();
//		
//		    File file = new File("text.txt");
//
//		    try (PrintWriter pw = new PrintWriter(file)) {
//
//		      pw.println(words);
//		      
//		    } catch (IOException e) {
//		      // TODO: handle exception
//		    }

		//////////////////// task 2 /////////////////////////////////

//		int arrOne;
//		int arrTwo;
//
//		System.out.println("Type how many numbers in first array:");
//		arrOne = sc.nextInt();
//		System.out.println("Type how many numbers in second array:");
//		arrTwo = sc.nextInt();
//
//		int[][] myArray = new int[arrOne][arrTwo];
//
//		inputNumbersInArray(myArray, arrOne, arrTwo, sc);
//
//		File file = new File("text.txt");
//
//		try (PrintWriter pw = new PrintWriter(file)) {
//			printArrayInFile(myArray, arrOne, pw);
//
//		} catch (IOException e) {
//			// TODO: handle exception
//		}

////////////////////task 3 /////////////////////////////

//		File workFolder = new File(".");
//
//		File[] files = workFolder.listFiles();
//		System.out.println("List of all directories:");
//
//		for (int i = 0; i < files.length; i++) {
//			if (files[i].isDirectory()) {
//				System.out.println(files[i]);
//			}
//		}
//
//	}

////////////////////task 2 /////////////////////////////
//
//	public static void inputNumbersInArray(int[][] arr, int rowNumber, int columnNumber, Scanner sc) {
//		for (int i = 0; i < rowNumber; i++) {
//			for (int j = 0; j < columnNumber; j++) {
//				System.out.println("Input value of array for element arr[" + i + "][" + j + "]:");
//				arr[i][j] = sc.nextInt();
//			}
//		}
//	}
//
//	public static void printArrayInFile(int[][] arr, int rowNumber, PrintWriter pw) {
//		for (int i = 0; i < rowNumber; i++) {
//			pw.println(Arrays.toString(arr[i]));
//		}
//		System.out.println("Array written to file!");
//	}

}
