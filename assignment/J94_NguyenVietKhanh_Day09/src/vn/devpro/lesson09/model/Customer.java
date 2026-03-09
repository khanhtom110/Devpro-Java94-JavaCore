package vn.devpro.lesson09.model;

public class Customer {
	private int id;
	private String code;
	private String name;
	private String mobile;

	public void display() {
		System.out.printf("%3d %17s %-25s %10s%n", this.id, this.code, this.name, this.mobile);
	}

	public Customer() {
		super();
	}

	public Customer(int id, String code, String name, String mobile) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.mobile = mobile;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
