package vn.devpro.lesson09.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.lesson09.database.ShopDb;
import vn.devpro.lesson09.model.Category;
import vn.devpro.lesson09.service.CategoryService;

public class CategoryController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {
		do {
			System.out.println("\t\tCAP NHAT THONG TIN DANH MUC SAN PHAM");
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
				display();
				break;
			case 2:
				add();
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

	private static void display() {
		// TODO Auto-generated method stub
		List<Category> categories = CategoryService.findAll();
		System.out.println("\t\tDANH SACH DANH MUC SAN PHAM");
		System.out.printf("%3s %-17s %-15s%n", "ID", "Ma danh muc", "Ten danh muc");
		for (Category category : categories) {
			category.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\tTHEM MOI DANH MUC");
		System.out.print("Nhap ten danh muc moi: ");
		String name = sc.nextLine();
		Category category = new Category();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}

		// Kiem tra th trung ten
		if (CategoryService.findByName(name)) {
			System.out.println("Ten da bi trung");
			return;
		}
		category.setName(name);
		category.setId(ShopDb.getCategoryId());
		category.setCode("CAT" + new Date().getTime() + ShopDb.getCategoryId());

		ShopDb.setCategoryId(ShopDb.getCategoryId() + 1);
		CategoryService.save(category);
		System.out.println("Them danh muc thanh cong!");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\tCAP NHAT DANH MUC");
		System.out.print("Nhap ma danh muc can sua: ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}

		// Kiem tra ton tai
		if (!CategoryService.findByCode(code)) {
			System.out.println("Danh muc khong ton tai");
			return;
		}

		System.out.print("Nhap ten danh muc moi: ");
		String name = sc.nextLine();

		if (name == null || name.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}

		// Kiem tra th trung ten
		if (CategoryService.findByName(name)) {
			System.out.println("Ten da bi trung");
			return;
		}

		// update o service
	}

	private static void delete() {
		// TODO Auto-generated method stub

	}

	private static void sort() {
		// TODO Auto-generated method stub

	}
}
