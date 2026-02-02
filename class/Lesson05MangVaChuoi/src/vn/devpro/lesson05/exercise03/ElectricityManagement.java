package vn.devpro.lesson05.exercise03;

import java.util.Scanner;

public class ElectricityManagement {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String[] gd = { "Tran Duc Bo", "Hieu Thu Hai", "Le Bao Binh", "Vu Tien Bip", "Giang Trung Hai",
				"Nguyen Bich Ngoc", "Dang Trung Hieu", "Ma Van Hoang", "Bui Thuy Duong", "Giang Le Hoang",
				"Nguyen Van Tuan Anh", "Dam Manh Dat" };

		double[] kw = { 123, 321, 357, 968, 136, 336, 684, 125, 359, 268, 784, 584 };

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY TIEN DIEN");
			System.out.println("\tLua chon chuc nang can thuc hien");
			System.out.println("\t1. Hien thi danh sach");
			System.out.println("\t2. 3 GD tieu thu nhieu nhat");
			System.out.println("\t3. Ho GD co chu ho la 'Truong'");
			System.out.println("\t4. Sap xep theo ten chu ho");
			System.out.println("\t5. Sap xep theo so KWh dien tang dan");
			System.out.println("\tThoat, bam phim 0");

			System.out.print("Vui long chon chuc nang: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				displayAll(gd, kw);
				break;
			case 2:
				display3Max(gd, kw);
				break;
			case 3:
				displayTruong(gd, kw);
				break;
			case 4:
				// SubProblem04.display();
				break;
			case 5:
				// SubProblem05.display();
				break;
			case 0:
				System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon chua hop le, xin chon lai");
			}
		} while (true);
	}

	// Tinh tien dien cho cac ho gia dinh
	public static double payment(double k) {
		if (k <= 50) {
			return k * 1984;
		} else if (k <= 100) {
			return k * 1984 + (k - 50) * 2050;
		} else if (k <= 200) {
			return k * 1984 + 50 * 2050 + (k - 100) * 2380;
		} else if (k <= 300) {
			return k * 1984 + 50 * 2050 + 100 * 2380 + (k - 200) * 2998;
		} else if (k <= 400) {
			return k * 1984 + 50 * 2050 + 100 * 2380 + 200 * 2998 + (k - 300) * 3350;
		} else {
			return k * 1984 + 50 * 2050 + 100 * 2380 + 200 * 2998 + 300 * 3350 + (k - 400) * 3460;
		}
	}

	// Hien thi dong tieu de
	public static void title() {
		System.out.printf("%3s %-25s %-10s %-15s%n", "STT", "Ho gia dinh", "So KWh tieu thu", "Thanh tien");
	}

	public static void displayAll(String gd[], double[] kw) {
		System.out.println("\t\tDANH SACH THU TIEN DIEN THANG 01 - 2026");
		for (int i = 0; i < gd.length; i++) {
			System.out.printf("%3d %-25s %,10.1f %,15.2f%n", i + 1, gd[i], kw[i], payment(kw[i]));
		}
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	// 3 gia dinh tieu thu nhieu nhat
	public static void display3Max(String[] gd, double[] kw) {
		String[] g = gd.clone();
		double[] k = kw.clone();
		sortByKWh(g, k);
		System.out.println("\t\t3 GIA DINH TIEU THU NHIEU NHAT");
		title();
		for (int i = g.length - 1, count = 0; i >= 0 && count < 3; i--, count++) {
			System.out.printf("%3d %-25s %,10.1f %,15.2f%n", i + 1, g[i], k[i], payment(k[i]));
		}
	}

	// Sap xep danh sach theo chieu tang dan
	public static void swap(String[] gd, double[] kw, int i, int j) {
		String tmp = gd[i];
		gd[i] = gd[j];
		gd[j] = tmp;

		double tg = kw[i];
		kw[i] = kw[j];
		kw[j] = tg;
	}

	public static void sortByKWh(String[] gd, double[] kw) {
		for (int i = 1; i < gd.length; i++) {
			for (int j = kw.length - 1; j >= i; j--) {
				if (kw[j - 1] > kw[j]) {
					swap(gd, kw, i, j);
				}
			}
		}
	}

	// gia dinh ten 'truong'
	public static void displayTruong(String[] gd, double[] kw) {
		System.out.println("\t\t3 GIA DINH TEN 'TRUONG'");
		title();
		int count = 0;
		for (int i = 0; i < gd.length; i++) {
			if (getName(gd[i]).equalsIgnoreCase("Truong"))
				System.out.printf("%3d %-25s %,10.1f %,15.2f%n", count + 1, gd[i], kw[i], payment(kw[i]));
			count++;
		}
		if (count == 0) {
			System.out.println("Khong co gia dinh nao");
		}
	}

	public static String getName(String fullname) {
		int index = fullname.trim().lastIndexOf(' ');
		if (index == -1) {
			return fullname;
		}
		return fullname.trim().substring(index + 1);
	}

	public static void sortByName(String[] gd, double[] kw) {
		for (int i = 1; i < gd.length; i++) {
			for (int j = kw.length - 1; j >= i; j--) {
				if (getName(gd[j - 1]).compareToIgnoreCase(getName(gd[j])) > 0) {
					swap(gd, kw, j - 1, j);
				}
			}
		}
	}
}
