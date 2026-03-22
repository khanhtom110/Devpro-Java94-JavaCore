package vn.devpro.model;

import java.time.LocalDate;

public class LoanReceipt {
	private int id;
	private int readerId;
	private String readerName;
	private LocalDate createDate;
	private String status;

	public void display() {
		System.out.printf("%10d %10d %-25s %10s %15s%n", id, readerId, readerName, createDate, status);
	}

	public LoanReceipt() {
		super();
	}

	public LoanReceipt(int id, int readerId, String readerName, LocalDate createDate, String status) {
		super();
		this.id = id;
		this.readerId = readerId;
		this.readerName = readerName;
		this.createDate = createDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
