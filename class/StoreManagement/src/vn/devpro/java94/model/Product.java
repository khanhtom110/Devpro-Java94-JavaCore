package vn.devpro.java94.model;

public class Product {
	private int id;
	private int providerId;
	private String code;
	private String name;
	private double price;

	public void display() {
		// Lay provider
		System.out.printf("%3d %30s %12s %-35s %,13.2d%n", this.id, "Ten NCC", this.code, this.name, this.price);
	}

	public Product() {
		super();
	}

	public Product(int id, int providerId, String code, String name, double price) {
		super();
		this.id = id;
		this.providerId = providerId;
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
