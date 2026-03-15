package vn.devpro;

import java.util.Scanner;

import vn.devpro.controller.AuthorController;
import vn.devpro.controller.BookController;
import vn.devpro.controller.CategoryController;
import vn.devpro.controller.ReaderController;
import vn.devpro.database.LibraryDb;

public class LibraryManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LibraryDb.init();

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY THU VIEN");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Chuc nang nguoi quan tri");
			System.out.println("\t2. Nguoi doc");
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
			System.out.println("\t1.Quan tri thong tin nguoi doc");
			System.out.println("\t2.Quan tri thong tin the loai");
			System.out.println("\t3.Quan tri thong tin tac gia");
			System.out.println("\t4.Quan tri thong tin sach");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				ReaderController.execute();
				break;
			case 2:
				CategoryController.execute();
				break;
			case 3:
				AuthorController.execute();
				break;
			case 4:
				BookController.execute();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);
	}

	private static void customer() {
		// TODO Auto-generated method stub

	}

}
