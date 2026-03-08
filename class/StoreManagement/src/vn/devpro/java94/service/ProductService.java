package vn.devpro.java94.service;

import java.util.List;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Product;

public class ProductService {
	public static List<Product> findAll() {
		return StoreDb.getProducts();
	}

	public static boolean existsByName(String name) {
		for (Product product : StoreDb.getProducts()) {
			if (name.trim().equalsIgnoreCase(product.getName().trim())) {
				return true;
			}
		}
		return false;
	}

	public static void save(Product product) {
		StoreDb.getProducts().add(product);
	}

	public static Product getByCode(String code) {
		for (Product product : StoreDb.getProducts()) {
			if (code.trim().equalsIgnoreCase(product.getCode())) {
				return product;
			}
		}
		return null;
	}

	public static int findById(int id) {
		for (int i = 0; i < StoreDb.getProducts().size(); i++) {
			if (StoreDb.getProducts().get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static void update(Product product) {
		int index = findById(product.getId());
		if (index != -1) {
			StoreDb.getProducts().set(index, product);
			System.out.println("\tDa sua thanh cong");
		} else {
			System.out.println("\tLoi he thong");
		}
	}

	public static int findByCode(String code) {
		for (int i = 0; i < StoreDb.getProducts().size(); i++) {
			if (code.trim().equalsIgnoreCase(StoreDb.getProducts().get(i).getCode())) {
				return i;
			}
		}
		return -1;
	}

	public static void delete(int index) {
		StoreDb.getProducts().remove(index);
	}
}
