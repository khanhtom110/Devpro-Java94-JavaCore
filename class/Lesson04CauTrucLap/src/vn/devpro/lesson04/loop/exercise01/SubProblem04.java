package vn.devpro.lesson04.loop.exercise01;

import java.util.Scanner;

public class SubProblem04 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String var) {
		System.out.print("Nhap " + var + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double exp(double x, double eps) {
		double s = 1, op = 1;
		int i = 1;
		while (Math.abs(op) >= eps) {
			op = op * x / i;
			s = s + op;
			i++;
		}
		return s;
	}

	public static void display() {
		double x = input("so thuc x");
		double eps = input("sai so epsilon");
		double s = exp(x, eps);
		System.out.printf("e mu %.3f la: %.9f%n", x, s);
	}
}
