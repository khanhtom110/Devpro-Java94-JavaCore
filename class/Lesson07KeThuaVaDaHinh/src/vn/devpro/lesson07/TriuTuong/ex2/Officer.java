package vn.devpro.lesson07.TriuTuong.ex2;

public class Officer extends Employee {
	private double salary;
	// Co truong hop nghi nua ngay
	private double dateOfRest;

	public Officer() {
		super();
	}

	public Officer(String code, String name, int year, double salary, double dateOfRest) {
		super(code, name, year);
		this.salary = salary;
		this.dateOfRest = dateOfRest;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getDateOfRest() {
		return dateOfRest;
	}

	public void setDateOfRest(int dateOfRest) {
		this.dateOfRest = dateOfRest;
	}

	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return this.salary - this.dateOfRest * 35000 + this.bonus();
	}

	public void input() {
		super.input();
		System.out.print("\tMuc luong: ");
		this.salary = Double.parseDouble(sc.nextLine());
		System.out.print("\tSo ngay nghi: ");
		this.dateOfRest = Double.parseDouble(sc.nextLine());
	}

	public void display() {
		super.display();
		System.out.printf("%10.1f %,13.2f%n", this.dateOfRest, this.salary());
	}

}
