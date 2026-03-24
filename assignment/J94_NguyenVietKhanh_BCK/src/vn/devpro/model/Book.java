package vn.devpro.model;

import vn.devpro.service.AuthorService;
import vn.devpro.service.CategoryService;

public class Book {
	private int id;
	private String code;
	private int authorId;
	private int categoryId;
	private String name;
	private int numberOfPages;
	private int quantity;

	public void display() {
		Author author = AuthorService.getById(authorId);
		if (author == null) {
			System.out.println("Co loi xay ra");
			return;
		}
		Category category = CategoryService.getById(categoryId);
		if (category == null) {
			System.out.println("Co loi xay ra");
			return;
		}
		System.out.printf("%3d %17s %-25s %-15s %-35s %8d %8d%n", id, code,
				author.getFirstName() + " " + author.getLastName(), category.getName(), name, numberOfPages, quantity);
	}

	public Book() {
		super();
	}

	public Book(int id, String code, int authorId, int categoryId, String name, int numberOfPages, int quantity) {
		super();
		this.id = id;
		this.code = code;
		this.authorId = authorId;
		this.categoryId = categoryId;
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
