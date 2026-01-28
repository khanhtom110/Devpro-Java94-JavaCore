package vn.devpro.lesson04.loop;

import java.util.Scanner;

public class ForLoopDemo {
	static Scanner sc = new Scanner(System.in);

	public static void forExample() {
		int count, sum = 0;
		for (count = 1; count < 10; count += 2) {
			sum += count;
		}
		System.out.println("Tong cua 5 so le dau tien la: " + sum);
	}

	public static void forExampe2() {
		int n;
		System.out.print("n=");
		n = sc.nextInt();
		int count, sum = 0;
		for (count = 0; count < n; count++) {
			sum += count;
			System.out.print(count + " ");
		}
		System.out.println();
		System.out.println("Tong cua n so tu nhien dau tien la: " + sum);
	}

	public static void numberOfDigits(int n) {
		int count = 0, sum = 0;
		while (n > 0) {
			count++;
			sum += n % 10;
			n /= 10;
		}
		System.out.println("So chu so cua n la: " + count);
		System.out.println("Tong cac chu so cua n la: " + sum);
	}

	public static void chickenAndDog() {
		for (int x = 1; x < 36; x++) {
			for (int y = 1; y < 25; y++) {
				if (x + y == 36 && 2 * x + 4 * y == 100) {
					System.out.println("So ga la " + x + " va so cho la " + y);
				}
			}
		}
	}

	public static void main(String[] args) {
		// forExampe1();
		// forExampe2();
		// numberOfDigits(15);
		chickenAndDog();
	}
}
