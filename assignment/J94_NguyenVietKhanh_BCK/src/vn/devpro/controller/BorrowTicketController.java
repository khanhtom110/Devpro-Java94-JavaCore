package vn.devpro.controller;

import java.util.Scanner;

import vn.devpro.dto.BorrowTicket;

public class BorrowTicketController {
	static Scanner sc = new Scanner(System.in);

	private static BorrowTicket borrowTicket = new BorrowTicket();

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN PHIEU MUON SACH");
			System.out.println("Chon mot chuc nang");
			System.out.println("\t 1.Xem tat cac cuon sach");
			System.out.println("\t 2.Tim sach theo the loai");
			System.out.println("\t 3.Tim sach theo tac gia");
			System.out.println("\t 4.Tim ten sach");
			System.out.println("\t 5.Xem phieu muon sach");
			System.out.println("\t 6.Them sach vao phieu");
			System.out.println("\t 7.Sua thong tin trong phieu");
			System.out.println("\t 8.Xoa sach trong phieu");
			System.out.println("\t 9.Xoa toan bo sach trong phieu");
			System.out.println("\t10.Xac nhan muon sach");
			System.out.println("\t11.Xem danh sach phieu muon");
			System.out.println("\t12.Xem chi tiet phieu muon sach");
			System.out.println("\t 0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				BookController.read();
				break;
			case 2:
				BookController.getByCategory();
				break;
			case 3:
				BookController.getByAuthor();
				break;
			case 4:
				BookController.getByName();
				break;
			case 5:
				borrowTicket.display();
				break;
			case 6:
				borrowTicket.add();
				break;
			case 7:
				borrowTicket.update();
				break;
			case 8:
				borrowTicket.delete();
				break;
			case 9:
				borrowTicket.deleteAll();
				break;
			case 10:
				borrowTicket.borrow();
				break;
			case 11:
				LoanReceiptController.read();
				break;
			case 12:
				LoanDetailController.read();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}
}
