package vn.devpro.model;

public class Reader {
	private int id;
	private String code;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private boolean isStudent;

	public void display() {
		String tmp = "";
		if (isStudent) {
			tmp = "CO";
		} else {
			tmp = "KHONG";
		}
		System.out.printf("%3d %17s %-25s %10s %9s %8s%n", id, code, firstName + " " + lastName, dateOfBirth, gender,
				tmp);
	}

	public Reader() {
		super();
	}

	public Reader(int id, String code, String firstName, String lastName, String dateOfBirth, String gender,
			boolean isStudent) {
		super();
		this.id = id;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.isStudent = isStudent;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
}
