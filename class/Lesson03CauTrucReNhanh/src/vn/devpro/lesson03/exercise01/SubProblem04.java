package vn.devpro.lesson03.exercise01;

import java.util.Scanner;

public class SubProblem04 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String var) {
		System.out.print("Nhap " + var + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double income(double salary, double sales) {
		if (sales <= 3000) {
			return salary * 0.95;
		} else if (sales <= 10000) {
			return salary;
		} else if (sales <= 30000) {
			return salary + salary * 0.05;
		} else {
			return salary + salary * 0.1;
		}
	}

	public static void display() {
		double salary = input("luong cung");
		double sales = input("doanh so");
		System.out.printf("Thu nhap cua nhan vien la: %.2f (USD)%n", income(salary, sales));
	}
}
