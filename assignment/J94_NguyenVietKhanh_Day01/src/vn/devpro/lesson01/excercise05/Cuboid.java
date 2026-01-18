package vn.devpro.lesson01.excercise05;

import java.util.Scanner;

public class Cuboid {
	private double length;
	private double width;
	private double height;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong so cua hinh hop chu nhat:");
		System.out.print("Chieu dai: ");
		this.length = sc.nextDouble();
		System.out.print("Chieu rong: ");
		this.width = sc.nextDouble();
		System.out.print("Chieu cao: ");
		this.height = sc.nextDouble();
	}

	public double lateralSurfaceArea() {
		return 2 * (this.length + this.width) * this.height;
	}

	public double totalSurfaceArea() {
		return lateralSurfaceArea() + 2 * (this.length * this.width);
	}

	public double volume() {
		return this.length * this.width * this.height;
	}
}
