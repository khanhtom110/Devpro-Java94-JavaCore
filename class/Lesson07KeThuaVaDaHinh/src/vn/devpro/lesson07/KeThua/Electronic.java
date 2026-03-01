package vn.devpro.lesson07.KeThua;

import java.util.Scanner;

public class Electronic extends Product {
	private double power;
	private double price;

	Scanner sc = new Scanner(System.in);

	public void input() {
		// Su dung lai phuong thuc nhap cua lop cha
		super.input();
		System.out.print("Nhap cong suat: ");
		this.power = Double.parseDouble(sc.nextLine());
		System.out.print("Nhap gia tien: ");
		this.price = Double.parseDouble(sc.nextLine());
	}

	public void output() {
		// Co the dung this.code do da ke thua tu lop cha nen co the su dung cac thuoc
		// tinh, this. cung oke luon:))))
		System.out.printf("%-12s %-30s %10s %9.1f %,13.2f%n", this.code, this.name, this.date, this.power, this.price);
	}

	public Electronic() {
		super();
	}

	// Phai bam chon generate ca cac doi so cua class cha
	public Electronic(String code, String name, String date, double power, double price, Scanner sc) {
		super(code, name, date);
		this.power = power;
		this.price = price;
		this.sc = sc;
	}

	public double getCongSuat() {
		return power;
	}

	public void setCongSuat(double congSuat) {
		this.power = congSuat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
