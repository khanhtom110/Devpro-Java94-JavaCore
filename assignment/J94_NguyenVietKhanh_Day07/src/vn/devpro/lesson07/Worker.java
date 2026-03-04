package vn.devpro.lesson07;

import java.util.Scanner;

public class Worker extends Employee {

	private String jobCode;
	private double levelOfSalary;
	private double workingDays;
	// private double salary;

	public Worker() {
		super();
	}

	public Worker(String code, String firstName, String lastName, Date dateOfBirth, String jobCode,
			double levelOfSalary, double workingDays) {
		super(code, firstName, lastName, dateOfBirth);
		this.jobCode = jobCode;
		this.levelOfSalary = levelOfSalary;
		this.workingDays = workingDays;
	}

	public double getLevelOfSalary() {
		return levelOfSalary;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
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

	public double salary() {
		return this.levelOfSalary * 3500000 + this.workingDays * 60000;
	}

	static Scanner sc = new Scanner(System.in);

//	public void input() {
//		super.input();
//		job = new Job();
//		job.input();
//		System.out.print("\tNhap bac luong: ");
//		this.levelOfSalary = Double.parseDouble(sc.nextLine());
//		System.out.print("\tNhap so ngay lam viec: ");
//		this.workingDays = Double.parseDouble(sc.nextLine());
//	}

	public void display() {
		super.display();
		String jobName = "";
		// Lay job cua worker
		Job job = Db.findJobByCode(this.jobCode);
		if (job != null) {
			jobName = job.getName();
		}
		System.out.printf("%-20s %9.2f %,13.2f%n", jobName, this.workingDays, this.salary());
	}
}
