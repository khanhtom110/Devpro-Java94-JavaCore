package vn.devpro.java94.database;

import java.util.ArrayList;
import java.util.Date;

import vn.devpro.java94.model.Customer;
import vn.devpro.java94.model.Order;
import vn.devpro.java94.model.Product;
import vn.devpro.java94.model.Provider;

public class StoreDb {
	private static int providerId = 1;
	private static int productId = 1;
	private static int customerId = 1;
	private static int orderId = 1;

	private static ArrayList<Provider> providers = new ArrayList<Provider>();
	private static ArrayList<Product> products = new ArrayList<Product>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Order> orders = new ArrayList<Order>();

	public static void initDb() {
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Son Ha"));
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Son Ha Xanh"));
		providers.add(new Provider(providerId++, "NCC" + new Date().getTime() + providerId, "Toan Thang"));

		products.add(new Product(productId++, 2, "NCC" + new Date().getTime() + productId, "Noi com", 1000000));
		products.add(new Product(productId++, 1, "NCC" + new Date().getTime() + productId, "Tu Lanh", 20000000));
		products.add(new Product(productId++, 3, "NCC" + new Date().getTime() + productId, "Tivi", 17000000));
	}
}
