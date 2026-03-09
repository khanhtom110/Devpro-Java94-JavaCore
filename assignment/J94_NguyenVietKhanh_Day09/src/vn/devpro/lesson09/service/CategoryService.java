package vn.devpro.lesson09.service;

import java.util.List;

import vn.devpro.lesson09.database.ShopDb;
import vn.devpro.lesson09.model.Category;

public class CategoryService {

	public static List<Category> findAll() {
		// TODO Auto-generated method stub
		return ShopDb.getCategories();
	}

	public static void save(Category category) {
		// TODO Auto-generated method stub
		ShopDb.getCategories().add(category);
	}

	public static boolean findByName(String name) {
		// TODO Auto-generated method stub
		for (Category category : ShopDb.getCategories()) {
			if (category.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public static boolean findByCode(String code) {
		// TODO Auto-generated method stub
		for (Category category : ShopDb.getCategories()) {
			if (category.getCode().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}

}
