package vn.devpro.service;

import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Category;

public class CategoryService {

	public static List<Category> findAll() {
		// TODO Auto-generated method stub
		return LibraryDb.getCategories();
	}

	public static Category getById(int categoryId) {
		// TODO Auto-generated method stub
		for (Category category : LibraryDb.getCategories()) {
			if (category.getId() == categoryId) {
				return category;
			}
		}
		return null;
	}

	public static boolean existsByName(String name) {
		// TODO Auto-generated method stub
		for (Category category : LibraryDb.getCategories()) {
			if (category.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void save(Category category) {
		// TODO Auto-generated method stub
		LibraryDb.getCategories().add(category);
	}

	public static Category getByCode(String code) {
		// TODO Auto-generated method stub
		for (Category category : LibraryDb.getCategories()) {
			if (category.getCode().equals(code)) {
				return category;
			}
		}
		return null;
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getCategories().size(); i++) {
			if (LibraryDb.getCategories().get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void update(int index, Category category) {
		// TODO Auto-generated method stub
		LibraryDb.getCategories().set(index, category);
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		LibraryDb.getCategories().remove(index);
	}

	public static void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getCategories().size() - 1; i++) {
			for (int j = LibraryDb.getCategories().size() - 1; j > i; j--) {
				Category currentCategory = LibraryDb.getCategories().get(j);
				Category previousCategory = LibraryDb.getCategories().get(j - 1);
				if (currentCategory.getName().compareTo(previousCategory.getName()) < 0) {
					Category tmp = previousCategory;
					LibraryDb.getCategories().set(j - 1, currentCategory);
					LibraryDb.getCategories().set(j, tmp);
				}
			}
		}
	}

}
