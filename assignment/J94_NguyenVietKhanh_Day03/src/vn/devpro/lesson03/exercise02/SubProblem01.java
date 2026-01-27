package vn.devpro.lesson03.exercise02;

import java.io.IOException;
import java.util.Scanner;

public class SubProblem01 {

	static Scanner sc = new Scanner(System.in);

	public static char input() throws IOException {
		System.out.print("Vui long nhap mot chu so: ");
		char digit = (char) System.in.read();
		sc.nextLine();
		return digit;
	}

	public static boolean isDigit(char digit) {
		return digit >= '0' && digit <= '9';
	}

	public static void display() {
		char digit;
		try {
			digit = input();
			if (isDigit(digit)) {
				System.out.print("Cach doc: ");
				int number = (int) digit;
				switch (number) {
				case '0': {
					System.out.println("Chu so 0");
					break;
				}
				case '1': {
					System.out.println("Chu so 1");
					break;
				}
				case '2': {
					System.out.println("Chu so 2");
					break;
				}
				case '3': {
					System.out.println("Chu so 3");
					break;
				}
				case '4': {
					System.out.println("Chu so 4");
					break;
				}
				case '5': {
					System.out.println("Chu so 5");
					break;
				}
				case '6': {
					System.out.println("Chu so 6");
					break;
				}
				case '7': {
					System.out.println("Chu so 7");
					break;
				}
				case '8': {
					System.out.println("Chu so 8");
					break;
				}
				case '9': {
					System.out.println("Chu so 9");
					break;
				}
				}
			} else {
				System.out.println("Chu so khong hop le");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
