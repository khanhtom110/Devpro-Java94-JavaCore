package vn.devpro.lesson09.model;

public class Product {
	private int id;
	private int categoryId;
	private String code;
	private String name;
	private double price;

	public void display() {
		System.out.printf("%3d %3d %17s %-25s %,13.2f%n", this.id, this.categoryId, this.code, this.name, this.price);
	}

	public Product() {
		super();
	}

	public Product(int id, int categoryId, String code, String name, double price) {
		super();
		this.id = id;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
