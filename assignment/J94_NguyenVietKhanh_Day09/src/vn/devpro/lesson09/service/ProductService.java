package vn.devpro.lesson09.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.devpro.lesson09.database.ShopDb;
import vn.devpro.lesson09.model.Category;
import vn.devpro.lesson09.model.Product;

public class ProductService {

	public static List<Product> findAll() {
		// TODO Auto-generated method stub
		return ShopDb.getProducts();
	}

	public static boolean existsByName(String productName) {
		// TODO Auto-generated method stub
		for (Product product : ShopDb.getProducts()) {
			if (product.getName().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	public static void save(Product product) {
		// TODO Auto-generated method stub
		ShopDb.getProducts().add(product);
	}

	public static boolean existsByCode(String productCode) {
		// TODO Auto-generated method stub
		for (Product product : ShopDb.getProducts()) {
			if (product.getCode().equalsIgnoreCase(productCode)) {
				return true;
			}
		}
		return false;
	}

	public static Product getByCode(String productCode) {
		// TODO Auto-generated method stub
		for (Product product : ShopDb.getProducts()) {
			if (product.getCode().equalsIgnoreCase(productCode)) {
				return product;
			}
		}
		return null;
	}

	public static void update(Product product) {
		// TODO Auto-generated method stub
		int index = findById(product.getId());
		if (index == -1) {
			System.out.println("Co loi xay ra");
		} else {
			ShopDb.getProducts().set(index, product);
			System.out.println("Cap nhat thanh cong!");
		}

	}

	private static int findById(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ShopDb.getProducts().size(); i++) {
			if (ShopDb.getProducts().get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ShopDb.getProducts().size(); i++) {
			if (ShopDb.getProducts().get(i).getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		ShopDb.getProducts().remove(index);
	}

	public static void sort(List<Product> products) {
		// TODO Auto-generated method stub
		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static List<Product> getProductsByCategory(Category category) {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		for (Product product : ShopDb.getProducts()) {
			if (product.getCategoryId() == category.getId()) {
				products.add(product);
			}
		}
		return products;
	}

	public static List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		for (Product product : ShopDb.getProducts()) {
			if (product.getName().toLowerCase().contains(productName.toLowerCase())) {
				products.add(product);
			}
		}
		return products;
	}

}
