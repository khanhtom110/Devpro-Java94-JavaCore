package vn.devpro.lesson06.exercise01;

import java.util.Scanner;

public class CarManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Car car = new Car("1001", "Vios", "Toyota", "Sedan", 22000, "VietNam");

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY XE HOI");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Hien thi thong tin xe");
			System.out.println("\t2. Sua thong tin xe");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				car.display();
				break;
			case 2:
				car.edit();
				break;
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}
}
