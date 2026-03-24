package vn.devpro.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.LibraryManagement;
import vn.devpro.database.LibraryDb;
import vn.devpro.model.Author;
import vn.devpro.model.Book;
import vn.devpro.model.LoanDetail;
import vn.devpro.model.LoanReceipt;
import vn.devpro.model.Reader;
import vn.devpro.service.AuthorService;
import vn.devpro.service.BookService;
import vn.devpro.service.CategoryService;
import vn.devpro.service.LoanDetailService;
import vn.devpro.service.LoanReceiptService;
import vn.devpro.service.ReaderService;

public class BorrowTicket {
	static Scanner sc = new Scanner(System.in);

	private List<BorrowItem> borrowItems = new ArrayList<BorrowItem>();

	public void display() {
		int count = 1;
		System.out.println("\t\tPHIEU MUON SACH");
		System.out.printf("%3s %17s %-35s %-25s%n", "STT", "Ma sach", "Ten sach", "Tac gia");
		for (BorrowItem borrowItem : borrowItems) {
			System.out.printf("%3d ", count++);
			borrowItem.display();
		}
	}

	public void add() {
		// Check so luong sach trong phieu >3 chua
		if (borrowItems.size() >= 3) {
			System.out.println("\tPhieu da du 3 cuon sach");
			return;
		}

		System.out.println("\t\tTHEM SACH VAO PHIEU");
		String readerCode = LibraryManagement.getCustomerCode();
		Reader reader = ReaderService.getByCode(readerCode);
		if (reader == null) {
			System.out.println("\tMa nguoi doc chua chinh xac");
			return;
		}

		System.out.print("\tChon sach (nhap ma sach): ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		Book book = BookService.getByCode(code);
		if (book == null) {
			System.out.println("\tTam thoi het sach");
			return;
		}

		// Tim xem sach da co trong phieu chua
		int index = findById(book.getId());
		if (index == -1) {
			// sach chua co trong phieu -> Them moi sach

			// Check sach da duoc muon truoc do hay chua
			boolean existed = isExists(book.getId(), reader.getId());
			if (existed) {
				System.out.println("\tBan da muon quyen nay truoc do");
				return;
			}

			borrowItems.add(new BorrowItem(book.getId()));
			System.out.println("\tDa them sach vao phieu thanh cong!");
		} else {
			// sach da co trong phieu-> Khong them duoc nua (Do moi phieu chi duoc muon 1
			// cuon sach)
			System.out.println("\tSach da co trong phieu");
		}

	}

	private boolean isExists(int bookId, int readerId) {
		// TODO Auto-generated method stub
		for (LoanDetail loanDetail : LibraryDb.getLoanDetails()) {
			LoanReceipt loanReceipt = LoanReceiptService.getById(loanDetail.getLoanReceiptId());
			if (loanDetail.getBookId() == bookId && loanReceipt.getReaderId() == readerId
					&& loanReceipt.getStatus().equals("Dang muon")) {
				return true;
			}
		}
		return false;
	}

	private int findById(int bookId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < borrowItems.size(); i++) {
			if (borrowItems.get(i).getBookId() == bookId) {
				return i;
			}
		}
		return -1;
	}

	public void update() {
		System.out.println("\t\tSUA SACH TRONG PHIEU");
		System.out.print("\tChon sach (nhap ma sach): ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		Book book = BookService.getByCode(code);
		if (book == null) {
			System.out.println("\tSach khong ton tai");
			return;
		}
		int index = findById(book.getId());
		if (index == -1) {
			System.out.println("\tSach khong co trong phieu");
			return;
		}
		System.out.print("\tChon sach moi (nhap ma sach): ");
		code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		book = BookService.getByCode(code);
		if (book == null) {
			System.out.println("\tTam thoi het sach");
			return;
		}

		// Neu sach moi nhap vao da co trong phieu
		int exist = findById(book.getId());
		if (exist != -1) {
			System.out.println("\tSach da co trong phieu, khong the them");
			return;
		}

		borrowItems.get(index).setBookId(book.getId());
		System.out.println("\tDa sua thong tin thanh cong");
	}

	public void delete() {
		System.out.println("\t\tXOA SACH TRONG PHIEU");
		System.out.print("\tChon sach (nhap ma sach): ");
		String code = sc.nextLine();
		if (code == null || code.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		Book book = BookService.getByCode(code);
		if (book == null) {
			System.out.println("\tSach khong co trong phieu");
			return;
		}
		int index = findById(book.getId());
		if (index == -1) {
			System.out.println("\tSach khong co trong phieu");
			return;
		}
		borrowItems.remove(index);
		System.out.println("\tXoa sach trong phieu thanh cong!");
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		borrowItems.clear();
		System.out.println("\tDa xoa toan bo sach trong phieu!");
	}

	public void borrow() {
		// TODO Auto-generated method stub
		// Chon nguoi doc
		String code = LibraryManagement.getCustomerCode();
		int index = ReaderService.findByCode(code);
		if (index == -1) {
			System.out.println("\tBan doc chua co tai khoan, khong the muon sach");
			return;
		}

		Reader reader = ReaderService.getByCode(code);
		int borrowedBooks = countBorrowedBooks(reader.getId());
		int currentTicketBooks = borrowItems.size();
		int totalOfBook = borrowedBooks + currentTicketBooks;

		if (reader.isStudent()) {
			// Duoc muon toi da 8 quyen
			if (totalOfBook > 8) {
				System.out.println("\tSinh vien chi duoc duoc muon toi da 8 quyen sach");
				return;
			}
		} else {
			// Duoc muon toi da 5 quyen
			if (totalOfBook > 5) {
				System.out.println("\tKhong phai sinh vien chi duoc duoc muon toi da 5 quyen sach");
				return;
			}
		}

		// Kiem tra so luong sach
		index = checkOutOfQuantity();
		if (index != -1) {
			// Co sach bi het trong db
			// In ra ten sach bi het
			Book bookOutOfQuantity = BookService.getById(borrowItems.get(index).getBookId());
			System.out.println("\tSach '" + bookOutOfQuantity.getName() + "' da het trong thu vien");
			return;
		}

		LoanReceipt loanReceipt = new LoanReceipt();
		loanReceipt.setId(LibraryDb.getLoanReceiptId());
		LibraryDb.setLoanReceiptId(LibraryDb.getLoanReceiptId() + 1);
		loanReceipt.setCreateDate(LocalDate.now());
		loanReceipt.setReaderId(reader.getId());
		loanReceipt.setReaderName(reader.getFirstName() + " " + reader.getLastName());
		loanReceipt.setStatus("Dang muon");

		// Luu cach sach vao db
		for (BorrowItem borrowItem : borrowItems) {
			Book book = BookService.getById(borrowItem.getBookId());
			Author author = AuthorService.getById(book.getAuthorId());

			LoanDetail loanDetail = new LoanDetail();
			loanDetail.setId(LibraryDb.getLoanDetailId());
			LibraryDb.setLoanDetailId(LibraryDb.getLoanDetailId() + 1);
			loanDetail.setLoanReceiptId(loanReceipt.getId());
			loanDetail.setBookId(book.getId());
			loanDetail.setAuthorName(author.getFirstName() + " " + author.getLastName());
			loanDetail.setBookName(book.getName());
			loanDetail.setCategoryName(CategoryService.getById(book.getCategoryId()).getName());
			loanDetail.setDueDate(loanReceipt.getCreateDate().plusDays(31));

			// Set lai quantity
			book.setQuantity(book.getQuantity() - 1);

			LoanDetailService.save(loanDetail);
		}
		LoanReceiptService.save(loanReceipt);
		System.out.println("\tBan da muon sach thanh cong!");
		deleteAll();
	}

	private int countBorrowedBooks(int readerId) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (LoanDetail loanDetail : LibraryDb.getLoanDetails()) {
			LoanReceipt loanReceipt = LoanReceiptService.getById(loanDetail.getLoanReceiptId());
			if (loanReceipt.getReaderId() == readerId && loanReceipt.getStatus().equals("Dang muon")) {
				cnt++;
			}
		}
		return cnt;
	}

	// Check het quantiy cua borrowItems
	// Tra ve i -> Chi so cua phan tu bi het quantity trong db
	// Tra ve -1 -> Tat ca sach deu con trong db
	private int checkOutOfQuantity() {
		// TODO Auto-generated method stub
		for (int i = 0; i < borrowItems.size(); i++) {
			Book book = BookService.getById(borrowItems.get(i).getBookId());
			if (book.getQuantity() <= 0) {
				return i;
			}
		}
		return -1;
	}
}
