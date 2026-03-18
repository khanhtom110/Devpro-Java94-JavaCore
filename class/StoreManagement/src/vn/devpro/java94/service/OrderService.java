package vn.devpro.java94.service;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Order;

public class OrderService {

	public static void save(Order order) {
		// TODO Auto-generated method stub
		StoreDb.getOrders().add(order);
	}

	public static void displayAll() {
		System.out.println("\t\tDANH SACH DON HANG");
		System.out.printf("%-25s %10s %-50s %-15s%n", "Ten khach hang", "Ngay tao", "Trang thai", "Tong tien");
		for (Order order : StoreDb.getOrders()) {
			order.display();
		}
	}

}
