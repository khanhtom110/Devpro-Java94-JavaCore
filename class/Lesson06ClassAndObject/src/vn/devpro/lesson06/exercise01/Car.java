package vn.devpro.lesson06.exercise01;

import java.util.Scanner;

public class Car {
	private String code;
	private String brand;
	private String manufaturer;
	private String style;
	private double price;
	private String origin;

	// Phim tat Alt+Shift+S -> bam O

	public Car(String code, String brand, String manufaturer, String sytle, double price, String origin) {
		super();
		this.code = code;
		this.brand = brand;
		this.manufaturer = manufaturer;
		this.style = sytle;
		this.price = price;
		this.origin = origin;
	}

	public Car() {
		super();
	}

	public void display() {
		System.out.println("\tMa xe: " + this.code);
		System.out.println("\tNhan hieu: " + this.brand);
		System.out.println("\tKieu dang: " + this.style);
		System.out.println("\tHang sx: " + this.manufaturer);
		System.out.println("\tGia tien: " + this.price);
		System.out.println("\tXuat xu: " + this.origin);
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\t\tSUA THONG TIN XE HOI");
			System.out.println("Xin chon thong tin can sua");
			System.out.println("\t1. Sua nhan hieu xe");
			System.out.println("\t2. Sua kieu dang xe");
			System.out.println("\t3. Sua hang san xuat");
			System.out.println("\t4. Sua gia tien");
			System.out.println("\t5. Sua xuat xu");
			System.out.println("\t0. Quay lai");

			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {
			case 1:
				System.out.print("Nhap nhan hieu moi: ");
				this.brand = sc.nextLine();
				break;
			case 2:
				System.out.print("Nhap kieu dang moi: ");
				this.style = sc.nextLine();
				break;
			case 3:
				System.out.print("Nhap hang san xuat moi: ");
				this.manufaturer = sc.nextLine();
				break;
			case 4:
				System.out.print("Nhap gia tien moi: ");
				this.price = Double.parseDouble(sc.nextLine());
				break;
			case 5:
				System.out.print("Nhap xuat xu moi: ");
				this.origin = sc.nextLine();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	// Phim tat Alt+Shift+S -> bam R
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufaturer() {
		return manufaturer;
	}

	public void setManufaturer(String manufaturer) {
		this.manufaturer = manufaturer;
	}

	public String getSytle() {
		return style;
	}

	public void setSytle(String sytle) {
		this.style = sytle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
