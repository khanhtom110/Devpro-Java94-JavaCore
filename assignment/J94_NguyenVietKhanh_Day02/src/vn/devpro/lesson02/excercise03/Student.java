package vn.devpro.lesson02.excercise03;

import java.util.Date;
import java.util.Scanner;

public class Student {
	String code;
	String firstName;
	String lastName;
	String dateOfBirth;

	Subject s1 = new Subject();
	Subject s2 = new Subject();
	Subject s3 = new Subject();
	Subject s4 = new Subject();
	Subject s5 = new Subject();

	public static Student input() {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		student.code = "ST" + new Date().getTime();
		System.out.print("Ho dem: ");
		student.firstName = sc.nextLine();
		System.out.print("Ten: ");
		student.lastName = sc.nextLine();
		System.out.print("Ngay sinh: ");
		student.dateOfBirth = sc.nextLine();
		System.out.println("Nhap thong tin mon thu 1:");
		student.s1 = Subject.input();
		System.out.println("Nhap thong tin mon thu 2:");
		student.s2 = Subject.input();
		System.out.println("Nhap thong tin mon thu 3:");
		student.s3 = Subject.input();
		System.out.println("Nhap thong tin mon thu 4:");
		student.s4 = Subject.input();
		System.out.println("Nhap thong tin mon thu 5:");
		student.s5 = Subject.input();
		return student;
	}

	public static double average(Student student) {
		return (student.s1.mark * student.s1.credit + student.s2.mark * student.s2.credit
				+ student.s3.mark * student.s3.credit + student.s4.mark * student.s4.credit
				+ student.s5.mark * student.s5.credit)
				/ (student.s1.credit + student.s2.credit + student.s3.credit + student.s4.credit + student.s5.credit);
	}

	public static void display(Student student) {
//		BANG DIEM CA NHAN
//		Ma sinh vien: xxxxxx
//		Ho va ten: Nguyen Van A
//		Ngay sinh: xx/xx/xxxx
//		Danh sach diem cac mon hoc:
//		Ma mon  Ten mon    So tin chi  Diem
//		...
//		Diem tong ket: x.xx
		System.out.println("BANG DIEM CA NHAN");
		System.out.println("Ma sinh vien: " + student.code);
		System.out.println("Ho va ten: " + student.firstName + " " + student.lastName);
		System.out.println("Ngay sinh: " + student.dateOfBirth);
		System.out.println("Danh sach diem cac mon hoc:");
		System.out.printf("%-15s %-25s %-12s %-5s%n", "Ma mon", "Ten mon", "So tin chi", "Diem");
		Subject.display(student.s1);
		Subject.display(student.s2);
		Subject.display(student.s3);
		Subject.display(student.s4);
		Subject.display(student.s5);
		System.out.printf("Diem tong ket: %.2f", average(student));
	}
}
