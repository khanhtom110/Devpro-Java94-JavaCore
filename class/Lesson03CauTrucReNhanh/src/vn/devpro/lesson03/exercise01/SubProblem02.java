package vn.devpro.lesson03.exercise01;

import java.util.Scanner;

public class SubProblem02 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String var) {
		System.out.print("Nhap he so " + var + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static void solve(double a, double b, double c) {
		if (a == 0) {
			System.out.println("Phuong trinh khong ton tai");
		} else {
			double delta = b * b - 4 * a * c;
			if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem");
			} else if (delta == 0) {
				double x = -b / (2 * a);
				System.out.printf("Phuong trinh co nghiem kep x1 = x2 = %.3f%n", x);
			} else {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Phuong trinh co 2 nghiem phan biet");
				System.out.printf("x1 = %.3f%n", x1);
				System.out.printf("x2 = %.3f%n", x2);
			}
		}
	}

	public static void display() {
		double a = input("a");
		double b = input("b");
		double c = input("c");
		solve(a, b, c);
	}
}
