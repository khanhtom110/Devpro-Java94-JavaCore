package vn.devpro.java94.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Provider;
import vn.devpro.java94.service.ProviderService;

public class ProviderController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN NHA CUNG CAP");
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
		// Doc du lieu tu Db
		List<Provider> providers = ProviderService.findAll();
		System.out.println("\tDANH SACH NHA CUNG CAP");
		System.out.printf("%-3s %-17s %-30s%n", "ID", "Ma NCC", "Ten NCC");
		for (Provider provider : providers) {
			provider.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI NCC");
		System.out.print("\tNhap ten NCC: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen NCC khong duoc de trong");
			return;
		}

		// Ten NCC khong duoc trung nhau
		if (ProviderService.existsByName(name)) {
			System.out.println("\tTen NCC da ton tai, vui long nhap ten khac");
			return;
		}

		// Tao NCC moi
		Provider provider = new Provider();
		provider.setId(StoreDb.getProviderId());
		provider.setCode("NCC" + new Date().getTime() + StoreDb.getProviderId());
		provider.setName(name);
		StoreDb.setProviderId(StoreDb.getProviderId() + 1); // Tang providerId

		// Ghi du lieu vao Db
		ProviderService.save(provider);
	}

	private static void update() {
		// TODO Auto-generated method stub
		// Tim NCC bang Ma NCC
		System.out.println("\n\t\tSUA THONG TIN NCC");
		System.out.print("\tNhap ma NCC can sua: ");
		String code = sc.nextLine();
		int index = ProviderService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma NCC khong chinh xac");
			return;
		}

		System.out.print("\tNhap ten NCC: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen NCC khong duoc de trong");
			return;
		}

		// Ten NCC khong duoc trung nhau
		if (ProviderService.existsByName(name)) {
			System.out.println("\tTen NCC da ton tai, vui long nhap ten khac");
			return;
		}

		// Lay provider trong db
		Provider provider = ProviderService.getByCode(code); // Lam cach nay thi ngoai setName con set duoc cac thuoc
																// tinh khac mot cach don gian hon
		if (provider == null) {
			System.out.println("Loi CSDL");
			return;
		}
		provider.setName(name);
		ProviderService.update(index, provider);
		System.out.println("Sua thong tin thanh cong!");
	}

	private static void delete() {
		// TODO Auto-generated method stub
		// Tim NCC bang Ma NCC
		System.out.println("\n\t\tXOA THONG TIN NCC");
		System.out.print("\tNhap ma NCC can xoa: ");
		String code = sc.nextLine();
		int index = ProviderService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma NCC khong chinh xac");
			return;
		}
		ProviderService.delete(index);
		System.out.println("Xoa NCC thanh cong!");
	}

}
