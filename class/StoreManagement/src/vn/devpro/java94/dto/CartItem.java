package vn.devpro.java94.dto;

import vn.devpro.java94.model.Product;
import vn.devpro.java94.service.ProductService;

public class CartItem {
	private int productId;
	private int quantity;

	public void display() {
		// Lay product trong db
		Product product = ProductService.getById(productId);
		if (product == null) {
			System.out.println("Loi CSDL");
			return;
		}
		System.out.printf("%-40s %9d %,13.2f %,13.2f%n", product.getName(), this.quantity, product.getPrice(), total());
	}

	public double total() {
		// TODO Auto-generated method stub
		Product product = ProductService.getById(productId);
		if (product == null) {
			return 0;
		}
		return this.quantity * product.getPrice();
	}

	public CartItem() {
		super();
	}

	public CartItem(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
