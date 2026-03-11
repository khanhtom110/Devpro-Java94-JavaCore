package vn.devpro.java94.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Customer;
import vn.devpro.java94.service.CustomerService;

public class CustomerController {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN KHACH HANG");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. Them moi");
			System.out.println("\t3. Sua thong tin");
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
		List<Customer> customers = CustomerService.findAll();
		System.out.println("\t\tDANH SACH KHACH HANG");
		System.out.printf("%3s %17s %-30s%n", "ID", "Ma KH", "Ten KH");
		for (Customer customer : customers) {
			customer.display();
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI KHACH HANG");
		System.out.print("\tNhap ten khach hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen khach hang khong duoc de trong");
			return;
		}

		// Ten khach hang khong duoc trung nhau
		if (CustomerService.existsByName(name)) {
			System.out.println("\tTen da ton tai, vui long nhap ten khac");
			return;
		}

		// Tao moi
		Customer customer = new Customer();
		customer.setId(StoreDb.getCustomerId());
		customer.setCode("KH" + new Date().getTime() + StoreDb.getCustomerId());
		customer.setName(name);
		StoreDb.setCustomerId(StoreDb.getCustomerId() + 1); // Tang providerId

		// Ghi du lieu vao Db
		CustomerService.save(customer);
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN KHACH HANG");
		System.out.print("\tNhap ma KH can sua: ");
		String code = sc.nextLine();
		int index = CustomerService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma KH khong chinh xac");
			return;
		}

		System.out.print("\tNhap ten KH: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() <= 0) {
			System.out.println("\tTen KH khong duoc de trong");
			return;
		}

		// Ten KH khong duoc trung nhau
		if (CustomerService.existsByName(name)) {
			System.out.println("\tTen da ton tai, vui long nhap ten khac");
			return;
		}

		Customer customer = CustomerService.getByCode(code);
		if (customer == null) {
			System.out.println("Loi CSDL");
			return;
		}
		customer.setName(name);
		CustomerService.update(index, customer);
		System.out.println("Sua thong tin thanh cong!");
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN KHACH HANG");
		System.out.print("\tNhap ma KH can xoa: ");
		String code = sc.nextLine();
		int index = CustomerService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma KH khong chinh xac");
			return;
		}
		CustomerService.delete(index);
		System.out.println("Xoa KH thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		List<Customer> customers = CustomerService.findAll();
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
}
