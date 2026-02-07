package vn.devpro.lesson06.exercise03;

import java.util.Scanner;

public class Student {
	private String id;
	private String fullName;
	private String dateOfBirth;
	private String major;

	public Student() {
		super();
	}

	public Student(String id, String fullName, String dateOfBirth, String major) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\t\tSUA THONG TIN SINH VIEN");
			System.out.println("\tChon thong tin can sua");
			System.out.println("\t1. Sua ho ten");
			System.out.println("\t2. Sua ngay sinh");
			System.out.println("\t3. Sua nganh hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("\tLua chon cua ban la: ");

			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				System.out.print("\tNhap ho ten moi: ");
				this.fullName = sc.nextLine();
				break;
			case 2:
				System.out.print("\tNhap ngay sinh moi: ");
				this.dateOfBirth = sc.nextLine();
				break;
			case 3:
				System.out.print("\tNhap nganh hoc moi: ");
				this.major = sc.nextLine();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

	public void display() {
		System.out.printf("Ma sinh vien: %25s Ho va ten: %s%n", this.id, this.fullName);
		System.out.printf("Ngay sinh: %29s Nganh: %s%n", this.major);
	}
}
