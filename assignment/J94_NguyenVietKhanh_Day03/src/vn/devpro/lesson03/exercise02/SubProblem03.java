package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem03 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String s) {
		System.out.print("Nhap " + s + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double calculation(double weight) {
		if (weight <= 50) {
			return weight * 18000;
		} else {
			double extraWeight = weight - 50;
			if (extraWeight <= 25) {
				return 50 * 18000 + extraWeight * (18000 - 1000);
			} else if (extraWeight <= 40) {
				return 50 * 18000 + extraWeight * (18000 - 2500);
			} else if (extraWeight <= 70) {
				return 50 * 18000 + extraWeight * (18000 - 3400);
			} else {
				return 50 * 18000 + extraWeight * (18000 - 3900);
			}
		}
	}

	public static void display() {
		double weight = input("so kg gao");
		System.out.printf("So tien phai tra la: %,.2f%n", calculation(weight));
	}
}
