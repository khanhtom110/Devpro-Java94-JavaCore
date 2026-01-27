package vn.devpro.lesson03.exercise02;

import java.util.Scanner;

public class MainProblem {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			System.out.println("CHUONG TRINH GIAI QUYET CAC BAI TOAN");
			System.out.println("Bai toan 1 - Nhap phim 1 de giai quyet");
			System.out.println("Bai toan 2 - Nhap phim 2 de giai quyet");
			System.out.println("Bai toan 3 - Nhap phim 3 de giai quyet");
			System.out.println("Bai toan 4 - Nhap phim 4 de giai quyet");
			System.out.println("Bai toan 5 - Nhap phim 5 de giai quyet");
			System.out.println("De huy chuong trinh, bam phim 0");
			System.out.print("Lua chon cua ban la: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("Bai toan 1: ");
				SubProblem01.display();
				break;
			}
			case 2: {
				System.out.println("Bai toan 2: ");
				SubProblem02.display();
				break;
			}
			case 3: {
				System.out.println("Bai toan 3: ");
				SubProblem03.display();
				break;
			}
			case 4: {
				System.out.println("Bai toan 4: ");
				SubProblem04.display();
				break;
			}
			case 5: {
				System.out.println("Bai toan 5: ");
				SubProblem05.display();
				break;
			}
			case 0: {
				System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			}
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}
}
