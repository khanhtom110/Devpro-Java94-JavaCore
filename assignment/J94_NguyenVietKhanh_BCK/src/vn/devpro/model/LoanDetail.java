package vn.devpro.model;

import java.time.LocalDate;

public class LoanDetail {
	private int id;
	private int loanReceiptId;
	private int bookId;
	private String bookName;
	private String authorName;
	private String categoryName;
	private LocalDate dueDate;

	public void display() {
		System.out.printf("%-35s %-25s %-15s %10s%n", bookName, authorName, categoryName, dueDate);
	}

	public LoanDetail() {
		super();
	}

	public LoanDetail(int id, int loanReceiptId, int bookId, String bookName, String authorName, String categoryName,
			LocalDate dueDate) {
		super();
		this.id = id;
		this.loanReceiptId = loanReceiptId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.categoryName = categoryName;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getLoanReceiptId() {
		return loanReceiptId;
	}

	public void setLoanReceiptId(int loanReceiptId) {
		this.loanReceiptId = loanReceiptId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
