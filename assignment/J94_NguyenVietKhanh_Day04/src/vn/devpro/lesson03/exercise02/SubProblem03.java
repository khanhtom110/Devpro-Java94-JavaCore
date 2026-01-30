package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem03 {
	static Scanner sc = new Scanner(System.in);

	public static double input1(String var) {
		double x = 0;
		try {
			System.out.print("Nhap " + var + ": ");
			return Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Yeu cau nhap so thuc");
		}
		return x;
	}

	public static int input2(String var) {
		int n = 0;
		do {
			try {
				System.out.print("Nhap " + var + ": ");
				n = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Yeu cau nhap so nguyen khong am");
			}
		} while (n < 0);
		return n;
	}

	public static double calculation(double x, int n) {
		double sum = 1;
		double a = 0;
		for (int i = 1; i <= n; i++) {
			a += 2;
			sum += a * Math.pow(x, a);
		}
		return sum;
	}

	public static void display() {
		double x = input1("x");
		int n = input2("n");
		System.out.printf("s = %,.2f%n", calculation(x, n));
	}
}
