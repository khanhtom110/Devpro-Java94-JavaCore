package vn.devpro.java94.model;

import java.time.LocalDate;

import vn.devpro.java94.service.CustomerService;

public class Order {
	private int id;
	private int customerId;
	private LocalDate createDate;
	private String status;
	private double totalPrice;

	public void display() {
		String customerName = "Khach vang lai";
		if (customerId > 0) {
			customerName = CustomerService.getById(customerId).getName();
		}
		System.out.printf("%-25s %10s %-50s %,15.2f%n", customerName, createDate, status, totalPrice);
	}

	public Order() {
		super();
	}

	public Order(int id, int customerId, LocalDate createDate, String status, double totalPrice) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.createDate = createDate;
		this.status = status;
		this.totalPrice = totalPrice;
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

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
