package vn.devpro.lesson05.exercise02;

import java.util.Scanner;

public class WordManagement {

	public static Scanner sc = new Scanner(System.in);

	public static int input(String var) {
		int n = 0;
		do {
			try {
				System.out.print("Nhap " + var + ": ");
				n = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Yeu cau nhap so nguyen duong");
			}
		} while (n <= 0);
		return n;
	}

	public static String input() {
		System.out.print("Nhap tu can kiem tra: ");
		return sc.nextLine();
	}

	public static void init(String[] words) {
		for (int i = 0; i < words.length; i++) {
			System.out.print("\tNhap tu tieng anh thu " + (i + 1) + ": ");
			words[i] = sc.nextLine();
		}
	}

	public static int findByWord(String[] words, String s) {
		int index = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].compareTo(s) == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void swap(String[] words, int i, int j) {
		String tmp = words[i];
		words[i] = words[j];
		words[j] = tmp;
	}

	public static void sort(String[] words) {
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = words.length - 1; j > i; j--) {
				if (words[j - 1].compareTo(words[j]) > 0) {
					swap(words, j - 1, j);
				}
			}
		}
	}

	public static void display(String[] words) {
		for (int i = 0; i < words.length; i++) {
			System.out.println("\t" + (i + 1) + ". " + words[i]);
		}
	}

	public static void main(String[] args) {
		int n = input("n");
		String[] words = new String[n];
		init(words);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\t\tDANH SACH TU TIENG ANH");
		display(words);

		String str = input();
		boolean res = findByWord(words, str) == -1 ? false : true;
		if (res) {
			System.out.println("Tu vua nhap co trong danh sach");
		} else {
			System.out.println("Tu vua nhap khong co trong danh sach");
		}

		String[] newWords = words.clone();
		sort(newWords);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\t\tDANH SACH SAP XEP THEO TU DIEN");
		display(newWords);
	}
}
