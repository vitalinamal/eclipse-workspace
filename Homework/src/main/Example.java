package main;

import java.util.Scanner;

public class Example {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String repeatingWord = findRepeatingWord(input);

		if (repeatingWord != null) {
			System.out.println("Repeating word: " + repeatingWord);
		} else {
			System.out.println("No repeating word found.");
		}
		sc.close();
	}
}