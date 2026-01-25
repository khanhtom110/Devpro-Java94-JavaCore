package vn.devpro.lesson03.ifdemo;

public class ifdemo {
	public static void division(int a, int b) {
		int c;
		if (b != 0) {
			c = a / b;
			System.out.println("c = " + c);
		}
	}

	public static double payment(double k) {
		if (k <= 50) {
			return k * 1984;
		} else if (k <= 100) {
			return k * 1984 + (k - 50) * 2050;
		} else if (k <= 200) {
			return k * 1984 + 50 * 2050 + (k - 100) * 2380;
		} else if (k <= 300) {
			return k * 1984 + 50 * 2050 + 100 * 2380 + (k - 200) * 2998;
		} else if (k <= 400) {
			return k * 1984 + 50 * 2050 + 100 * 2380 + 200 * 2998 + (k - 300) * 3350;
		} else {
			return k * 1984 + 50 * 2050 + 100 * 2380 + 200 * 2998 + 300 * 3350 + (k - 400) * 3460;
		}
	}

	public static void main(String[] args) {
		// int a = 5;
		// int b = 0;
		// division(a, b);
		// System.out.println("End of program");

		int k = 330;
		double res = payment(k) * 1.08; // vat:1.08%
		System.out.printf("Gia tien dien phai tra la: %,.2f", res);
	}
}
