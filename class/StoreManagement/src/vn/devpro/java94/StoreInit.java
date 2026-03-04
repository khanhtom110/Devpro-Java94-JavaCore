package vn.devpro.java94;

import java.util.Scanner;

public class StoreInit {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY BAN HANG");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Chuc nang nguoi quan tri");
			System.out.println("\t2. Khach mua hang");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				break;
			case 2:
				break;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

}
