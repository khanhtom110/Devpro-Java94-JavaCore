package vn.devpro.lesson07;

import java.util.Scanner;

public class Job {
	private String code;
	private String name;

	public Job() {
		super();
	}

	public Job(String code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	static Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("\tNhap ma cong viec: ");
		this.code = sc.nextLine();
		System.out.print("\tNhap ten cong viec: ");
		this.name = sc.nextLine();
	}
}
