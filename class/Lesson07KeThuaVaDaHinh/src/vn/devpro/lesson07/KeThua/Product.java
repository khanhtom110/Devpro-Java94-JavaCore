package vn.devpro.lesson07.KeThua;

import java.util.Scanner;

public class Product {
	protected String code;
	protected String name;
	protected String date;

	Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("\tNhap ma san pham: ");
		this.code = sc.nextLine();
		System.out.print("\tNhap ten san pham: ");
		this.name = sc.nextLine();
		System.out.print("\tNhap ngay san xuat: ");
		this.date = sc.nextLine();
	}

	public Product() {
		super();
	}

	public Product(String code, String name, String date) {
		super();
		this.code = code;
		this.name = name;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
