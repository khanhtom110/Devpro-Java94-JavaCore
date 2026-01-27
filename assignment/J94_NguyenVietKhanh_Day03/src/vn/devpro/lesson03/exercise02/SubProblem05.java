package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class SubProblem05 {
	static Scanner sc = new Scanner(System.in);

	public static int input(String s) {
		System.out.print("Nhap " + s + ": ");
		return Integer.parseInt(sc.nextLine());
	}

	public static boolean check(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n / 10;
		}
		if (count <= 6) {
			return true;
		}
		return false;
	}

	public static void display() {
		int n = input("n");
		if (check(n)) {
			int sum = 0;
			int count = 0;
			while (n != 0) {
				count++;
				sum += n % 10;
				n = n / 10;
			}
			System.out.printf("n co %d chu so%n", count);
			System.out.printf("Tong cac chu so cua n la %d%n", sum);
		} else {
			System.out.println("n chi co toi da 6 chu so");
		}
	}
}
