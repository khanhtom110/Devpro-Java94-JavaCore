package vn.devpro.model;

public class Author {
	private int id;
	private String code;
	private String firstName;
	private String lastName;

	public void display() {
		System.out.printf("%3d %17s %-25s%n", id, code, firstName + " " + lastName);
	}

	public Author() {
		super();
	}

	public Author(int id, String code, String firstName, String lastName) {
		super();
		this.id = id;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
