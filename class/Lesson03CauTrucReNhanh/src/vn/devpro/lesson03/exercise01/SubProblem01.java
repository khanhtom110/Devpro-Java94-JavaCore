package vn.devpro.lesson03.exercise01;

import java.io.IOException;
import java.util.Scanner;

public class SubProblem01 {
	static Scanner sc = new Scanner(System.in);

	public static char input() throws IOException {
		System.out.print("Xin nhap mot chu so: ");
		char digit = (char) System.in.read();
		sc.nextLine();
		return digit;
	}

	public static boolean isDigit(char digit) {
		return (digit >= '0' && digit <= '9');
	}

	public static void display() {
		char digit;
		try {
			digit = input();
			if (isDigit(digit)) {
				System.out.println(digit + " la chu so");
			} else {
				System.out.println(digit + " khong la chu so");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
