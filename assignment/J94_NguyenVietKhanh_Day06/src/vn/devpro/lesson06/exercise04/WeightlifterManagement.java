package vn.devpro.lesson06.exercise04;

import java.util.Scanner;

public class WeightlifterManagement {
	public static void sortByResult(Weightlifter[] weightlifters) {
		for (int i = 0; i < weightlifters.length; i++) {
			for (int j = weightlifters.length - 1; j > i; j--) {
				if (weightlifters[j].getResult() > weightlifters[j - 1].getResult()) {
					Weightlifter tmp = weightlifters[j];
					weightlifters[j] = weightlifters[j - 1];
					weightlifters[j - 1] = tmp;
				}
			}
		}
	}

	public static void sortByName(Weightlifter[] weightlifters) {
		for (int i = 0; i < weightlifters.length; i++) {
			for (int j = weightlifters.length - 1; j > i; j--) {
				if (weightlifters[j].getName().compareTo(weightlifters[j - 1].getName()) < 0) {
					Weightlifter tmp = weightlifters[j];
					weightlifters[j] = weightlifters[j - 1];
					weightlifters[j - 1] = tmp;
				}
			}
		}
	}

	public static void sortByLenghth(Weightlifter[] weightlifters) {
		for (int i = 0; i < weightlifters.length; i++) {
			for (int j = weightlifters.length - 1; j > i; j--) {
				if (weightlifters[j].getName().length() < weightlifters[j - 1].getName().length()) {
					Weightlifter tmp = weightlifters[j];
					weightlifters[j] = weightlifters[j - 1];
					weightlifters[j - 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Weightlifter[] weightlifters = new Weightlifter[10];

		weightlifters[0] = new Weightlifter("Mai", 99, 100, 98);
		weightlifters[1] = new Weightlifter("Phuong", 90, 95, 93);
		weightlifters[2] = new Weightlifter("Thuy", 56, 68, 67);
		weightlifters[3] = new Weightlifter("Ha", 105, 106, 107);
		weightlifters[4] = new Weightlifter("Trinh", 58, 68, 60);
		weightlifters[5] = new Weightlifter("Van", 90, 99, 98);
		weightlifters[6] = new Weightlifter("Khac", 86, 89, 89);
		weightlifters[7] = new Weightlifter("Huong", 99, 100, 98);
		weightlifters[8] = new Weightlifter("Dinh", 66, 69, 71);
		weightlifters[9] = new Weightlifter("Sach", 88, 90, 89);

		do {
			System.out.println("\t\tCHUONG TRINH QUAN LY VDV CU TA");
			System.out.println("Moi chon chuc nang");
			System.out.println("\t1. Hien thi danh sach VDV");
			System.out.println("\t2. Hien thi VDV co tong cu cao nhat");
			System.out.println("\t3. Hien thi 3 VDV co tong cu cao nhat");
			System.out.println("\t4. Hien thi VDV co ten bat dau bang chu 'T'");
			System.out.println("\t5. Hien thi VDV ma ten co van 'an'");
			System.out.println("\t6. Hien thi danh sach VDV theo thu tu tu dien");
			System.out.println("\t7. Hien thi danh sach VDV theo theo chieu dai cua ten");
			System.out.println("\t8. Hien thi VDV co cung tong thanh tich va xep thu 2");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int choose = Integer.parseInt(sc.nextLine());
			Weightlifter[] newWeightlifters = weightlifters.clone();
			switch (choose) {
			case 1:
				System.out.printf("%-10s %10s %10s %10s %10s%n", "Ten", "Lan 1", "Lan 2", "Lan 3", "Tong");
				for (Weightlifter weightlifter : weightlifters) {
					weightlifter.display();
				}
				break;
			case 2:
				sortByResult(newWeightlifters);
				System.out.printf("%-10s %10s %10s %10s %10s%n", "Ten", "Lan 1", "Lan 2", "Lan 3", "Tong");
				newWeightlifters[0].display();
				break;
			case 3:
				sortByResult(newWeightlifters);
				System.out.printf("%-10s %10s %10s %10s %10s%n", "Ten", "Lan 1", "Lan 2", "Lan 3", "Tong");
				newWeightlifters[0].display();
				newWeightlifters[1].display();
				newWeightlifters[2].display();
				break;
			case 4:
				for (Weightlifter weightlifter : weightlifters) {
					if (weightlifter.getName().startsWith("T")) {
						weightlifter.display();
					}
				}
				break;
			case 5:
				for (Weightlifter weightlifter : weightlifters) {
					if (weightlifter.getName().contains("an")) {
						weightlifter.display();
					}
				}
				break;
			case 6:
				sortByName(newWeightlifters);
				for (Weightlifter weightlifter : newWeightlifters) {
					weightlifter.display();
				}
				break;
			case 7:
				sortByLenghth(newWeightlifters);
				for (Weightlifter weightlifter : newWeightlifters) {
					weightlifter.display();
				}
				break;
			case 8:
				sortByResult(newWeightlifters);
				double Max = newWeightlifters[0].getResult();
				int index = 0;
				while (newWeightlifters[index].getResult() == Max) {
					index++;
				}
				double max2 = newWeightlifters[index].getResult();
				System.out.printf("%-10s %10s %10s %10s %10s%n", "Ten", "Lan 1", "Lan 2", "Lan 3", "Tong");
				while (newWeightlifters[index].getResult() == max2) {
					newWeightlifters[index].display();
					index++;
				}

				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le, vui long chon lai");
			}
		} while (true);
	}

}
