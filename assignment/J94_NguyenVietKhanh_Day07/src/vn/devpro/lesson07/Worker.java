package vn.devpro.lesson07;

import java.util.Scanner;

public class Worker extends Employee {
	private Job job;
	private double levelOfSalary;
	private double workingDays;
	private double salary;

	public Worker() {
		super();
	}

	public Worker(String code, String firstName, String lastName, Date dateOfBirth, Job job, double levelOfSalary,
			double workingDays) {
		super(code, firstName, lastName, dateOfBirth);
		this.job = job;
		this.levelOfSalary = levelOfSalary;
		this.workingDays = workingDays;
		setSalary();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public double getLevelOfSalary() {
		return levelOfSalary;
	}

	public void setLevelOfSalary(double levelOfSalary) {
		this.levelOfSalary = levelOfSalary;
	}

	public double getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(double workingDays) {
		this.workingDays = workingDays;
	}

	static Scanner sc = new Scanner(System.in);

	public void input() {
		super.input();
		job = new Job();
		job.input();
		System.out.print("\tNhap bac luong: ");
		this.levelOfSalary = Double.parseDouble(sc.nextLine());
		System.out.print("\tNhap so ngay lam viec: ");
		this.workingDays = Double.parseDouble(sc.nextLine());
	}

	public void setSalary() {
		this.salary = this.levelOfSalary * 3500000 + this.workingDays * 60000;
	}

	public double getSalary() {
		return this.salary;
	}

	public void display() {
		super.display();
		System.out.printf("  %9.0f %,13.0f%n", this.workingDays, this.getSalary());
	}
}
