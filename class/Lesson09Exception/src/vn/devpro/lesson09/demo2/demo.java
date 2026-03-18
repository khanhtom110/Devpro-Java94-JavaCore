package vn.devpro.lesson09.demo2;

import java.util.Scanner;

public class demo {
	static Scanner sc = new Scanner(System.in);

	public static void buying(Book book) {
		try {
			System.out.print("Nhap so luong sach: ");
			int quantity = Integer.parseInt(sc.nextLine());
			if (quantity < 1 || quantity > book.getAmount()) {
				System.out.println("So luong khong hop le");
			}

			System.out.println("Ban da dat " + quantity + " cuon sach" + book.getName());
		} catch (NumberFormatException e) {
			System.out.println("Ban phai nhap so nguyen");
		} finally {
			System.out.println("Ciaooo!!");
		}
	}

	public static void main(String[] args) {
		Book book = new Book("Java", 10);
		buying(book);
	}
}
