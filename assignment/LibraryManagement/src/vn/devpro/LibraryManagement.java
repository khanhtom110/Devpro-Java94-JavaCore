package vn.devpro;

import java.util.Scanner;

import vn.devpro.controller.AuthorController;
import vn.devpro.controller.BookController;
import vn.devpro.controller.BorrowTicketController;
import vn.devpro.controller.CategoryController;
import vn.devpro.controller.LoanReceiptController;
import vn.devpro.controller.ReaderController;
import vn.devpro.controller.StatisticController;
import vn.devpro.database.LibraryDb;
import vn.devpro.service.ReaderService;

public class LibraryManagement {
	static Scanner sc = new Scanner(System.in);

	public static String customerCode;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LibraryDb.init();

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY THU VIEN");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1.Chuc nang nguoi quan tri");
			System.out.println("\t2.Nguoi doc");
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
			System.out.println("\t5.Quan tri thong tin phieu muon sach");
			System.out.println("\t6.Thong ke");
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
			case 5:
				LoanReceiptController.execute();
				break;
			case 6:
				StatisticController.execute();
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
		do {
			System.out.println("\t\tCHUC NANG NGUOI DOC");
			System.out.println("\tChon chuc nang");
			System.out.println("\t1.Dang ky");
			System.out.println("\t2.Dang nhap");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				ReaderController.create();
				break;
			case 2:
				Boolean flag = login();
				if (flag) {
					BorrowTicketController.execute();
				} else {
					System.out.println("\tMa dang nhap chua chinh xac");
				}
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);
	}

	private static boolean login() {
		// TODO Auto-generated method stub
		System.out.println("\t\tDANG NHAP");
		System.out.printf("\tNhap ma nguoi doc: ");
		customerCode = sc.nextLine();
		if (customerCode == null || customerCode.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return false;
		}
		boolean isExisted = ReaderService.existsByCode(customerCode);
		if (!isExisted) {
			return false;
		}
		return true;
	}

	public static String getCustomerCode() {
		return customerCode;
	}

	public static void setCustomerCode(String customerCode) {
		LibraryManagement.customerCode = customerCode;
	}
}
