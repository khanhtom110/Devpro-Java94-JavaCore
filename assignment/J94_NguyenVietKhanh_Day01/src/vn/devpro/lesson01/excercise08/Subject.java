package vn.devpro.lesson01.excercise08;

import java.util.Scanner;

public class Subject {
	private int id;
	private String name;
	private double coefficient;
	private double mark;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma mon thi: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap ten mon thi: ");
		this.name = sc.nextLine();
		System.out.print("Nhap he so mon thi: ");
		this.coefficient = sc.nextDouble();
		System.out.print("Nhap diem mon thi: ");
		this.mark = sc.nextDouble();
	}

	public double getCoefficient() {
		return coefficient;
	}

	public double getMark() {
		return mark;
	}

}
