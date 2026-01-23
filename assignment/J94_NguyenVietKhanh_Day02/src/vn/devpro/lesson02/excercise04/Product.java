package vn.devpro.lesson02.excercise04;

import java.util.Scanner;

public class Product {
	String name;
	int quantity;
	double unitPrice;

	public static Product input() {
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		System.out.print("Ten hang: ");
		product.name = sc.nextLine();
		System.out.print("So luong: ");
		product.quantity = sc.nextInt();
		System.out.print("Don gia: ");
		product.unitPrice = sc.nextDouble();
		return product;
	}

	public static double totalPrice(Product product) {
		return product.quantity * product.unitPrice;
	}

	public static void display(Product product) {
		System.out.printf("%-25s %-10d %-15.0f %-10.0f%n", product.name, product.quantity, product.unitPrice,
				totalPrice(product));
	}
}
