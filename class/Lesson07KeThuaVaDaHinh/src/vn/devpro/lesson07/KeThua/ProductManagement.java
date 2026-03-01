package vn.devpro.lesson07.KeThua;

import java.util.Scanner;

public class ProductManagement {
	// Su dung ham de do phai khoi tao doi tuong
	public static void input(Electronic[] electronics) {
		System.out.println("Nhap danh sach san pham: ");
		for (int i = 0; i < electronics.length; i++) {
			System.out.println("Nhap thong tin san pham thu " + (i + 1));
			electronics[i] = new Electronic();
			electronics[i].input();
		}
	}

	public static void display(Electronic[] electronics) {
		System.out.println("Danh sach san pham: ");
		for (Electronic electronic : electronics) {
			electronic.output();
		}
	}

	public static void displayMinPrice(Electronic[] electronics) {
		System.out.println("Danh sach san pham co gia min: ");
		double minPrice = electronics[0].getPrice();
		for (int i = 0; i < electronics.length; i++) {
			if (minPrice < electronics[i].getPrice()) {
				minPrice = electronics[i].getPrice();
			}
		}
		for (Electronic electronic : electronics) {
			if (electronic.getPrice() == minPrice) {
				electronic.output();
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Nhap so luong san pham: ");
		int n = Integer.parseInt(new Scanner(System.in).nextLine());
		Electronic[] electronics = new Electronic[n];
		input(electronics);
		display(electronics);
	}
}
