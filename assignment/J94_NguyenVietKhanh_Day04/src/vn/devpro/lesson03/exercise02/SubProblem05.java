package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem05 {
	static Scanner sc = new Scanner(System.in);

	public static int input(String s) {
		int n = 0;
		try {
			do {
				System.out.print("Nhap " + s + ": ");
				n = Integer.parseInt(sc.nextLine());
			} while (n <= 0);
		} catch (NumberFormatException e) {
			System.out.println("Yeu cau nhap so nguyen duong");
		}
		return n;
	}

	public static void fibonaci(int n) {
		int number1 = 1;
		int number2 = 1;
		int number3;
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == 2) {
				System.out.print("1 ");
			} else {
				number3 = number1 + number2;
				System.out.print(number3 + " ");
				number1 = number2;
				number2 = number3;
			}
		}
		System.out.println();
	}

	public static void display() {
		int n = input("n");
		fibonaci(n);
	}
}
