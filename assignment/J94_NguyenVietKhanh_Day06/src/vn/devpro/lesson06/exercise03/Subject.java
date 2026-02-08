package vn.devpro.lesson06.exercise03;

import java.util.Scanner;

public class Subject {
	private String id;
	private String name;
	private double credit;
	private double mark;

	public Subject() {
		super();
	}

	public Subject(String id, String name, double credit, double mark) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.mark = mark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\t\tSUA THONG TIN HOC PHAN");
			System.out.println("\t1. Sua ten hoc phan");
			System.out.println("\t2. Sua so tin chi");
			System.out.println("\t3. Sua diem hoc phan");
			System.out.println("\t0. Quay lai");
			System.out.print("\tLua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				System.out.print("\tNhap ten hoc phan moi: ");
				this.name = sc.nextLine();
				break;
			case 2:
				System.out.print("\tNhap so tin chi moi: ");
				this.credit = Double.parseDouble(sc.nextLine());
				break;
			case 3:
				System.out.print("\tNhap diem hoc phan moi: ");
				this.mark = Double.parseDouble(sc.nextLine());
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	public void display() {
		System.out.printf("%-12s %-25s %15.1f %15.2f%n", this.id, this.name, this.credit, this.mark);
	}
}
