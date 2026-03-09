package vn.devpro.lesson09.database;

import java.util.ArrayList;
import java.util.Date;

import vn.devpro.lesson09.model.Category;
import vn.devpro.lesson09.model.Customer;
import vn.devpro.lesson09.model.Order;
import vn.devpro.lesson09.model.Product;
import vn.devpro.lesson09.model.ProductInOrder;

public class ShopDb {
	private static int categoryId = 1;
	private static int customerId = 1;
	private static int orderId = 1;
	private static int productId = 1;
	private static int productInOrderId = 1;

	private static ArrayList<Category> categories = new ArrayList<Category>();
	private static ArrayList<Product> products = new ArrayList<Product>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<ProductInOrder> productInOrders = new ArrayList<ProductInOrder>();

	public static void init() {
		// Add category
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Tops"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Bottoms"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Dresses"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Accessories"));

		// Add product
		products.add(
				new Product(productId++, 1, "TSH" + new Date().getTime() + productId, "Unisex Cotton T-Shirt", 300000));
		products.add(
				new Product(productId++, 1, "SHR" + new Date().getTime() + productId, "Slim-fit Office Shirt", 200000));
		products.add(
				new Product(productId++, 2, "JEA" + new Date().getTime() + productId, "Classic Blue Jeans", 500000));
		products.add(
				new Product(productId++, 3, "DRS" + new Date().getTime() + productId, "Floral Summer Dress", 250000));
		products.add(new Product(productId++, 4, "BEL" + new Date().getTime() + productId, "Leather Belt", 100000));

		// Add customer
		customers.add(new Customer(customerId++, "CUS" + new Date().getTime() + customerId, "Nguyen Viet Khanh",
				"0912345678"));
		customers.add(
				new Customer(customerId++, "CUS" + new Date().getTime() + customerId, "Alice Johnson", "0987654321"));
		customers
				.add(new Customer(customerId++, "CUS" + new Date().getTime() + customerId, "Bob Miller", "0905111222"));

		// Add order
		orders.add(new Order(orderId++, 1, "ORD" + new Date().getTime() + orderId, 900000));
		orders.add(new Order(orderId++, 2, "ORD" + new Date().getTime() + orderId, 750000));

		// Add product in order
		productInOrders.add(new ProductInOrder(productId++, 1, 1, 1));// 300
		productInOrders.add(new ProductInOrder(productId++, 3, 1, 1));// 500
		productInOrders.add(new ProductInOrder(productId++, 5, 1, 1));// 100-Khanh mua 900k
		productInOrders.add(new ProductInOrder(productId++, 3, 2, 1));// 500-Alice mua 750k
		productInOrders.add(new ProductInOrder(productId++, 4, 2, 1));// 250
	}

	public static ArrayList<Category> getCategories() {
		return categories;
	}

	public static void setCategories(ArrayList<Category> categories) {
		ShopDb.categories = categories;
	}

	public static int getCategoryId() {
		return categoryId;
	}

	public static void setCategoryId(int categoryId) {
		ShopDb.categoryId = categoryId;
	}

	public static int getCustomerId() {
		return customerId;
	}

	public static void setCustomerId(int customerId) {
		ShopDb.customerId = customerId;
	}

	public static int getOrderId() {
		return orderId;
	}

	public static void setOrderId(int orderId) {
		ShopDb.orderId = orderId;
	}

	public static int getProductId() {
		return productId;
	}

	public static void setProductId(int productId) {
		ShopDb.productId = productId;
	}

	public static int getProductInOrderId() {
		return productInOrderId;
	}

	public static void setProductInOrderId(int productInOrderId) {
		ShopDb.productInOrderId = productInOrderId;
	}

}
