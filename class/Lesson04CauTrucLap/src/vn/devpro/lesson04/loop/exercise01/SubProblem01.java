package vn.devpro.lesson04.loop.exercise01;

import java.util.Scanner;

public class SubProblem01 {
	static Scanner sc = new Scanner(System.in);

	public static int input() {
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

	public static long factorial(int n) {
		long g = 1;
		for (int i = 2; i <= n; i++) {
			g *= i;
		}
		return g;
	}

	public static void display() {
		int n = input();
		System.out.println(n + "! = " + factorial(n));
	}

}
