package vn.devpro.lesson07.TriuTuong.ex2;

import java.util.Scanner;

public class Demo {
	public static Scanner sc = new Scanner(System.in);

	public static void input(Employee[] employees) {
		int choose;
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Chon loai nhan vien (1-NVSX, 2-NVVP)");
			choose = Integer.parseInt(sc.nextLine());
			if (choose == 1) {
				employees[i] = new Worker();
			} else if (choose == 2) {
				employees[i] = new Officer();
			} else {
				System.out.println("Khong hop le, vui long thu lai");
				i--;
				continue; // De bo qua phan code phia duoi
			}
			System.out.println("Nhap nhan vien thu " + (i + 1));
			employees[i].input();
		}
	}

	public static void display(Employee[] employees) {
		System.out.println("\t\tDANH SACH NHAN VIEN");
		System.out.printf("%10s %-25s %6s %10s %-13s%n", "Ma NV", "Ho va ten", "Nam VL", "SP/N.Nghi", "Luong");
		for (Employee employee : employees) {
			employee.display();
		}
	}

	public static double total(Employee[] employees) {
		double sum = 0;
		for (Employee employee : employees) {
			sum += employee.salary();
		}
		return sum;
	}

	public static void main(String[] args) {
		Employee[] employees = new Employee[3];
		input(employees);
		display(employees);
		System.out.println("Tong luong: " + total(employees));
	}
}
