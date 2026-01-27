package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem04 {
	static Scanner sc = new Scanner(System.in);

	public static double input(String s) {
		System.out.print("Nhap " + s + ": ");
		return Double.parseDouble(sc.nextLine());
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	public static double perimeter(double a, double b, double c) {
		return a + b + c;
	}

	public static double area(double a, double b, double c) {
		double p = perimeter(a, b, c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static void display() {
		double x1 = input("x1");
		double y1 = input("y1");
		double x2 = input("x2");
		double y2 = input("y2");
		double x3 = input("x3");
		double y3 = input("y3");
		if ((x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)) {
			System.out.println("3 diem nay thang hang");
		} else {
			double a = distance(x1, y1, x2, y2);
			double b = distance(x2, y2, x3, y3);
			double c = distance(x3, y3, x1, y1);
			System.out.printf("Do dai 3 canh nhu sau: %.2f - %.2f - %.2f%n", a, b, c);
			System.out.printf("Chu vi tam giac: %.2f%n", perimeter(a, b, c));
			System.out.printf("Dien tich tam giac: %.2f%n", area(a, b, c));
		}
	}
}
