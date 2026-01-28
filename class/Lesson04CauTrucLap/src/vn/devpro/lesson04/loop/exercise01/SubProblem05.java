package vn.devpro.lesson04.loop.exercise01;

import java.util.Scanner;

class Fraction {
	int numerator;
	int denominator;
}

public class SubProblem05 {
	static Scanner sc = new Scanner(System.in);

	public static int input(String var) {
		int n = 0;
		do {
			System.out.print("Nhap " + var + ": ");
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ban can nhap so nguyen duong");
			}

		} while (n == 0);
		return n;
	}

	public static Fraction simplifiedFraction(Fraction f) {
		int g = gcd(Math.abs(f.numerator), Math.abs(f.denominator));
		Fraction sf = new Fraction();
		sf.numerator = f.numerator / g;
		sf.denominator = f.denominator / g;
		return sf;
	}

	public static int gcd(int a, int b) {
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static void display() {
		Fraction f = new Fraction();
		f.numerator = input("tu so");
		f.denominator = input("mau so");
		Fraction sf = simplifiedFraction(f);
		System.out.println("Phan so toi gian la: " + sf.numerator + "/" + sf.denominator);

	}
}
