package vn.devpro.lesson05.exercise01;

import java.util.Scanner;

public class StudentManagement {
	public static Scanner sc = new Scanner(System.in);

	public static int input(String var) {
		int n = 0;
		do {
			try {
				System.out.print("Nhap " + var + ": ");
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Yeu cau nhap so nguyen duong");
			}
		} while (n <= 0);
		return n;
	}

	public static void init(Student students[]) {
		try {
			for (int i = 0; i < students.length; i++) {
				students[i] = new Student();
				System.out.println("\tNHAP THONG TIN CUA THI SINH THU " + (i + 1));
				System.out.print("\t\tHo va ten: ");
				students[i].fullName = sc.nextLine();
				System.out.print("\t\tDiem toan: ");
				students[i].math = Double.parseDouble(sc.nextLine());
				System.out.print("\t\tDiem van: ");
				students[i].literature = Double.parseDouble(sc.nextLine());
				System.out.print("\t\tDiem tieng anh: ");
				students[i].english = Double.parseDouble(sc.nextLine());
			}
		} catch (NumberFormatException e) {
			System.out.println("Yeu cau nhap so diem hop le");
		}
	}

	public static void mark(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			students[i].totalMark = students[i].english * 2 + students[i].math + students[i].literature;
		}
	}

	public static void swap(Student[] students, int i, int j) {
		Student tmp = students[i];
		students[i] = students[j];
		students[j] = tmp;
	}

	public static void sort(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = students.length - 1; j > i; j--) {
				if (students[j].totalMark < students[j - 1].totalMark) {
					swap(students, j, j - 1);
				}
			}
		}
	}

	public static void display(Student[] students) {
		System.out.printf("%5s %-20s %9s %9s %15s %15s%n", "STT", "Ho va ten", "Toan", "Van", "Tieng anh", "Tong diem");
		for (int i = 0; i < students.length; i++) {
			System.out.printf("%5d %-20s %9.2f %9.2f %15.2f %15.2f%n", i + 1, students[i].fullName, students[i].math,
					students[i].literature, students[i].english, students[i].totalMark);
		}
	}

	public static void display5Max(Student[] students) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t\t5 THI SINH CO TONG DIEM CAO NHAT");
		System.out.printf("%5s %-20s %9s %9s %15s %15s%n", "STT", "Ho va ten", "Toan", "Van", "Tieng anh", "Tong diem");
		for (int i = students.length - 1, count = 0; i >= 0 && count < 5; i--, count++) {
			System.out.printf("%5d %-20s %9.2f %9.2f %15.2f %15.2f%n", count + 1, students[i].fullName,
					students[i].math, students[i].literature, students[i].english, students[i].totalMark);
		}
	}

	public static void main(String[] args) {
		int n = input("n");
		Student[] students = new Student[n];
		init(students);
		mark(students);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t\tTONG DIEM CUA CAC THI SINH");
		display(students);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t\tDANH SACH TONG DIEM THEO CHIEU TANG DAN");
		Student[] newStudents = students.clone();
		sort(newStudents);
		display(newStudents);

		display5Max(newStudents);
	}
}
