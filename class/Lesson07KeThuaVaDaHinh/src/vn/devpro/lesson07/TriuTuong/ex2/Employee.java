package vn.devpro.lesson07.TriuTuong.ex2;

import java.util.Calendar;
import java.util.Scanner;

public abstract class Employee {
	// Lop Nhan Vien la triu tuong do co nhieu loai nhan vien -> chua the tinh luong
	// duoc ngay
	protected String code;
	protected String name;
	protected int year;

	public Employee() {
		super();
	}

	public Employee(String code, String name, int year) {
		super();
		this.code = code;
		this.name = name;
		this.year = year;
	}

	public abstract double salary();

	public double bonus() {
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		return 200000 + (currentYear - this.year) * 75000;
	}

	Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("\tNhap ma nhan vien: ");
		this.code = sc.nextLine();
		System.out.print("\tNhap ho va ten: ");
		this.name = sc.nextLine();
		System.out.print("\tNhap nam vao lam: ");
		this.year = Integer.parseInt(sc.nextLine());
	}

	public void display() {
		System.out.printf("%10s %-25s %6d ", this.code, this.name, this.year);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
