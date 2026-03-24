package vn.devpro.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.model.Category;
import vn.devpro.service.AuthorService;
import vn.devpro.service.BookService;
import vn.devpro.service.CategoryService;

public class BookController {
	public static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN SACH");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1.Hien thi danh sach");
			System.out.println("\t2.Them moi");
			System.out.println("\t3.Sua thong tin");
			System.out.println("\t4.Xoa thong tin");
			System.out.println("\t5.Sap xep");
			System.out.println("\t6.Tim theo the loai");
			System.out.println("\t7.Tim theo tac gia");
			System.out.println("\t8.Tim ten sach");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				read();
				break;
			case 2:
				create();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				sort();
				break;
			case 6:
				getByCategory();
				break;
			case 7:
				getByAuthor();
				break;
			case 8:
				getByName();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}

	public static void read() {
		// TODO Auto-generated method stub
		List<Book> books = BookService.findAll();
		System.out.println("\t\tDANH SACH CAC LOAI SACH");
		System.out.printf("%3s %17s %-25s %-15s %-35s %8s %8s%n", "ID", "Ma sach", "Tac gia", "The loai", "Ten sach",
				"So trang", "So luong");
		for (Book book : books) {
			book.display();
		}
	}

	private static void create() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI SACH");
		System.out.print("\tNhap ten sach: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}

		if (BookService.existsByName(name)) {
			System.out.println("\tTen da ton tai, vui long nhap ten khac");
			return;
		}

		System.out.print("\tNhap ma tac gia: ");
		String authorCode = sc.nextLine();
		Author author = AuthorService.getByCode(authorCode);
		if (author == null) {
			System.out.println("\tTac gia khong ton tai");
			return;
		}
		System.out.print("\tNhap ma the loai: ");
		String categoryCode = sc.nextLine();
		Category category = CategoryService.getByCode(categoryCode);
		if (category == null) {
			System.out.println("\tThe loai khong ton tai");
			return;
		}

		System.out.print("\tNhap so trang: ");
		int numberOfPages = Integer.parseInt(sc.nextLine());
		if (numberOfPages < 0) {
			System.out.println("\tSo trang khong the la so am");
			return;
		}
		System.out.print("\tNhap so luong: ");
		int quantity = Integer.parseInt(sc.nextLine());
		if (quantity < 0) {
			System.out.println("\tSo luong khong the la so am");
			return;
		}

		Book book = new Book();
		book.setCode("BK" + new Date().getTime() + LibraryDb.getBookId());
		book.setId(LibraryDb.getBookId());
		book.setAuthorId(author.getId());
		book.setCategoryId(category.getId());
		book.setName(name);
		book.setNumberOfPages(numberOfPages);
		book.setQuantity(quantity);

		LibraryDb.setBookId(LibraryDb.getBookId() + 1);

		BookService.save(book);
		System.out.println("Luu sach thanh cong");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN SACH");
		System.out.print("\tNhap ma sach can sua: ");
		String code = sc.nextLine();
		Book book = BookService.getByCode(code);
		if (book == null) {
			System.out.println("Khong ton tai");
			return;
		}

		int choose;
		System.out.print("\tBan co muon sua ten khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ten sach: ");
			String name = sc.nextLine();
			if (name == null || name.trim().length() <= 0) {
				System.out.println("\tKhong duoc de trong");
				return;
			}

			if (BookService.existsByName(name)) {
				System.out.println("\tTen da ton tai, vui long nhap ten khac");
				return;
			}

			book.setName(name);
		}

		System.out.print("\tBan co muon sua tac gia khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ma tac gia: ");
			String authorCode = sc.nextLine();
			Author author = AuthorService.getByCode(authorCode);
			if (author == null) {
				System.out.println("\tTac gia khong ton tai");
				return;
			}

			book.setAuthorId(author.getId());
		}
		System.out.print("\tBan co muon sua the loai khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ma the loai: ");
			String categoryCode = sc.nextLine();
			Category category = CategoryService.getByCode(categoryCode);
			if (category == null) {
				System.out.println("\tThe loai khong ton tai");
				return;
			}

			book.setCategoryId(category.getId());
		}

		System.out.print("\tBan co muon sua so trang khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("Nhap so trang: ");
			int numberOfPages = Integer.parseInt(sc.nextLine());
			if (numberOfPages < 0) {
				System.out.println("\tSo trang khong the la so am");
				return;
			}

			book.setNumberOfPages(numberOfPages);
		}
		System.out.print("\tBan co muon sua so luong khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("Nhap so luong: ");
			int quantity = Integer.parseInt(sc.nextLine());
			if (quantity < 0) {
				System.out.println("\tSo trang khong the la so am");
				return;
			}

			book.setQuantity(quantity);
		}

		BookService.update(book);
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN SACH");
		System.out.print("\tNhap ma sach can xoa: ");
		String code = sc.nextLine();
		int index = BookService.findByCode(code);
		if (index == -1) {
			System.out.println("\tMa sach khong chinh xac");
			return;
		}
		BookService.delete(index);
		System.out.println("Xoa sach thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		BookService.sortByName();
		read();
	}

	public static void getByCategory() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ma the loai: ");
		String categoryCode = sc.nextLine();
		if (categoryCode == null || categoryCode.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		int index = CategoryService.findByCode(categoryCode);
		if (index == -1) {
			System.out.println("\tMa the loai khong chinh xac");
			return;
		}
		List<Book> books = BookService.getByCategory(categoryCode);
		System.out.println("\t\tDANH SACH CAC LOAI SACH");
		System.out.printf("%3s %17s %-25s %-15s %-35s %8s %8s%n", "ID", "Ma sach", "Tac gia", "The loai", "Ten sach",
				"So trang", "So luong");
		for (Book book : books) {
			book.display();
		}
	}

	public static void getByAuthor() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ma tac gia: ");
		String authorCode = sc.nextLine();
		if (authorCode == null || authorCode.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		int index = AuthorService.findByCode(authorCode);
		if (index == -1) {
			System.out.println("\tMa tac gia khong chinh xac");
			return;
		}
		List<Book> books = BookService.getByAuthor(authorCode);
		System.out.println("\t\tDANH SACH CAC LOAI SACH");
		System.out.printf("%3s %17s %-25s %-15s %-35s %8s %8s%n", "ID", "Ma sach", "Tac gia", "The loai", "Ten sach",
				"So trang", "So luong");
		for (Book book : books) {
			book.display();
		}
	}

	public static void getByName() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ten sach: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		List<Book> books = BookService.getByName(name);
		System.out.println("\t\tDANH SACH CAC LOAI SACH");
		System.out.printf("%3s %17s %-25s %-15s %-35s %8s %8s%n", "ID", "Ma sach", "Tac gia", "The loai", "Ten sach",
				"So trang", "So luong");
		for (Book book : books) {
			book.display();
		}
	}

}
