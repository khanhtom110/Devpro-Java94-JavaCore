package vn.devpro.database;

import java.util.ArrayList;
import java.util.Date;

import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.model.Category;
import vn.devpro.model.LoanDetail;
import vn.devpro.model.LoanReceipt;
import vn.devpro.model.Reader;

public class LibraryDb {
	private static int categoryId = 1;
	private static int readerId = 1;
	private static int bookId = 1;
	private static int authorId = 1;
	private static int loanReceiptId = 1;
	private static int loanDetailId = 1;

	private static ArrayList<Category> categories = new ArrayList<Category>();
	private static ArrayList<Book> books = new ArrayList<Book>();
	private static ArrayList<Reader> readers = new ArrayList<Reader>();
	private static ArrayList<Author> authors = new ArrayList<Author>();
	private static ArrayList<LoanReceipt> loanReceipts = new ArrayList<LoanReceipt>();
	private static ArrayList<LoanDetail> loanDetails = new ArrayList<LoanDetail>();

	public static void init() {
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Thieu nhi"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Suc khoe"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Khoa hoc"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Kinh doanh"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Triet hoc"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Kinh te"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Tam ly hoc"));
		categories.add(new Category(categoryId++, "CAT" + new Date().getTime() + categoryId, "Ky nang song"));

		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Nam", "Cao"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "To", "Hoai"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Ngo Tat", "To"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Nguyen Nhat", "Anh"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Vu Trong", "Phung"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Chu", "Lai"));
		authors.add(new Author(authorId++, "AU" + new Date().getTime() + authorId, "Nguyen Huy", "Thiep"));

		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Nguyen Van", "An", "15-05-2003",
				"Nam", true));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Tran Thi", "Binh", "22-08-2004",
				"Nu", false));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Le Hoang", "Nam", "10-01-2005",
				"Nam", true));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Pham Minh", "Thu", "30-11-2003",
				"Nu", false));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Vo Thanh", "Long", "05-03-2004",
				"Nam", true));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Dang Thu", "Thao", "12-12-2005",
				"Nu", false));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Bui Xuan", "Bach", "18-07-2003",
				"Nam", true));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Ngo Bao", "Ngoc", "25-09-2004",
				"Nu", true));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Ly Gia", "Han", "08-06-2005", "Nu",
				false));
		readers.add(new Reader(readerId++, "RD" + new Date().getTime() + readerId, "Duong Quoc", "Anh", "20-02-2003",
				"Nam", false));

		// Sách của Nguyễn Nhật Ánh (Author 4 - Thể loại Thiếu nhi 1)
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 4, 1, "Cho toi xin mot ve di tuoi tho", 220,
				15));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 4, 1, "Mat biec", 250, 1));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 4, 1, "Kinh van hoa", 350, 20));

		// Sách Văn học Kinh điển (Các Author 1, 2, 3, 5 - Thể loại 1 hoặc tùy chọn)
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 1, 1, "Chi Pheo", 150, 12));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 2, 1, "De Men phieu luu ky", 120, 25));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 3, 1, "Tat den", 180, 8));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 5, 1, "So do", 210, 5));

		// Sách Kỹ năng & Tâm lý (Tác giả khác - Thể loại 7, 8)
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 6, 8, "An khac phuc", 280, 14));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 7, 1, "Tuong ve huu", 190, 7));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 4, 7, "Con chut gi de nho", 160, 11));

		// Sách Kinh tế & Khoa học (Sử dụng các Category còn lại)
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 1, 4, "Song mon", 300, 6));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 6, 6, "Nang han", 320, 9));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 2, 3, "Chuyen cu Ha Noi", 400, 13));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 5, 5, "Giong to", 270, 4));
		books.add(new Book(bookId++, "BK" + new Date().getTime() + bookId, 4, 8, "Toi la Beto", 140, 18));

	}

	public static int getBookId() {
		return bookId;
	}

	public static void setBookId(int bookId) {
		LibraryDb.bookId = bookId;
	}

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static void setBooks(ArrayList<Book> books) {
		LibraryDb.books = books;
	}

	public static int getCategoryId() {
		return categoryId;
	}

	public static void setCategoryId(int categoryId) {
		LibraryDb.categoryId = categoryId;
	}

	public static int getReaderId() {
		return readerId;
	}

	public static void setReaderId(int readerId) {
		LibraryDb.readerId = readerId;
	}

	public static int getAuthorId() {
		return authorId;
	}

	public static void setAuthorId(int authorId) {
		LibraryDb.authorId = authorId;
	}

	public static ArrayList<Category> getCategories() {
		return categories;
	}

	public static void setCategories(ArrayList<Category> categories) {
		LibraryDb.categories = categories;
	}

	public static ArrayList<Reader> getReaders() {
		return readers;
	}

	public static void setReaders(ArrayList<Reader> readers) {
		LibraryDb.readers = readers;
	}

	public static ArrayList<Author> getAuthors() {
		return authors;
	}

	public static void setAuthors(ArrayList<Author> authors) {
		LibraryDb.authors = authors;
	}

	public static int getLoanReceiptId() {
		return loanReceiptId;
	}

	public static void setLoanReceiptId(int loanReceiptId) {
		LibraryDb.loanReceiptId = loanReceiptId;
	}

	public static int getLoanDetailId() {
		return loanDetailId;
	}

	public static void setLoanDetailId(int loanDetailId) {
		LibraryDb.loanDetailId = loanDetailId;
	}

	public static ArrayList<LoanReceipt> getLoanReceipts() {
		return loanReceipts;
	}

	public static void setLoanReceipts(ArrayList<LoanReceipt> loanReceipts) {
		LibraryDb.loanReceipts = loanReceipts;
	}

	public static ArrayList<LoanDetail> getLoanDetails() {
		return loanDetails;
	}

	public static void setLoanDetails(ArrayList<LoanDetail> loanDetails) {
		LibraryDb.loanDetails = loanDetails;
	}

}
