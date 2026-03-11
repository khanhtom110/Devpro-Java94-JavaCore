package vn.devpro.java94.model;

public class OrderProduct {
	private int id;
	private int productId;
	private int orderId;
	private int quantity;
	private double price;
	private String name;

	public void display() {
		System.out.printf("%-40s %9d %,13.2f %,15.2f%n", name, quantity, price, totalPrice());
	}

	private double totalPrice() {
		// TODO Auto-generated method stub
		return quantity * price;
	}

	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, int productId, int orderId, int quantity, double price, String name) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
