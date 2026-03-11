package vn.devpro.java94.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.java94.model.Product;
import vn.devpro.java94.service.ProductService;

public class Cart {
	Scanner sc = new Scanner(System.in);

	List<CartItem> cartItems = new ArrayList<CartItem>();

	// Xem gio hang
	public void display() {
		System.out.println("\t\tGIO HANG CUA BAN");
		System.out.println("\tGio hang co tong cong: " + this.totalCartItem() + " san pham");
		System.out.println("\tDANH SACH SAN PHAM");
		System.out.printf("%-40s %9s %13s %13s%n", "Ten SP", "So luong", "Don gia", "Thanh tien");
		for (CartItem cartItem : cartItems) {
			cartItem.display();
		}
		System.out.printf("\tCong thanh tien: %,.2f%n", this.grandTotal());
	}

	private int totalCartItem() {
		// TODO Auto-generated method stub
		int total = 0;
		for (CartItem cartItem : cartItems) {
			total += cartItem.getQuantity();
		}
		return total;
	}

	private double grandTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		for (CartItem cartItem : cartItems) {
			total += cartItem.total();
		}
		return total;
	}

	public void add() {
		System.out.println("\t\tTHEM HANG VAO GIO");
		System.out.print("\tChon san pham (nhap ma sp): ");
		String code = sc.nextLine();
		Product product = ProductService.getByCode(code);
		if (product == null) {
			System.out.println("SP tam het hang");
			return;
		}
		System.out.print("\tNhap so luong: ");
		int quantity = Integer.parseInt(sc.nextLine());
		if (quantity <= 0) {
			System.out.println("So luong khong hop le");
			return;
		}

		// Tim xem SP da co trong gio hang chua
		int index = findById(product.getId());
		if (index == -1) {
			// SP chua co trong gio -> Them moi SP vao gio hang
			cartItems.add(new CartItem(product.getId(), quantity));
		} else {
			// SP da co trong gio hang -> Cap nhat so luong moi
			int currentQuantity = cartItems.get(index).getQuantity();
			cartItems.get(index).setQuantity(currentQuantity + quantity);
		}
		System.out.println("\tDa them SP vao gio thanh cong!");
	}

	private int findById(int productId) {
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getProductId() == productId) {
				return i;
			}
		}
		return -1;
	}

	public void edit() {
		System.out.println("\t\tSUA HANG VAO GIO");
		System.out.print("\tChon san pham (nhap ma sp): ");
		String code = sc.nextLine();
		Product product = ProductService.getByCode(code);
		if (product == null) {
			System.out.println("SP khong ton tai");
			return;
		}
		System.out.print("\tNhap so luong khac: ");
		int quantity = Integer.parseInt(sc.nextLine());
		if (quantity <= 0) {
			System.out.println("So luong khong hop le");
			return;
		}

		// Tim xem SP da co trong gio hang chua
		int index = findById(product.getId());
		if (index == -1) {
			System.out.println("SP khong co trong gio");
		}
		cartItems.get(index).setQuantity(quantity);
		System.out.println("Da thay doi so luong thanh cong!");
	}

	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("\t\tXOA HANG TRONG GIO");
		System.out.print("\tChon san pham (nhap ma sp): ");
		String code = sc.nextLine();
		Product product = ProductService.getByCode(code);
		if (product == null) {
			System.out.println("SP khong ton tai");
			return;
		}
		int index = findById(product.getId());
		cartItems.remove(index);
		System.out.println("Xoa hang thanh cong!");
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		cartItems.clear();
		System.out.println("Xoa toan bo SP thanh cong!");
	}

	public void placeOrder() {
		// TODO Auto-generated method stub

	}
}
