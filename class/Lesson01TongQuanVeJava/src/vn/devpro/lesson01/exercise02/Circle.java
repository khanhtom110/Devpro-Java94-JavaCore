package vn.devpro.lesson01.exercise02;

import java.util.Scanner;

public class Circle {
	// Thuoc tinh
	double radius;

	// Phuong thuc
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ban kinh:");
		this.radius = sc.nextDouble();
	}

	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}

	public double area() {
		return Math.PI * this.radius * this.radius;
	}
}
