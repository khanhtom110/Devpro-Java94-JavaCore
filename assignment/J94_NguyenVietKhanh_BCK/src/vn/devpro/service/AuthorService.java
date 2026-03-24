package vn.devpro.service;

import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Author;

public class AuthorService {

	public static List<Author> findAll() {
		// TODO Auto-generated method stub
		return LibraryDb.getAuthors();
	}

	public static Author getById(int authorId) {
		// TODO Auto-generated method stub
		for (Author author : LibraryDb.getAuthors()) {
			if (author.getId() == authorId) {
				return author;
			}
		}
		return null;
	}

	public static boolean existsByName(String name) {
		// TODO Auto-generated method stub
		for (Author author : LibraryDb.getAuthors()) {
			String currentName = author.getFirstName() + " " + author.getLastName();
			if (currentName.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public static void save(Author author) {
		// TODO Auto-generated method stub
		LibraryDb.getAuthors().add(author);
	}

	public static Author getByCode(String code) {
		// TODO Auto-generated method stub
		for (Author author : LibraryDb.getAuthors()) {
			if (author.getCode().equals(code)) {
				return author;
			}
		}
		return null;
	}

	public static void update(Author author) {
		// TODO Auto-generated method stub
		int index = findByCode(author.getCode());
		if (index == -1) {
			System.out.println("Co lo xay ra");
			return;
		}
		LibraryDb.getAuthors().set(index, author);
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getAuthors().size(); i++) {
			if (LibraryDb.getAuthors().get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		LibraryDb.getAuthors().remove(index);
	}

	public static void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getAuthors().size() - 1; i++) {
			for (int j = LibraryDb.getAuthors().size() - 1; j > i; j--) {
				Author currentAuthor = LibraryDb.getAuthors().get(j);
				Author previousAuthor = LibraryDb.getAuthors().get(j - 1);
				if (currentAuthor.getLastName().compareTo(previousAuthor.getLastName()) < 0) {
					Author tmp = previousAuthor;
					LibraryDb.getAuthors().set(j - 1, currentAuthor);
					LibraryDb.getAuthors().set(j, tmp);
				}
			}
		}
	}

}
