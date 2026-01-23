package vn.devpro.lesson02.excercise04;

import java.util.Date;
import java.util.Scanner;

public class Invoice {
	String id;
	String name;
	String date;

	Product product1 = new Product();
	Product product2 = new Product();
	Product product3 = new Product();
	Product product4 = new Product();
	Product product5 = new Product();

	public static Invoice input() {
		Scanner sc = new Scanner(System.in);
		Invoice invoice = new Invoice();
		invoice.id = "HD" + new Date().getTime();
		System.out.print("Ho ten khach hang: ");
		invoice.name = sc.nextLine();
		System.out.print("Ngay mua hang: ");
		invoice.date = sc.nextLine();
		System.out.println("Nhap thong tin hang hoa thu 1:");
		invoice.product1 = Product.input();
		System.out.println("Nhap thong tin hang hoa thu 2:");
		invoice.product2 = Product.input();
		System.out.println("Nhap thong tin hang hoa thu 3:");
		invoice.product3 = Product.input();
		System.out.println("Nhap thong tin hang hoa thu 4:");
		invoice.product4 = Product.input();
		System.out.println("Nhap thong tin hang hoa thu 5:");
		invoice.product5 = Product.input();
		return invoice;
	}

	public static void display(Invoice invoice) {
		System.out.println("THONG TIN HOA DON");
		System.out.println("Ma hoa don: " + invoice.id);
		System.out.println("Ho ten khach hang: " + invoice.name);
		System.out.println("Ngay mua hang: " + invoice.date);
		System.out.println("Danh sach hang hoa:");
		System.out.printf("%-25s %-10s %-15s %-15s%n", "Ten hang hoa", "So luong", "Don gia", "Thanh tien");
		Product.display(invoice.product1);
		Product.display(invoice.product2);
		Product.display(invoice.product3);
		Product.display(invoice.product4);
		Product.display(invoice.product5);
		double tmp = totalAmount(invoice);
		System.out.printf("Tong tien hang: %.0f%n", tmp);
		System.out.println("Thue gia tri gia tang: 10%");
		System.out.printf("Tong tien phai tra: %.0f", tmp + 0.1 * tmp);
	}

	public static double totalAmount(Invoice invoice) {
		return Product.totalPrice(invoice.product1) + Product.totalPrice(invoice.product2)
				+ Product.totalPrice(invoice.product3) + Product.totalPrice(invoice.product4)
				+ Product.totalPrice(invoice.product5);
	}
}
