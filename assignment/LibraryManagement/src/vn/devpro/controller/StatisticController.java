package vn.devpro.controller;

import java.util.List;
import java.util.Scanner;

import vn.devpro.dto.BorrowedBookRespone;
import vn.devpro.model.Book;
import vn.devpro.service.ReaderService;
import vn.devpro.service.StatisticService;

public class StatisticController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tTHONG KE");
			System.out.println("Chon mot chuc nang");
			System.out.println("\t1.Thong ke sach theo chung loai");
			System.out.println("\t2.Thong ke sach theo tac gia");
			System.out.println("\t3.Thong ke sach dang duoc muon");
			System.out.println("\t4.Thong ke sach trong kho");
			System.out.println("\t5.Thong ke sach cho muon theo doc gia");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				BookController.getByCategory();
				break;
			case 2:
				BookController.getByAuthor();
				break;
			case 3:
				borrowedBooks();
				break;
			case 4:
				alreadyBooks();
				break;
			case 5:
				getFullOfLoan();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}

	private static void borrowedBooks() {
		// TODO Auto-generated method stub
		List<BorrowedBookRespone> bookRespones = StatisticService.getBorrowdBooks();
		System.out.println("\t\tDANH SACH CAC SACH DANG DUOC MUON");
		System.out.printf("%-35s %-25s %-25s %10s%n", "Ten sach", "Tac gia", "Nguoi muon", "Ngay tra");
		for (BorrowedBookRespone bookRespone : bookRespones) {
			bookRespone.display();
		}
	}

	private static void alreadyBooks() {
		// TODO Auto-generated method stub
		List<Book> books = StatisticService.getAlreadyBooks();
		System.out.println("\t\tDANH SACH CAC SACH TRONG KHO");
		System.out.printf("%3s %17s %-25s %-15s %-35s %8s %8s%n", "ID", "Ma sach", "Tac gia", "The loai", "Ten sach",
				"So trang", "So luong");
		for (Book book : books) {
			book.display();
		}
	}

	private static void getFullOfLoan() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ma nguoi doc: ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		if (!ReaderService.existsByCode(code)) {
			System.out.println("\tNguoi doc khong ton tai");
			return;
		}
		List<BorrowedBookRespone> bookRespones = StatisticService.getBorrowdBooksByReader(code);
		System.out.println("\t\tDANH SACH CAC SACH DANG MUON BOI DOC GIA");
		System.out.printf("%-35s %-25s %-25s %10s%n", "Ten sach", "Tac gia", "Nguoi muon", "Ngay tra");
		for (BorrowedBookRespone bookRespone : bookRespones) {
			bookRespone.display();
		}
	}
}
