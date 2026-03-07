package vn.devpro.lesson08;

public class Staff {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected int yearOfBirth;
	protected String gender;

	public void display() {
		System.out.printf("%5s %-25s %8d %-9s ", this.id, this.firstName + " " + this.lastName, this.yearOfBirth,
				this.gender);
	}

	public Staff() {
		super();
	}

	public Staff(String id, String firstName, String lastName, int yearOfBirth, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
