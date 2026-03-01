package vn.devpro.lesson07.TriuTuong.Interface;

import java.util.Scanner;

public class Circle implements Shape, IO {
	double r;

	public double erea() {
		return pi * r * r;
	}

	public double perimeter() {
		return 2 * pi * r;
	}

	public void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap r = ");
		r = in.nextDouble();
	}

	public void output() {
		System.out.println("Hinh tron r = " + r);
		System.out.println("Chu vi = " + erea());
		System.out.println("Dien tich = " + perimeter());
	}
}
