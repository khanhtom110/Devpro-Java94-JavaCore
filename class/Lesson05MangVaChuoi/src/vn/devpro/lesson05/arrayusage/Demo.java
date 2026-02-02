package vn.devpro.lesson05.arrayusage;

import java.util.Scanner;

public class Demo {
	static Scanner sc = new Scanner(System.in);

	public static double[] init() {
		double[] a = { 2.33, 3.44, 4.55, 5.66, -1.2, 0, 3.44 };
		return a;
	}

	public static double input(String var) {
		try {
			System.out.print("Nhap " + var + ": ");
			return Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Yeu cau nhap so thuc");
		}
		return 0;
	}

	public static void display(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int[] pos(double[] a, double x) {
		int[] b = null;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				if (b == null) {
					b = new int[1];
					b[0] = i;
				} else {
					int[] c = b.clone(); // Sao chep gia tri sang mang c
					b = new int[b.length + 1];
					for (int j = 0; j < c.length; j++) {
						b[j] = c[j];
					}
					b[b.length - 1] = i;
				}
			}
		}
		return b;
	}

	public static void main(String[] args) {
		double[] a = init();
		System.out.println("Mang duoc khoi tao:");
		display(a);
		double x = 3.44;
		int[] b = pos(a, x);
		System.out.println("Mang ket qua:");
		if (b == null) {
			System.out.println("x khong xuat hien trong mang a");
		} else {
			System.out.println("x xuat hien " + b.length + " lan trong mang a");
			System.out.print("O cac vi tri co chi so: ");
			display(b);
		}
	}
}
