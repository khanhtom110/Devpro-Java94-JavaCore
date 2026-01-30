package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem04 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String s) {
		double x = 0;
		try {
			System.out.print("Nhap " + s + ": ");
			x = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Yeu cau nhap so thuc");
		}
		return x;
	}

	public static double calculation(double x, double eps) {
		double sum = x;
		double op = x;
		int i = 3;
		while (Math.abs(op) >= eps) {
			op = op * (-(x * x) / (i * (i - 1)));
			sum += op;
			i += 2;
		}
		return sum;
	}

	public static void display() {
		double x = input("x");
		double eps = input("epsilon");
		System.out.printf("sinx = %.3f%n", calculation(x, eps));
	}
}
