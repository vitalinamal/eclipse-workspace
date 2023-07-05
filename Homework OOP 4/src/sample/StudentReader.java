package sample;

import java.util.Scanner;

public class StudentReader {

	public static Student inputStudentData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student name:");
		String name = sc.nextLine();

		System.out.println("Input student lastName:");
		String lastName = sc.nextLine();

		System.out.println("Input number to choose Student gender: 1(MALE) or 2(FEMALE)");
		String genderChoice = sc.nextLine();
		Gender gender = genderChoice.equals("1") ? Gender.MALE : Gender.FEMALE;

		System.out.println("Input student id:");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Input student groupName:");
		String groupName = sc.nextLine();
		sc.close();
		return new Student(name, lastName, gender, id, groupName);

	}

}