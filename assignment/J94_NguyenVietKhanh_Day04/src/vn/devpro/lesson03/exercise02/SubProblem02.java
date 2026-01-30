package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem02 {
	static Scanner sc = new Scanner(System.in);

	public static int input(String var) {
		int n = 0;
		do {
			try {
				System.out.print("Nhap " + var + ": ");
				n = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Yeu cau nhap n nguyen duong");
			}
		} while (n <= 0);
		return n;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void solve(int n) {
		int sum = 0;
		int count = 0;
		int i = 2;
		while (count < n) {
			if (isPrime(i)) {
				count++;
				sum += i;
				System.out.print(i + " ");
			}
			i++;
		}
		System.out.println();
		System.out.println("Tong la: " + sum);
	}

	public static void display() {
		int n = input("n");
		solve(n);
	}
}
