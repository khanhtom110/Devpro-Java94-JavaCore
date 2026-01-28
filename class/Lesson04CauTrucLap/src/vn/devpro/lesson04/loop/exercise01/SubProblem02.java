package vn.devpro.lesson04.loop.exercise01;

import java.util.Scanner;

public class SubProblem02 {
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

	public static int reverse(int n) {
		int res = 0;
		int m = n;
		while (m > 0) {
			res = res * 10 + (m % 10);
			m /= 10;
		}
		return res;
	}

	public static void display() {
		int n = input();
		System.out.println("So dao nguoc cua " + n + " la: " + reverse(n));
	}
}
