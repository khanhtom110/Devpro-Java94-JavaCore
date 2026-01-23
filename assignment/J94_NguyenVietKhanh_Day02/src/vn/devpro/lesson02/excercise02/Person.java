package vn.devpro.lesson02.excercise02;

import java.util.Scanner;

public class Person {
	String id;
	String firstName;
	String lastName;
	String dateOfBirth;
	String gender;
	String address;
	String phone;

	public static Person input() {
		Person person = new Person();
		Scanner sc = new Scanner(System.in);
		System.out.print("So the can cuoc: ");
		person.id = sc.nextLine();
		System.out.print("Ho dem: ");
		person.firstName = sc.nextLine();
		System.out.print("Ten: ");
		person.lastName = sc.nextLine();
		System.out.print("Ngay sinh: ");
		person.dateOfBirth = sc.nextLine();
		System.out.print("Gioi tinh: ");
		person.gender = sc.nextLine();
		System.out.print("Dia chi: ");
		person.address = sc.nextLine();
		System.out.print("So dien thoai: ");
		person.phone = sc.nextLine();
		return person;
	}

	public static void display(Person person) {
		System.out.printf("%-15s %-15s %-12s %-9s %-25s %-10s%n", person.id, person.firstName + " " + person.lastName,
				person.dateOfBirth, person.gender, person.address, person.phone);
	}
}
