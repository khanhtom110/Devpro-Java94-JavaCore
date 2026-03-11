package vn.devpro.java94.model;

public class Customer {
	private int id;
	private String code;
	private String name;

	public void display() {
		System.out.printf("%3d %17s %-30s%n", this.id, this.code, this.name);
	}

	public Customer() {
		super();
	}

	public Customer(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
