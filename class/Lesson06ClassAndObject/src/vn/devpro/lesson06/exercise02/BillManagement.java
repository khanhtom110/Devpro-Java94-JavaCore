package vn.devpro.lesson06.exercise02;

import java.util.Scanner;

public class BillManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Order order = new Order("1", new Customer("Nguyen Van A", "0987654321", "Ha Noi"),
				new Product[] { new Product("1000", "Iphone 17 Promax", 20, 37000000),
						new Product("1001", "Iphone 15 Promax", 90, 25000000),
						new Product("1002", "Iphone 12 Promax", 50, 9000000),
						new Product("1003", "Iphone 13 Promax", 200, 22000000),
						new Product("1004", "Iphone 16 Promax", 100, 32000000), });

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY BAN HANG");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Hien thi thong tin phieu");
			System.out.println("\t2. Sua thong tin khach hang");
			System.out.println("\t3. Sua thong tin hang hoa");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				order.display();
				break;
			case 2:
				order.editCustomer();
				break;
			case 3:
				order.editProduct();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}
}
