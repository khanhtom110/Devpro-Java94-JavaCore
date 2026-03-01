package vn.devpro.lesson07;

import java.util.Scanner;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {
		super();
	}

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	static Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("\tNhap ngay sinh: ");
		this.day = Integer.parseInt(sc.nextLine());
		System.out.print("\tNhap thang sinh: ");
		this.month = Integer.parseInt(sc.nextLine());
		System.out.print("\tNhap nam sinh: ");
		this.year = Integer.parseInt(sc.nextLine());
	}

	public void display() {
		System.out.printf("%02d-%02d-%4d", this.day, this.month, this.year);
	}
}
