package vn.devpro.lesson08.example01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DemoArrayList {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();

		// Them du lieu
		students.add(new Student("101", "Tran Thi Ngoc", "Trinh", "Nu", LocalDate.of(1989, 1, 1), "Java Spring Boot"));
		students.add(new Student("102", "Tran Thi Bao", "Ngoc", "Nu", LocalDate.of(1987, 1, 1), "Java Spring Boot"));
		students.add(new Student("103", "Tran Thi Quynh", "Anh", "Nu", LocalDate.of(1999, 1, 1), "Java Spring Boot"));
		students.add(new Student("104", "Lam Bao", "Ngoc", "Nu", LocalDate.of(1996, 1, 1), "Java Spring Boot"));
		students.add(new Student("105", "Truong My", "Lan", "Nu", LocalDate.of(1979, 1, 1), "Java Spring Boot"));

		System.out.println("My ArrayList: ");
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).toString());
		}

		// Insert (Chen vao vi tri bat ky)
		students.add(1, new Student("106", "Tran Thi Ngoc", "Mai", "Nu", LocalDate.of(1989, 1, 1), "Java Spring Boot"));
		System.out.println("My ArrayList after insert: ");
		for (Student student : students) {
			System.out.println(student.toString());
		}

		// Set - list.set(i,obj):Thaythếphầntửtạivị tríchỉsốibằngobj.
		Student s = students.get(2);
		s.setCourseName("Dacing course");
		students.set(2, s);
		System.out.println("My ArrayList after using set: ");
		for (Student student : students) {
			System.out.println(student.toString());
		}

		// Remove
		students.remove(2);
		System.out.println("My ArrayList after removing: ");
		for (Student student : students) {
			System.out.println(student.toString());
		}

		// Sort
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		System.out.println("My ArrayList after sorting: ");
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}