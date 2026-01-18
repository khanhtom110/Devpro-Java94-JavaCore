package vn.devpro.lesson01.excercise08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int day;
	private int month;
	private int year;
	private double totalMark;
	private List<Subject> subjects = new ArrayList<>();
	private int n = 3;

	public void addSubject(Subject s) {
		this.subjects.add(s);
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so bao danh: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap ho dem: ");
		this.firstName = sc.nextLine();
		System.out.print("Nhap ten: ");
		this.lastName = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		this.day = sc.nextInt();
		System.out.print("Nhap thang sinh: ");
		this.month = sc.nextInt();
		System.out.print("Nhap nam sinh: ");
		this.year = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Subject subject = new Subject();
			System.out.println("Nhap thong tin mon hoc " + i + ":");
			subject.input();
			addSubject(subject);
		}
	}

	public void caculation() {
		for (Subject subject : this.subjects) {
			this.totalMark += subject.getMark() * subject.getCoefficient();
		}
	}

	public void display() {
		System.out.printf(" %-15s %02d/%02d/%4d %.2f%n", this.firstName + " " + this.lastName, this.day, this.month,
				this.year, this.totalMark);
	}
}
