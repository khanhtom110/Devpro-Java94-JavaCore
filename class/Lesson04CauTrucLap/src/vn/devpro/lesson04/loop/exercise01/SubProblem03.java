package vn.devpro.lesson04.loop.exercise01;

import java.util.Scanner;

public class SubProblem03 {
	static Scanner sc = new Scanner(System.in);

	public static int input1() {
		int n = 0;
		do {
			System.out.print("Nhap so nguyen duong n: ");
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ban can nhap so nguyen duong");
			}

		} while (n <= 0);
		return n;
	}

	public static double input2() {
		System.out.print("Nhap so thuc x: ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double value(int n, double x) {
		double sum = 1, a = 1;
		int sign = -1;
		for (int i = 1; i <= n; i++) {
			a = a * x;
			sum += sign * a / (i + 1);
			sign = -sign;
		}
		return sum;
	}

	public static void display() {
		int n = input1();
		double x = input2();
		System.out.println("S = " + value(n, x));
	}
}
