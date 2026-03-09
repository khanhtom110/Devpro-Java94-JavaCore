package vn.devpro.lesson09.model;

public class Order {
	private int id;
	private int customerId;
	private String code;
	private double total;

	public void display() {
		System.out.printf("%3d %3d %17s %,13.2f%n", this.id, this.customerId, this.code, this.total);
	}

	public Order() {
		super();
	}

	public Order(int id, int customerId, String code, double total) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.code = code;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
