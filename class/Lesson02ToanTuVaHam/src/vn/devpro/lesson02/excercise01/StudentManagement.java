package vn.devpro.lesson02.excercise01;

import java.util.Date;
import java.util.Scanner;

public class StudentManagement {
//	Ham nhap va tra ve thong tin cua mot hoc sinh
//	+Dau vao: khong co (do bo nho trong doc du lieu tu bo nho ngoai nhung bo nho ngoai chua co gi
//	+Dau ra: thong tin 1 hoc sinh
//	
	public static Student input() {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
//		this. thi la cua phuong thuc
//		Ham thi truy xuat vao student
		student.code = "st" + new Date().getTime(); // Tu sinh ra 1 ma hoc sinh bat ky
		System.out.print("\tHo dem: ");
		student.firstName = sc.nextLine();
		System.out.print("\tTen: ");
		student.lastName = sc.nextLine();
		System.out.print("\tNgay sinh (dd/MM/yyyy): ");
		student.dateOfBirth = sc.nextLine();
		System.out.print("\tGioi tinh: ");
		student.gender = sc.nextLine();
		System.out.print("\tDiem toan: ");
		student.math = Double.parseDouble(sc.nextLine()); // De do can phai sc.nextLine() o tren de xoa bo khoang trang
															// thua
		System.out.print("\tDiem van: ");
		student.literature = Double.parseDouble(sc.nextLine());
		System.out.print("\tDiem anh: ");
		student.english = Double.parseDouble(sc.nextLine());

		return student;
	}

//	Ham hien thi thong tin cua hoc sinh
//	+ Dau vao: student
//	+ Dau ra: Khong co do khong co thong tin de luu vao bo nho trong
	public static void display(Student st) {
		System.out.printf("%-12s %-15s %10s %-9s %5.1f %5.1f %5.1f %7.2f", st.code, st.firstName + " " + st.lastName,
				st.dateOfBirth, st.gender, st.math, st.literature, st.english, average(st));

	}

//	Ham tinh diem trung binh
//	+ Dau vao: student/(3 diem so 3 mon)
//	+ Dau ra: diem tring binh
	public static double average(Student st) {
		return (st.math * 2 + st.literature * 2 + st.english) / 5;
	}

	public static double average(double m, double l, double e) {
		return (m * 2 + l * 2 + e) / 5;
	}

	public static void main(String[] args) {
		System.out.println("Nhap thong tin hoc sinh: ");
		Student student = input();
		System.out.println("Thong tin hoc sinh vua nhap: ");
		display(student);
	}
}
