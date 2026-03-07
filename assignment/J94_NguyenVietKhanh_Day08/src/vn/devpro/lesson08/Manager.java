package vn.devpro.lesson08;

public class Manager extends Staff implements Salary {
	private String department;
	private String role;
	private double levelOfSalary;
	private String rank;

	public void display() {
		super.display();
		System.out.printf("%-20s %-25s %21.1f %,13.2f%n", this.department, this.role, this.levelOfSalary,
				this.salary());
	}

	@Override
	public double salary() {
		if (this.rank.equals("A")) {
			return this.levelOfSalary * 1150000 + 1000000;
		} else if (this.rank.equals("B")) {
			return this.levelOfSalary * 1150000;
		} else if (this.rank.equals("C")) {
			return this.levelOfSalary * 1150000 - 400000;
		} else {
			return this.levelOfSalary * 1150000 - 1000000;
		}
	}

	public Manager() {
		super();
	}

	public Manager(String id, String firstName, String lastName, int yearOfBirth, String gender, String department,
			String role, double levelOfSalary, String rank) {
		super(id, firstName, lastName, yearOfBirth, gender);
		this.department = department;
		this.role = role;
		this.levelOfSalary = levelOfSalary;
		this.rank = rank;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getLevelOfSalary() {
		return levelOfSalary;
	}

	public void setLevelOfSalary(double levelOfSalary) {
		this.levelOfSalary = levelOfSalary;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
