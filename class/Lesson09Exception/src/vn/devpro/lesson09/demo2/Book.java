package vn.devpro.lesson09.demo2;

public class Book {
	private String name;
	private int amount;

	public Book() {
		super();
	}

	public Book(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
