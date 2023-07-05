package sample;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student("Igor", "Kos", Gender.MALE, 1, "prva");
		Student student2 = new Student("Igor", "Kop", Gender.MALE, 2, "prva");
		Student student3 = new Student("Igor", "Kor", Gender.MALE, 3, "prva");
		Student student4 = new Student("Igor", "Kot", Gender.MALE, 4, "prva");
		Student student5 = new Student("Igor", "Koz", Gender.MALE, 5, "prva");
		Student student6 = new Student("Igor", "Koa", Gender.MALE, 6, "prva");
		Student student7 = new Student("Igor", "Kod", Gender.MALE, 7, "prva");
		Student student8 = new Student("Igor", "Kof", Gender.MALE, 8, "prva");
		Student student9 = new Student("Igor", "Kog", Gender.MALE, 9, "prva");
		Student student10 = new Student("Igor", "Kol", Gender.MALE, 10, "prva");

		Group group1 = new Group();
		group1.setGroupName("prva");
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);

//			System.out.println(group1);
//			
			System.out.println(group1.searchStudentByLastName("Kos"));
			System.out.println(group1.removeStudentByID(1));
			group1.addStudent(student1);

//			System.out.println(group1);
			group1.sortStudentsByLastName();
			List<Student> listOfStudents = Arrays.asList(group1.getStudents());
			listOfStudents.forEach(System.out::println);
			Student studentFromInput = StudentReader.inputStudentData();
			System.out.println(studentFromInput);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
