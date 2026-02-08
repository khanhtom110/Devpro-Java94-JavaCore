package vn.devpro.lesson06.exercise03;

import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mark mark = new Mark(new Student("2023001", "Nguyen Van A", "20/11/2005", "Cong nghe thong tin"),
				new Subject[] { new Subject("050127", "Lap trinh huong doi tuong", 3, 7.5),
						new Subject("050128", "Ky thuat lap trinh", 3, 5.5),
						new Subject("050129", "Lap trinh Java", 3, 8), new Subject("050130", "Mang may tinh", 3, 6.9),
						new Subject("050131", "Co so du lieu", 4, 9), new Subject("050132", "Thiet Ke Web", 3, 5),
						new Subject("050133", "Triet Hoc", 3, 4.5) });
		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY SINH VIEN");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Hien thi bang diem ca nhan");
			System.out.println("\t2. Hien thi cac hoc phan co diem < 6.0");
			System.out.println("\t3. Sua thong tin sinh vien");
			System.out.println("\t4. Sua thong tin bang diem");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				mark.display();
				break;
			case 2:
				mark.customDisplay();
				break;
			case 3:
				mark.editStudent();
				break;
			case 4:
				mark.editSubject();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

}
