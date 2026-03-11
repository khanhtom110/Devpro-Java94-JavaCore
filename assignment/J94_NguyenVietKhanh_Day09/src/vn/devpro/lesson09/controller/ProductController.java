package vn.devpro.lesson09.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.lesson09.database.ShopDb;
import vn.devpro.lesson09.model.Category;
import vn.devpro.lesson09.model.Product;
import vn.devpro.lesson09.service.CategoryService;
import vn.devpro.lesson09.service.ProductService;

public class ProductController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {
		do {
			System.out.println("\t\tQUAN TRI THONG TIN DANH MUC SAN PHAM");
			System.out.println("Chon mot chuc nang quan tri");
			System.out.println("\t1.Hien thi danh sach");
			System.out.println("\t2.Them moi");
			System.out.println("\t3.Sua thong tin");
			System.out.println("\t4.Xoa thong tin");
			System.out.println("\t5.Sap xep");
			System.out.println("\t6.Tim san pham theo danh muc/chung loai");
			System.out.println("\t7.Tim kiem theo ten san pham");
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
			case 6:
				getByCategory();
				break;
			case 7:
				getByName();
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
		List<Product> products = ProductService.findAll();
		System.out.println("\t\tDANH SACH SAN PHAM");
		System.out.printf("%3s %-15s %17s %-25s %13s%n", "ID", "Danh muc", "Ma SP", "Ten SP", "Don gia");
		for (Product product : products) {
			product.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\tTHEM MOI SAN PHAM");
		System.out.print("Nhap ten SP: ");
		String productName = sc.nextLine();
		if (productName == null || productName.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}
		if (ProductService.existsByName(productName)) {
			System.out.println("Ten SP da ton tai, vui long nhap ten khac");
			return;
		}
		System.out.print("Nhap don gia: ");
		Double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("\tDon gia khong the la so am");
			return;
		}
		System.out.print("Nhap ma danh muc: ");
		String categoryCode = sc.nextLine();
		if (categoryCode == null || categoryCode.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}
		Category category = CategoryService.getByCode(categoryCode);
		if (category == null) {
			System.out.println("Danh muc khong ton tai");
			return;
		}

		// Luu san pham moi
		Product product = new Product();
		product.setId(ShopDb.getProductId());
		product.setCategoryId(category.getId());
		product.setCode("SP" + new Date().getTime() + ShopDb.getProductId());
		product.setName(productName);
		product.setPrice(price);

		ShopDb.setProductId(ShopDb.getProductId() + 1);

		ProductService.save(product);
		System.out.println("Luu SP thanh cong!");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\tCAP NHAT SAN PHAM");
		System.out.print("Nhap ma SP can sua: ");
		String productCode = sc.nextLine();
		if (productCode == null || productCode.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}
		Product product = ProductService.getByCode(productCode);
		if (product == null) {
			System.out.println("SP khong ton tai");
			return;
		}

		int choose;
		System.out.println("\tBan co muon sua ten khong (1-co, 0-khong)");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ten SP: ");
			String name = sc.nextLine();
			if (name == null || name.trim().length() <= 0) {
				System.out.println("\tTen SP khong duoc de trong");
				return;
			}

			// Ten SP khong duoc trung nhau
			if (ProductService.existsByName(name)) {
				System.out.println("\tTen SP da ton tai, vui long nhap ten khac");
				return;
			}

			product.setName(name);
		}

		System.out.println("\tBan co muon sua don gia khong (1-co, 0-khong)");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("Nhap don gia san pham: ");
			double price = Double.parseDouble(sc.nextLine());
			if (price < 0) {
				System.out.println("\tDon gia khong the la so am");
				return;
			}

			product.setPrice(price);
		}

		System.out.println("\tBan co muon sua Ma danh muc khong (1-co, 0-khong)");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ma danh muc: ");
			String categoryCode = sc.nextLine();
			Category category = CategoryService.getByCode(categoryCode);
			if (category == null) {
				System.out.println("\tDanh muc khong ton tai");
				return;
			}

			product.setCategoryId(category.getId());
		}

		ProductService.update(product);
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\tXOA SAN PHAM");
		System.out.print("Nhap ma SP can xoa: ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("Khong duoc de trong");
			return;
		}

		// Kiem tra ton tai
		if (!ProductService.existsByCode(code)) {
			System.out.println("SP khong ton tai");
			return;
		}
		int index = ProductService.findByCode(code);
		ProductService.delete(index);
		System.out.println("Xoa thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		ProductService.sort(ProductService.findAll());
		display();
	}

	private static void getByCategory() {
		// TODO Auto-generated method stub
		System.out.println("\tTIM KIEM SAN PHAM THEO DANH MUC");
		System.out.print("Nhap ten danh muc can tim: ");
		String categoryName = sc.nextLine();
		if (categoryName.trim().length() <= 0 || categoryName == null) {
			System.out.println("Khong duoc de trong");
			return;
		}
		Category category = CategoryService.getByName(categoryName);
		// Kiem tra danh muc ton tai khong
		if (category == null) {
			System.out.println("Khong tim thay danh muc");
			return;
		}
		List<Product> products = ProductService.getProductsByCategory(category);
		System.out.println("\t\tDANH SACH SAN PHAM");
		System.out.printf("%3s %-15s %17s %-25s %%13s%n", "ID", "Danh muc", "Ma SP", "Ten SP", "Don gia");
		for (Product product : products) {
			product.display();
		}
	}

	private static void getByName() {
		// TODO Auto-generated method stub
		System.out.println("\tTIM KIEM SAN PHAM THEO TEN");
		System.out.print("Nhap ten SP can tim: ");
		String productName = sc.nextLine();
		if (productName.trim().length() <= 0 || productName == null) {
			System.out.println("Khong duoc de trong");
			return;
		}
		List<Product> products = ProductService.getProductsByName(productName);
		System.out.println("\t\tDANH SACH SAN PHAM");
		System.out.printf("%3s %-15s %17s %-25s %%13s%n", "ID", "Danh muc", "Ma SP", "Ten SP", "Don gia");
		for (Product product : products) {
			product.display();
		}
	}
}
