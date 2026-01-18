package vn.devpro.lesson01.excercise07;

import java.util.Scanner;

public class Staff {
	private int id;
	private String fullName;
	private int day;
	private int month;
	private int year;
	private int workingDays;
	private double otHours;
	private double salary;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma can bo: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap ho va ten: ");
		this.fullName = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		this.day = sc.nextInt();
		System.out.print("Nhap thang sinh: ");
		this.month = sc.nextInt();
		System.out.print("Nhap nam sinh: ");
		this.year = sc.nextInt();
		System.out.print("Nhap so ngay lam viec trong thang: ");
		this.workingDays = sc.nextInt();
		System.out.print("Nhap so gio lam them: ");
		this.otHours = sc.nextDouble();
		this.salary = this.workingDays * 350000 + this.otHours * 45000;
	}

	public double getSalary() {
		return this.salary;
	}

	public void display() {
//		Chua them dau tru "-"
		System.out.printf(" %-15s %02d/%02d/%4d %-10d %-12.1f %-10.2f%n", this.fullName, this.day, this.month,
				this.year, this.workingDays, this.otHours, this.salary);
	}
}
