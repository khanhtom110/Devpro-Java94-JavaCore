package vn.devpro.java94;

import java.util.Scanner;

import vn.devpro.java94.controller.ProductController;
import vn.devpro.java94.controller.ProviderController;
import vn.devpro.java94.database.StoreDb;

public class StoreInit {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StoreDb.initDb();

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY BAN HANG");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Chuc nang nguoi quan tri");
			System.out.println("\t2. Khach mua hang");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				administration();
				break;
			case 2:
				customer();
				break;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	private static void administration() {
		do {
			System.out.println("\t\tQUAN TRI HE THONG");
			System.out.println("\tChon chuc nang quan tri");
			System.out.println("\t1.Quan tri thong tin nha cung cap");
			System.out.println("\t2.Quan tri thong tin san pham");
			System.out.println("\t3.Quan tri thong tin khach hang");
			System.out.println("\t4.Quan tri thong tin don hang");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				ProviderController.execute();
				break;
			case 2:
				ProductController.execute();
				break;
			case 3:

				break;
			case 4:

				break;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);
	}

	private static void customer() {
		// TODO Auto-generated method stub

	}

}
