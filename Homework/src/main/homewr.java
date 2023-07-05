package main;

import java.util.Scanner;

public class homewr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		////////////////// task 1///////////////////////////////
		String words = "";
		System.out.println("Input you string");
		words = sc.nextLine();

		String string = words.toLowerCase();
		char[] symbols = string.toCharArray();
		char b = 'b';

		int counter = 0;

		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] == b) {
				counter ++;
			}
		}
		System.out.println(counter);

		////////////////// task 2/////////////////////////////////

		String words = "";
		System.out.println("Input you words:");
		words = sc.nextLine();
		
		String[] result = words.split("[ ]");
		
		int maxLength = 0;
		String longestWord = "";
		
		for (int i = 0; i < result.length; i++) {
		    if (result[i].length() > maxLength) {
		      maxLength = result[i].length();
		      longestWord = result[i];
		    }
		  }
		System.out.println(maxLength);
		System.out.println(longestWord);

		/////////////////// task 3////////////////////////////

		String text ="";
		 int n = 10;
		 
		 for (int i =1; i<=n; i++) {
			 int c = i+1;
			 text = String.format("%." + c + "f", Math.PI);
			 System.out.println(text);
		 }

		//////////////////// task 1+////////////////////////////

		String inputNumber = sc.nextLine();

		if (inputNumber.contains(",")) {
			inputNumber = inputNumber.replace(",", ".");
		}
		double doubleValueNumber = Double.parseDouble(inputNumber);

		System.out.println(convertToWords(doubleValueNumber));

		sc.close();
		
		////////////////// task 2+ ////////////////////////////
		
		String input = sc.nextLine();
		String repeatingWord = findRepeatingWord(input);

		if (repeatingWord != null) {
			System.out.println("Repeating word: " + repeatingWord);
		} else {
			System.out.println("No repeating word found.");
		}
	}
	
	//////////////////// task 1+////////////////////////////


	private static final String[] THOUSANDS = { "", "thousand", "million", "billion" };

	private static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };
	private static final String[] UNITS = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static String convertToWords(double amount) {
		String formattedAmount = String.format("%.2f", amount);
		String[] parts = formattedAmount.split("\\.");
		String dollars = parts[0];
		String cents = parts[1];

		return convertToDollarsWords(dollars) + " dollars " + convertToCentsWords(cents) + " cents";
	}

	private static String convertToCentsWords(String cents) {
		int amount = Integer.parseInt(cents);
		return converThreeDigitNumberToWords(amount);
	}

	private static String convertToDollarsWords(String dollars) {
		int amount = Integer.parseInt(dollars);

		if (amount == 0) {
			return "zero";
		}

		StringBuilder result = new StringBuilder();
		int thousandCount = 0;

		while (amount > 0) {
			if (amount % 1000 != 0) {
				String words = converThreeDigitNumberToWords(amount % 1000);
				result.insert(0, words + " " + THOUSANDS[thousandCount] + " ");
			}
			amount /= 1000;
			thousandCount++;
		}
		return result.toString().trim();
	}

	private static String converThreeDigitNumberToWords(int number) {
		StringBuilder result = new StringBuilder();

		if (number % 100 < 20) {
			result.append(UNITS[number % 100]);
			number /= 100;
		} else {
			result.append(UNITS[number % 10]);
			number /= 10;

			result.insert(0, TENS[number % 10] + " ");
			number /= 10;
		}

		if (number != 0) {
			result.insert(0, UNITS[number] + " hunderd ");
		}
		return result.toString().trim();
	}

	////////////////// task 2+///////////////////////////////////
	
	
	public static String findRepeatingWord(String input) {
		int length = input.length();

		for (int i = 1; i <= length / 2; i++) {
			String substring = input.substring(0, i);
			int repetitions = length / i;

			StringBuilder repeatedSubstring = new StringBuilder();
			for (int j = 0; j < repetitions; j++) {
				repeatedSubstring.append(substring);
			}

			if (repeatedSubstring.toString().equals(input)) {
				return substring;
			}
		}

		return null;
	}
	
}
