package vn.devpro.lesson07.TriuTuong.ex2;

public class Worker extends Employee {
	private int product;

	public Worker(String code, String name, int year, int product) {
		super(code, name, year);
		this.product = product;
	}

	public Worker() {
		super();
	}

	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return product * 50000 + bonus();
	}

	public void input() {
		super.input();
		System.out.print("\tNhap so san pham lam duoc: ");
		this.product = Integer.parseInt(sc.nextLine());
	}

	public void display() {
		super.display();
		System.out.printf("%10d %,13.2f%n", this.product, this.salary());
	}

}
