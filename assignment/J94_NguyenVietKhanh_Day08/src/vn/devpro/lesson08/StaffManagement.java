package vn.devpro.lesson08;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		Database.init(staffs);
		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY NHAN SU");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Hien thi danh sach nhan su");
			System.out.println("\t2. Hien thi danh sach cong nhan nam");
			System.out.println("\t3. Hien thi danh sach can bo nu");
			System.out.println("\t4. Hien thi can bo co luong cao nhat");
			System.out.println("\t5. Hien thi cong nhan co luong thap nhat");
			System.out.println("\t6. Hien thi tong luong cua tat ca can bo");
			System.out.println("\t7. Hien thi tong luong cua tat ca cong nhan");
			System.out.println("\t8. Chuyen cac cong nhan xuong cuoi danh sach");
			System.out.println("\t9. Sap xep nhan su theo theo ten");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Database.display(staffs);
				break;
			case 2:
				Database.displayManWorker(staffs);
				break;
			case 3:
				Database.displayWomanManager(staffs);
				break;
			case 4:
				Database.MaxSalaryManager(staffs);
				break;
			case 5:
				Database.MinSalaryWorker(staffs);
				break;
			case 6:
				System.out.printf("Tong luong cua cac can bo la: %,13.2f%n", Database.TotalManager(staffs));
				break;
			case 7:
				System.out.printf("Tong luong cua cac cong nhan la: %,13.2f%n", Database.TotalWorker(staffs));
				break;
			case 8:
				Database.ChangeWorker(staffs);
				Database.display(staffs);
				break;
			case 9:
				Database.sort(staffs);
				Database.display(staffs);
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);

	}
}
