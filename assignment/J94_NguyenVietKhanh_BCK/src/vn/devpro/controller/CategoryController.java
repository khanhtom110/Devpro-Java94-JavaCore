package vn.devpro.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Category;
import vn.devpro.service.CategoryService;

public class CategoryController {
	public static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN THE LOAI");
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
		List<Category> categories = CategoryService.findAll();
		System.out.println("\t\tDANH SACH THE LOAI");
		System.out.printf("%3s %17s %-25s%n", "ID", "Ma sach", "Ten the loai");
		for (Category category : categories) {
			category.display();
		}
	}

	private static void create() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI THE LOAI");
		System.out.print("\tNhap ten the loai: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}

		if (CategoryService.existsByName(name)) {
			System.out.println("\tTen da ton tai, vui long nhap ten khac");
			return;
		}

		Category category = new Category();
		category.setId(LibraryDb.getCategoryId());
		category.setCode("CAT" + new Date().getTime() + LibraryDb.getCategoryId());
		category.setName(name);
		LibraryDb.setCategoryId(LibraryDb.getCategoryId() + 1);

		CategoryService.save(category);
		System.out.println("Tao the loai thanh cong");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN THE LOAI");
		System.out.print("\tNhap ma the loai can sua: ");
		String code = sc.nextLine();
		Category category = CategoryService.getByCode(code);
		if (category == null) {
			System.out.println("Khong ton tai");
			return;
		}

		// Sua ho va ten tac gia
		System.out.print("\tNhap ten the loai: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}

		if (CategoryService.existsByName(name)) {
			System.out.println("\tTen da ton tai, vui long nhap ten khac");
			return;
		}

		category.setName(name);

		int index = CategoryService.findByCode(category.getCode());
		if (index == -1) {
			System.out.println("Ma the loai khong chinh xac");
			return;
		}
		CategoryService.update(index, category);
		System.out.println("Sua thong tin the loai thanh cong");
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN THE LOAI");
		System.out.print("\tNhap ma the loai can xoa: ");
		String code = sc.nextLine();
		int index = CategoryService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma the loai khong chinh xac");
			return;
		}
		CategoryService.delete(index);
		System.out.println("Xoa tac gia thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		CategoryService.sort();
		read();
	}
}
