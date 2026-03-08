package vn.devpro.java94.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Product;
import vn.devpro.java94.model.Provider;
import vn.devpro.java94.service.ProductService;
import vn.devpro.java94.service.ProviderService;

public class ProductController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN SAN PHAM");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. Them moi");
			System.out.println("\t3. Sua thong tin");
			System.out.println("\t4.Xoa thong tin");
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
		System.out.printf("%3s %30s %17s %-35s %13s%n", "ID", "Ten NCC", "Ma SP", "Ten SP", "Don gia");
		for (Product product : products) {
			product.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI SAN PHAM");
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

		// Nhap don gia va chon NCC
		System.out.print("Nhap don gia san pham: ");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("\tDon gia khong the la so am");
			return;
		}
		System.out.print("\tNhap ma NCC: ");
		String providerCode = sc.nextLine();
		Provider provider = ProviderService.getByCode(providerCode);
		if (provider == null) {
			System.out.println("\tNCC khong ton tai");
			return;
		}

		// Tao san pham moi
		Product product = new Product();
		product.setCode("SP" + new Date().getTime() + StoreDb.getProductId());
		product.setId(StoreDb.getProductId());
		product.setProviderId(provider.getId());
		product.setName(name);
		product.setPrice(price);

		StoreDb.setProductId(StoreDb.getProductId() + 1);

		ProductService.save(product);
		System.out.println("Luu SP thanh cong");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN SP");
		System.out.print("\tNhap ma SP can sua: ");
		String code = sc.nextLine();
		Product product = ProductService.getByCode(code);
		if (product == null) {
			System.out.println("Khong ton tai SP do");
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

		System.out.println("\tBan co muon sua Ma NCC khong (1-co, 0-khong)");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ma NCC: ");
			String providerCode = sc.nextLine();
			Provider provider = ProviderService.getByCode(providerCode);
			if (provider == null) {
				System.out.println("\tNCC khong ton tai");
				return;
			}

			product.setProviderId(provider.getId());
		}

		ProductService.update(product);
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN SP");
		System.out.print("\tNhap ma SP can xoa: ");
		String code = sc.nextLine();
		int index = ProductService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma SP khong chinh xac");
			return;
		}
		ProductService.delete(index);
		System.out.println("Xoa SP thanh cong!");
	}
}
