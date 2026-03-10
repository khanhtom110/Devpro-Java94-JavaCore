package vn.devpro.lesson09.service;

import java.util.Collections;
import java.util.Comparator;
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

	public static boolean existsByCode(String code) {
		// TODO Auto-generated method stub
		for (Category category : ShopDb.getCategories()) {
			if (category.getCode().equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ShopDb.getCategories().size(); i++) {
			if (ShopDb.getCategories().get(i).getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		return -1;
	}

	public static Category getByCode(String code) {
		// TODO Auto-generated method stub
		for (Category category : ShopDb.getCategories()) {
			if (category.getCode().equalsIgnoreCase(code)) {
				return category;
			}
		}
		return null;
	}

	public static void update(int index, Category category) {
		// TODO Auto-generated method stub
		ShopDb.getCategories().set(index, category);
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		ShopDb.getCategories().remove(index);
	}

	public static void sort(List<Category> categories) {
		// TODO Auto-generated method stub
		Collections.sort(categories, new Comparator<Category>() {
			@Override
			public int compare(Category o1, Category o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

}
