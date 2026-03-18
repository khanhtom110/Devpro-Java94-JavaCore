package vn.devpro.lesson09.demo;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		try {
			doSomeMath();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("---Chuong trinh van chay sau khi bat loi---");
	}

	private static void doSomeMath() {
		// TODO Auto-generated method stub
		calculate();
	}

	private static void calculate() {
		// TODO Auto-generated method stub
		dividion();
	}

	public static Scanner sc = new Scanner(System.in);

	private static void dividion() throws ArithmeticException {
		// TODO Auto-generated method stub
		int a = 10, b = 0;

		// Exception handler
//		try {
//			System.out.print("Nhap so nguyen a:");
//			a = Integer.parseInt(sc.nextLine());
//			System.out.print("Nhap so nguyen b:");
//			b = Integer.parseInt(sc.nextLine());
//			
//		} catch (ArithmeticException e) {
//			System.out.println(e.getMessage());
//		} catch (NumberFormatException e) {
//			System.out.println(e.getMessage());
//		}

		if (b == 0) {
			throw new ArithmeticException("Loi chia cho 0");
		}
		int c = a / b;
		System.out.println("c=" + c);

	}
}
