package vn.devpro.dto;

import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.service.AuthorService;
import vn.devpro.service.BookService;

public class BorrowItem {
	private int bookId;

	public void display() {
		Book book = BookService.getById(bookId);
		Author author = AuthorService.getById(book.getAuthorId());
		if (book == null || author == null) {
			System.out.println("Loi CSDL");
			return;
		}
		System.out.printf("%-35s %-25s%n", book.getName(), author.getFirstName() + " " + author.getLastName());
	}

	public BorrowItem() {
		super();
	}

	public BorrowItem(int bookId) {
		super();
		this.bookId = bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
