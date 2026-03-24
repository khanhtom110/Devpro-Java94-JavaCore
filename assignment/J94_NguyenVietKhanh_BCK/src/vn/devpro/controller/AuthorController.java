package vn.devpro.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Author;
import vn.devpro.service.AuthorService;

public class AuthorController {
	public static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN TAC GIA");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1.Hien thi danh sach");
			System.out.println("\t2.Them moi");
			System.out.println("\t3.Sua thong tin");
			System.out.println("\t4.Xoa thong tin");
			System.out.println("\t5.Sap xep");
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
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}

	private static void read() {
		// TODO Auto-generated method stub
		List<Author> authors = AuthorService.findAll();
		System.out.println("\t\tDANH SACH TAC GIA");
		System.out.printf("%3s %17s %-25s%n", "ID", "Ma sach", "Ho va ten");
		for (Author author : authors) {
			author.display();
		}
	}

	private static void create() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI TAC GIA");
		System.out.print("\tNhap ho tac gia: ");
		String firstName = sc.nextLine();
		if (firstName == null || firstName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}

		System.out.print("\tNhap ten tac gia: ");
		String lastName = sc.nextLine();
		if (lastName == null || lastName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		String name = firstName + " " + lastName;

		if (AuthorService.existsByName(name)) {
			// Ten tac gia co the trung nhau nen hoi nguoi quan tri de xac nhan lai
			int choose;
			System.out.print("\tTen da ton tai, ban co muon huy hay khong(1-co,2-khong): ");
			choose = Integer.parseInt(sc.nextLine());
			if (choose == 1) {
				return;
			}
		}

		Author author = new Author();
		author.setId(LibraryDb.getAuthorId());
		author.setCode("AU" + new Date().getTime() + LibraryDb.getAuthorId());
		author.setFirstName(firstName);
		author.setLastName(lastName);
		LibraryDb.setAuthorId(LibraryDb.getAuthorId() + 1);

		AuthorService.save(author);
		System.out.println("Tao tac gia thanh cong");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN TAC GIA");
		System.out.print("\tNhap ma tac gia can sua: ");
		String code = sc.nextLine();
		Author author = AuthorService.getByCode(code);
		if (author == null) {
			System.out.println("Khong ton tai tac gia do");
			return;
		}

		// Sua ho va ten tac gia
		System.out.print("\tNhap ho: ");
		String firstName = sc.nextLine();
		if (firstName == null || firstName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		System.out.print("\tNhap ten: ");
		String lastName = sc.nextLine();
		if (lastName == null || lastName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		String name = firstName + " " + lastName;

		if (AuthorService.existsByName(name)) {
			// Ten tac gia co the trung nhau nen hoi nguoi quan tri de xac nhan lai
			int choose;
			System.out.print("\tTen da ton tai, ban co muon huy hay khong(1-co,2-khong): ");
			choose = Integer.parseInt(sc.nextLine());
			if (choose == 1) {
				return;
			}
		}

		author.setFirstName(firstName);
		author.setLastName(lastName);

		AuthorService.update(author);
		System.out.println("Sua thong tin tac gia thanh cong");
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN TAC GIA");
		System.out.print("\tNhap ma tac gia can xoa: ");
		String code = sc.nextLine();
		int index = AuthorService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma tac gia khong chinh xac");
			return;
		}
		AuthorService.delete(index);
		System.out.println("Xoa tac gia thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		AuthorService.sort();
		read();
	}
}
