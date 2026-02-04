package vn.devpro.lesson06.exercise02;

public class Order {
	private String number;
	private Customer customer;
	private Product[] products;

	public void display() {
		System.out.println("\t\tHOA DON BAN LE");
		this.customer.display();
		System.out.println("Danh sach hang hoa");
		System.out.printf("%-12s %-30s %12s %15s %20s%n", "Ma hang", "Ten hang", "So luong", "Don gia", "Thanh tien");
		for (Product product : products) {
			product.display();
		}

		System.out.printf("\tCong thanh tien: %,.2f%n", this.grandTotal());
	}

	public double grandTotal() {
		double total = 0;
		for (Product product : products) {
			total += product.total();
		}
		return total;
	}

	public void editCustomer() {
		this.customer.edit();
	}

	public void editProduct() {
		System.out.print("\tNhap ma san pham can sua: ");
		String code = BillManagement.sc.nextLine();

		// find product by code
		int index = this.findProductByCode(code);
		if (index == -1) {
			System.out.println("San pham nay khong co trong phieu");
		} else {
			this.products[index].edit();
		}
	}

	public int findProductByCode(String code) {
		for (int index = 0; index < this.products.length; index++) {
			if (this.products[index].getCode().equals(code)) {
				return index;
			}
		}
		return -1;
	}

	public Order() {
		super();
	}

	public Order(String number, Customer customer, Product[] products) {
		super();
		this.number = number;
		this.customer = customer;
		this.products = products;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

}
