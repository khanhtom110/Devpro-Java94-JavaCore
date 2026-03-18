package vn.devpro.java94.controller;

import java.util.Scanner;

import vn.devpro.java94.dto.Cart;
import vn.devpro.java94.service.OrderService;

public class CartController {
	static Scanner sc = new Scanner(System.in);

	// Khoi tao mot gio hang cho khach
	static Cart cart = new Cart();

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN GIO HANG");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1. Xem danh sach san pham");
			System.out.println("\t2. Xem gio hang");
			System.out.println("\t3. Them hang vao gio");
			System.out.println("\t4.Sua thong tin trong gio");
			System.out.println("\t5.Xoa hang trong gio");
			System.out.println("\t6.Xoa toan bo san pham trong gio");
			System.out.println("\t7.Dat hang");
			System.out.println("\t8.Xem don hang");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				ProductController.display();
				break;
			case 2:
				cart.display();
				break;
			case 3:
				cart.add();
				break;
			case 4:
				cart.edit();
				break;
			case 5:
				cart.delete();
				break;
			case 6:
				cart.deleteAll();
				break;
			case 7:
				cart.placeOrder();
				System.out.println("\tBan da dat hang thanh cong!");
				cart = new Cart(); // Xoa gio hang sau khi dat
				return;
			case 8:
				OrderService.displayAll();
				return;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}
}
