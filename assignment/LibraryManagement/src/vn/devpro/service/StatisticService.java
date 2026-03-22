package vn.devpro.service;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.dto.BorrowedBookRespone;
import vn.devpro.model.Book;
import vn.devpro.model.LoanDetail;
import vn.devpro.model.LoanReceipt;
import vn.devpro.model.Reader;

public class StatisticService {

	public static List<BorrowedBookRespone> getBorrowdBooks() {
		// TODO Auto-generated method stub
		List<BorrowedBookRespone> bookRespones = new ArrayList<BorrowedBookRespone>();
		for (LoanDetail loanDetail : LibraryDb.getLoanDetails()) {
			BorrowedBookRespone bookRespone = new BorrowedBookRespone();
			bookRespone.setName(loanDetail.getBookName());
			bookRespone.setAuthorName(loanDetail.getAuthorName());
			LoanReceipt loanReceipt = LoanReceiptService.getById(loanDetail.getLoanReceiptId());
			bookRespone.setReaderName(loanReceipt.getReaderName());
			bookRespone.setDueDate(loanDetail.getDueDate());

			bookRespones.add(bookRespone);
		}
		return bookRespones;
	}

	public static List<Book> getAlreadyBooks() {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		for (Book book : LibraryDb.getBooks()) {
			if (book.getQuantity() > 0) {
				books.add(book);
			}
		}
		return books;
	}

	public static List<BorrowedBookRespone> getBorrowdBooksByReader(String code) {
		// TODO Auto-generated method stub
		List<BorrowedBookRespone> bookRespones = new ArrayList<BorrowedBookRespone>();
		Reader reader = ReaderService.getByCode(code);
		for (LoanDetail loanDetail : LibraryDb.getLoanDetails()) {
			LoanReceipt loanReceipt = LoanReceiptService.getById(loanDetail.getLoanReceiptId());
			if (loanReceipt.getReaderId() == reader.getId()) {
				BorrowedBookRespone bookRespone = new BorrowedBookRespone();
				bookRespone.setName(loanDetail.getBookName());
				bookRespone.setAuthorName(loanDetail.getAuthorName());

				bookRespone.setReaderName(loanReceipt.getReaderName());
				bookRespone.setDueDate(loanDetail.getDueDate());

				bookRespones.add(bookRespone);
			}

		}
		return bookRespones;
	}
}
