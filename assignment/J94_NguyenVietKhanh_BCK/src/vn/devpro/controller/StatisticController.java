package vn.devpro.controller;

import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.dto.BorrowedBookRespone;
import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.model.Category;
import vn.devpro.service.BookService;
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
				getBooksByCategory();
				break;
			case 2:
				getBooksByAuthor();
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

	private static void getBooksByCategory() {
		// TODO Auto-generated method stub
		int count = 1;
		String s = "";
		System.out.println("\t\tTHONG KE SACH THEO THE LOAI");
		System.out.printf("%3s %-25s %-35s%n", "STT", "Ten the loai", "Ten sach");
		for (Category category : LibraryDb.getCategories()) {
			System.out.printf("%3d ", count++);
			System.out.printf("%-25s ", category.getName());
			List<Book> books = BookService.getByCategory(category.getCode());
			boolean flag = false;
			int i = 0;
			for (Book book : books) {
				flag = true;
				if (i == 0) {
					System.out.printf("%-35s%n", book.getName());
					i++;
				} else {
					System.out.printf("%3s %-25s %-35s%n", s, s, book.getName());
				}
			}
			if (!flag) {
				System.out.println();
			}
		}
		System.out.println();
	}

	private static void getBooksByAuthor() {
		int count = 1;
		String s = "";
		System.out.println("\t\tTHONG KE SACH THEO TAC GIA");
		System.out.printf("%3s %-25s %-35s%n", "STT", "Ten tac gia", "Ten sach");
		for (Author author : LibraryDb.getAuthors()) {
			System.out.printf("%3d ", count++);
			System.out.printf("%-25s ", author.getFirstName() + " " + author.getLastName());
			List<Book> books = BookService.getByAuthor(author.getCode());
			boolean flag = false;
			int i = 0;
			for (Book book : books) {
				flag = true;
				if (i == 0) {
					System.out.printf("%-35s%n", book.getName());
					i++;
				} else {
					System.out.printf("%3s %-25s %-35s%n", s, s, book.getName());
				}
			}
			if (!flag) {
				System.out.println();
			}
		}
		System.out.println();

	}

	private static void borrowedBooks() {
		// TODO Auto-generated method stub
		int count = 1;
		List<BorrowedBookRespone> bookRespones = StatisticService.getBorrowdBooks();
		System.out.println("\t\tDANH SACH CAC SACH DANG DUOC MUON");
		System.out.printf("%3s %17s %-35s %-25s %-25s %10s%n", "STT", "Ma sach", "Ten sach", "Tac gia", "Nguoi muon",
				"Ngay tra");
		for (BorrowedBookRespone bookRespone : bookRespones) {
			System.out.printf("%3d ", count++);
			bookRespone.display();
		}
	}

	private static void alreadyBooks() {
		// TODO Auto-generated method stub
		int count = 1;
		List<Book> books = StatisticService.getAlreadyBooks();
		System.out.println("\t\tDANH SACH CAC SACH TRONG KHO");
		System.out.printf("%3s %3s %17s %-25s %-15s %-35s %8s %8s%n", "STT", "ID", "Ma sach", "Tac gia", "The loai",
				"Ten sach", "So trang", "So luong");
		// Sap xep
		BookService.sortByQuantity(books);
		for (Book book : books) {
			System.out.printf("%3d ", count++);
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

		int count = 1;
		List<BorrowedBookRespone> bookRespones = StatisticService.getBorrowdBooksByReader(code);
		System.out.println("\t\tDANH SACH CAC SACH DANG MUON BOI DOC GIA");
		System.out.printf("%3s %17s %-35s %-25s %-25s %10s%n", "STT", "Ma sach", "Ten sach", "Tac gia", "Nguoi muon",
				"Ngay tra");
		for (BorrowedBookRespone bookRespone : bookRespones) {
			System.out.printf("%3d ", count++);
			bookRespone.display();
		}
	}
}
