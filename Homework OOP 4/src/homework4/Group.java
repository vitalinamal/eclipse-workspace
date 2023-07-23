package homework4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {

	private String groupName;
	private Student[] students = new Student[10];

	private static int counter = 0;

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		try {
			students[counter] = student;
			counter++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GroupOverflowException("There can be only 10 students in group!");
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		Student wantedStudent = null;
		for (int i = 0; i < students.length; i++) {
			Student currentStudent = students[i];
			if (currentStudent == null) {
				break;
			}

			if (currentStudent.getLastName().equals(lastName)) {
				wantedStudent = currentStudent;
			}
		}

		if (wantedStudent == null) {
			throw new StudentNotFoundException("There is no student with surname " + lastName);
		}

		return wantedStudent;
	}

	public boolean removeStudentByID(int id) {
		int index = 0;
		boolean studentFound = false;
		for (int i = 0; i < students.length; i++) {
			Student currentStudent = students[i];
			if (currentStudent == null) {
				break;
			}

			if (currentStudent.getId() == id) {
				index = i;
				studentFound = true;
			}
		}

		if (studentFound) {
			Student[] studentsAfterDelete = new Student[students.length];
			for (int i = 0, k = 0; i < students.length; i++) {
				if (i != index) {
					studentsAfterDelete[k] = students[i];
					k++;
				}
			}
			students = studentsAfterDelete;
			counter--;
		}

		return studentFound;
	}

	public boolean isThereDuplicateStudentsInsideGroup() {
		Set<Student> seenStudents = new HashSet<>();
		for (Student student : this.students) {
			if (seenStudents.contains(student)) {
				return true;
			}
			seenStudents.add(student);
		}
		return false;
	}

	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Group)) {
			return false;
		}
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
	}

}
