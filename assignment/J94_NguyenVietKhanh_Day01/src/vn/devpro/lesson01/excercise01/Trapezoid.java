package vn.devpro.lesson01.excercise01;

import java.util.Scanner;

public class Trapezoid {
	private double topBase;
	private double bottomBase;
	private double height;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap do dai day tren: ");
		this.topBase = sc.nextDouble();
		System.out.print("Nhap do dai day duoi: ");
		this.bottomBase = sc.nextDouble();
		System.out.print("Nhap do dai chieu cao: ");
		this.height = sc.nextDouble();

	}

	public double area() {
		return ((this.topBase + this.bottomBase) * this.height) / 2;
	}
}
