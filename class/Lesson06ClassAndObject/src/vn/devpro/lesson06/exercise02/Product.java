package vn.devpro.lesson06.exercise02;

import java.util.Scanner;

public class Product {
	private String code;
	private String name;
	private int quantity;
	private double price;

	public double total() {
		return this.quantity * this.price;
	}

	public void display() {
		System.out.printf("%-12s %-30s %,12d %,15.2f %,20.2f%n", this.code, this.name, this.quantity, this.price,
				total());
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\t\tSUA THONG TIN SAN PHAM");
			System.out.println("Xin chon thong tin can sua");
			System.out.println("\t1. Sua ten san pham");
			System.out.println("\t2. Sua so luong");
			System.out.println("\t3. Sua don gia");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				System.out.print("Nhap ten san pham moi: ");
				this.name = sc.nextLine();
				break;
			case 2:
				System.out.print("Nhap so luong moi: ");
				this.quantity = Integer.parseInt(sc.nextLine());
				break;
			case 3:
				System.out.print("Nhap don gia moi: ");
				this.price = Double.parseDouble(sc.nextLine());
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	public Product() {
		super();
	}

	public Product(String code, String name, int quantity, double price) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
