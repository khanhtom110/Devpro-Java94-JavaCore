package vn.devpro.controller;

import java.util.List;
import java.util.Scanner;

import vn.devpro.model.LoanReceipt;
import vn.devpro.service.LoanReceiptService;

public class LoanReceiptController {

	static Scanner sc = new Scanner(System.in);

	public static void execute() {
		// TODO Auto-generated method stub
		do {
			System.out.println("\t\tQUAN TRI PHIEU MUON SACH");
			System.out.println("\tChon chuc nang quan tri");
			System.out.println("\t1.Hien thi danh sach");
			System.out.println("\t2.Xem chi tiet");
			System.out.println("\t3.Xoa thong tin");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				read();
				break;
			case 2:
				detail();
				break;
			case 3:
				delete();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}

	public static void read() {
		List<LoanReceipt> loanReceipts = LoanReceiptService.findAll();
		System.out.println("\t\tDANH SACH PHIEU");
		System.out.printf("%10s %10s %-25s %10s %15s%n", "Ma phieu", "Ma doc gia", "Ten doc gia", "Ngay tao",
				"Trang thai");
		for (LoanReceipt loanReceipt : loanReceipts) {
			loanReceipt.display();
		}
	}

	private static void detail() {
		// TODO Auto-generated method stub
		LoanDetailController.read();
	}

	private static void delete() {
		// TODO Auto-generated method stub
		LoanDetailController.delete();
	}
}
