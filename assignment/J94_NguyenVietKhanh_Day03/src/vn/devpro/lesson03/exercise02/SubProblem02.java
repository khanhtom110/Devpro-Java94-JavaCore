package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem02 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String s) {
		System.out.print("Nhap " + s + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double calculation(double x) {
		if (x > 2 && x < 3) {
			return 5 * Math.cos((3 * x) + 2) - Math.log(x * x + 2);
		} else if (x >= 3) {
			return Math.pow((x + 3), 3);
		} else {
			return 1;
		}
	}

	public static void display() {
		double x = input("x");
		System.out.printf("Gia tri cua bieu thuc y la: %.2f%n", calculation(x));
	}
}
