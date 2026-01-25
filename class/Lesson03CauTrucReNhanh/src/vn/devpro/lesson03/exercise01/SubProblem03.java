package vn.devpro.lesson03.exercise01;

import java.util.Scanner;

public class SubProblem03 {
	static Scanner sc = new Scanner(System.in);

	public static double input() {
		System.out.print("Nhap diem tong ket: ");
		return Double.parseDouble(sc.nextLine());
	}

	public static String rank(double mark) {
		String str;
		if (mark < 0 || mark > 10) {
			str = "Diem khong hop le";
		} else {
			if (mark >= 8.0) {
				str = "Gioi";
			} else if (mark >= 6.5) {
				str = "Kha";
			} else if (mark >= 5.0) {
				str = "Trung binh";
			} else if (mark >= 3.0) {
				str = "Yeu";
			} else {
				str = "Kem";
			}
		}
		return str;
	}

	public static void display() {
		double mark = input();
		System.err.println(rank(mark));
	}
}
