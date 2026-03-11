package vn.devpro.java94.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.devpro.java94.model.Customer;
import vn.devpro.java94.model.Order;
import vn.devpro.java94.model.OrderProduct;
import vn.devpro.java94.model.Product;
import vn.devpro.java94.model.Provider;

public class StoreDb {
	private static int providerId = 1;
	private static int productId = 1;
	private static int customerId = 1;
	private static int orderId = 1;
	private static int orderProductId = 1;

	private static ArrayList<Provider> providers = new ArrayList<Provider>();
	private static ArrayList<Product> products = new ArrayList<Product>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Order> orders = new ArrayList<Order>();

	private static List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

	public static void initDb() {
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Son Ha"));
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Son Ha Xanh"));
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Toan Thang"));

		products.add(new Product(productId++, 2, "SP" + new Date().getTime() + productId, "Noi com", 1000000));
		products.add(new Product(productId++, 1, "SP" + new Date().getTime() + productId, "Tu Lanh", 20000000));
		products.add(new Product(productId++, 3, "SP" + new Date().getTime() + productId, "Tivi", 17000000));

		customers.add(new Customer(customerId++, "KH" + new Date().getTime() + customerId, "David Nguyen"));
		customers.add(new Customer(customerId++, "KH" + new Date().getTime() + customerId, "Chu Du"));
		customers.add(new Customer(customerId++, "KH" + new Date().getTime() + customerId, "Gia Cat Luong"));
	}

	public static ArrayList<Provider> getProviders() {
		return providers;
	}

	public static void setProviders(ArrayList<Provider> providers) {
		StoreDb.providers = providers;
	}

	public static int getProviderId() {
		return providerId;
	}

	public static void setProviderId(int providerId) {
		StoreDb.providerId = providerId;
	}

	public static ArrayList<Product> getProducts() {
		return products;
	}

	public static void setProducts(ArrayList<Product> products) {
		StoreDb.products = products;
	}

	public static int getProductId() {
		return productId;
	}

	public static void setProductId(int productId) {
		StoreDb.productId = productId;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(ArrayList<Customer> customers) {
		StoreDb.customers = customers;
	}

	public static int getCustomerId() {
		return customerId;
	}

	public static void setCustomerId(int customerId) {
		StoreDb.customerId = customerId;
	}

	public static int getOrderProductId() {
		return orderProductId;
	}

	public static void setOrderProductId(int orderProductId) {
		StoreDb.orderProductId = orderProductId;
	}

	public static List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public static void setOrderProducts(List<OrderProduct> orderProducts) {
		StoreDb.orderProducts = orderProducts;
	}

}
