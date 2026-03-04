package vn.devpro.lesson07;

import java.util.Scanner;

public class Employee {
	protected String code;
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;

	public Employee() {
		super();
	}

	public Employee(String code, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	static Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("\tNhap ma nhan su: ");
		this.code = sc.nextLine();
		System.out.print("\tNhap ho dem: ");
		this.firstName = sc.nextLine();
		System.out.print("\tNhap ten: ");
		this.lastName = sc.nextLine();
		dateOfBirth = new Date();
		dateOfBirth.input();
	}

	public void display() {
		System.out.printf("%5s %-24s  ", this.code, this.firstName + " " + this.lastName, this.lastName);
		this.dateOfBirth.display();
	}
}
