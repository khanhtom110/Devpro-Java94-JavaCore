package vn.devpro.dto;

import java.time.LocalDate;

public class BorrowedBookRespone {
	private String code;
	private String name;
	private String authorName;
	private String readerName;
	private LocalDate dueDate;

	public void display() {
		System.out.printf("%17s %-35s %-25s %-25s %10s%n", code, name, authorName, readerName, dueDate);
	}

	public BorrowedBookRespone() {
		super();
	}

	public BorrowedBookRespone(String code, String name, String authorName, String readerName, LocalDate dueDate) {
		super();
		this.code = code;
		this.name = name;
		this.authorName = authorName;
		this.readerName = readerName;
		this.dueDate = dueDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
