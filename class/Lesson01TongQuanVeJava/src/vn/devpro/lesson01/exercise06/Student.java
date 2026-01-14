package vn.devpro.lesson01.exercise06;

import java.util.Scanner;

public class Student {
	String firstName;
	String lastName;
	int day;
	int month;
	int year;
	String gender;
	double mark;
	String morality;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\tNhap ho dem: ");
		this.firstName = sc.nextLine();
		System.out.print("\tNhap ten: ");
		this.lastName = sc.nextLine();
		System.out.print("\tNhap ngay sinh: ");
		this.day = sc.nextInt();
		System.out.print("\tNhap thang sinh: ");
		this.month = sc.nextInt();
		System.out.print("\tNhap nam sinh: ");
		this.year = sc.nextInt();
		sc.nextLine();
		System.out.print("\tNhap gioi tinh: ");
		this.gender = sc.nextLine();
		System.out.print("\tNhap diem trung binh: ");
		this.mark = sc.nextDouble();
		sc.nextLine();
		System.out.print("\tNhap xep loai dao duc: ");
		this.morality = sc.nextLine();
	}

	public void display() {
		System.out.printf("%-25s %02d-%02d-%4d %-9s %7.2f %-10s%n", this.firstName + " " + this.lastName, this.day,
				this.month, this.year, this.gender, this.mark, this.morality);
		// Dau tru la can ben trai, %s la string, %d la dinh dang so

	}
}
