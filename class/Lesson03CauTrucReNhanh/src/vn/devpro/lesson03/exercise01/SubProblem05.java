package vn.devpro.lesson03.exercise01;

import java.time.LocalDate;
import java.util.Scanner;

public class SubProblem05 {
	static Scanner sc = new Scanner(System.in);

	public static int input() {
		System.out.print("Nhap thang: ");
		return Integer.parseInt(sc.nextLine());
	}

	public static int dayOfMonth(int month) {
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			int year = LocalDate.now().getYear();
			if (year % 4 == 0) {
				day = 29;
			} else {
				day = 28;
			}
		}
		return day;
	}

	public static void display() {
		int month = input();
		int day = dayOfMonth(month);
		if (day == 0) {
			System.out.println("Thang khong hop le");
		} else {
			System.out.printf("Thang %d co %d ngay%n", month, day);
		}

	}
}
