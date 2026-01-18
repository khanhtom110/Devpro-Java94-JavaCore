package vn.devpro.lesson01.excercise04;

import java.util.Scanner;

public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap do dai 3 canh:");
		System.out.print("Canh 1: ");
		this.sideA = sc.nextDouble();
		System.out.print("Canh 2: ");
		this.sideB = sc.nextDouble();
		System.out.print("Canh 3: ");
		this.sideC = sc.nextDouble();
	}

	public double perimeter() {
		return this.sideA + this.sideB + this.sideC;
	}

	public double area() {
		double semiPerimeter = perimeter() / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - this.sideA) * (semiPerimeter - this.sideB)
				* (semiPerimeter - this.sideC));
	}
}
