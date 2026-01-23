package vn.devpro.lesson02.excercise03;

import java.util.Scanner;

public class Subject {
	String code;
	String name;
	double credit;
	double mark;

	public static Subject input() {
		Scanner sc = new Scanner(System.in);
		Subject subject = new Subject();
		System.out.print("Ma mon hoc: ");
		subject.code = sc.nextLine();
		System.out.print("Ten mon hoc: ");
		subject.name = sc.nextLine();
		System.out.print("He so: ");
		subject.credit = sc.nextDouble();
		System.out.print("Diem so: ");
		subject.mark = sc.nextDouble();
		return subject;
	}

	public static void display(Subject subject) {
		System.out.printf("%-15s %-25s %-12.1f %-5.2f%n", subject.code, subject.name, subject.credit, subject.mark);
	}
}
