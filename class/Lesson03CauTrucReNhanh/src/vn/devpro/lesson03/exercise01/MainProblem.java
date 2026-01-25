package vn.devpro.lesson03.exercise01;

import java.util.Scanner;

public class MainProblem {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			System.out.println("\t\tCHUONG TRINH GIAI QUYET CAC BAI TOAN");
			System.out.println("\tLua chon bai toan can giai bang cach bam phim");
			System.out.println("\tGiai bai toan 1, bam phim 1");
			System.out.println("\tGiai bai toan 2, bam phim 2");
			System.out.println("\tGiai bai toan 3, bam phim 3");
			System.out.println("\tGiai bai toan 4, bam phim 4");
			System.out.println("\tGiai bai toan 5, bam phim 5");
			System.out.println("\tThoat khoi chuong trinh, bam phim 0");

			System.out.print("Vui long chon bai toan can giai: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				System.out.println("Giai bai toan 1:");
				SubProblem01.display();
				break;
			case 2:
				System.out.println("Giai bai toan 2:");
				SubProblem02.display();
				break;
			case 3:
				System.out.println("Giai bai toan 3:");
				SubProblem03.display();
				break;
			case 4:
				System.out.println("Giai bai toan 4:");
				SubProblem04.display();
				break;
			case 5:
				System.out.println("Giai bai toan 5:");
				SubProblem05.display();
				break;
			case 0:
				System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon chua hop le, xin chon lai");
			}
		} while (true);
	}
}
