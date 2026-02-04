package vn.devpro.lesson06.exercise02;

import java.util.Scanner;

public class Customer {
	private String name;
	private String mobile;
	private String address;

	public void display() {
		System.out.println("\t Ho ten khach: " + this.name);
		System.out.println("\t SDT: " + this.mobile);
		System.out.println("\t Dia chi giao hang: " + this.address);
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\t\tSUA THONG TIN KHACH HANG");
			System.out.println("Xin chon thong tin can sua");
			System.out.println("\t1. Sua ten khach hang");
			System.out.println("\t2. Sua so dien thoai");
			System.out.println("\t3. Sua dia chi giao hang");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				System.out.print("Nhap ten khach hang moi: ");
				this.name = sc.nextLine();
				break;
			case 2:
				System.out.print("Nhap so dien thoai moi: ");
				this.mobile = sc.nextLine();
				break;
			case 3:
				System.out.print("Nhap dia chi giao hang moi: ");
				this.address = sc.nextLine();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	public Customer() {
		super();
	}

	public Customer(String name, String mobile, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
