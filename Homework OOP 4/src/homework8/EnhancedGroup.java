package homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import homework4.GroupOverflowException;
import homework4.Student;
import homework4.StudentLastNameComparator;
import homework4.StudentNotFoundException;

public class EnhancedGroup {

	private String groupName;
	private List<Student> students;

	public EnhancedGroup(String groupName, List<Student> students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public EnhancedGroup() {
		super();
		this.students = new ArrayList<>();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (students.size() > 9) {
			throw new GroupOverflowException("There can be only 10 students in group!");
		}
		students.add(student);
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		Student wantedStudent = null;

		for (Student student : students) {
			if (student.getLastName().equals(lastName)) {
				wantedStudent = student;
			}
		}

		if (wantedStudent == null) {
			throw new StudentNotFoundException("There is no student with surname " + lastName);
		}

		return wantedStudent;
	}

	public boolean removeStudentByID(int id) {
		Student studentToDelete = null;

		for (Student student : students) {
			if (student.getId() == id) {
				studentToDelete = student;
			}
		}

		return students.remove(studentToDelete);
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
		students.sort(Comparator.nullsLast(new StudentLastNameComparator()));
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + students.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EnhancedGroup)) {
			return false;
		}
		EnhancedGroup other = (EnhancedGroup) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

}
