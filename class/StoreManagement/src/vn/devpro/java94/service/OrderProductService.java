package vn.devpro.java94.service;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.OrderProduct;

public class OrderProductService {
	public List<OrderProduct> getByOrderId(int orderId) {
		List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		for (OrderProduct orderProduct : StoreDb.getOrderProducts()) {
			if (orderProduct.getOrderId() == orderId) {
				orderProducts.add(orderProduct);
			}
		}
		return orderProducts;
	}
}
