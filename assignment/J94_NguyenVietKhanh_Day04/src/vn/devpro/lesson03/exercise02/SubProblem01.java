package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem01 {

	static Scanner sc = new Scanner(System.in);

	public static int input(String var) {
		int n = 0;
		do {
			try {
				System.out.print("Nhap " + var + ": ");
				n = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Yeu cau nhap so nguyen duong");
			}
		} while (n <= 0);
		return n;
	}

	public static boolean isPrime(int n) {
		if (n <= 1 || n % 2 == 0) {
			return false;
		}

		int m = (int) Math.sqrt(n);
		for (int i = 2; i <= m; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void display() {
		int n = input("n");
		if (isPrime(n)) {
			System.out.println(n + " la so nguyen to");
		} else {
			System.out.println(n + " khong la so nguyen to");
		}

	}
}
