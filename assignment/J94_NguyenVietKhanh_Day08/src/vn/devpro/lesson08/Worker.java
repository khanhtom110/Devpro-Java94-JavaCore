package vn.devpro.lesson08;

public class Worker extends Staff implements Salary {
	private String factory;
	private String job;
	private double workingDays;

	public void display() {
		super.display();
		System.out.printf("%-20s %-25s %21.1f %,13.2f%n", this.factory, this.job, this.workingDays, this.salary());
	}

	@Override
	public double salary() {
		if (this.workingDays >= 23) {
			return this.workingDays * 250000 + 500000;
		} else if (this.workingDays >= 20) {
			return this.workingDays * 250000 + 300000;
		} else if (this.workingDays >= 18) {
			return this.workingDays * 250000;
		} else {
			return this.workingDays * 250000 - 200000;
		}
	}

	public Worker() {
		super();
	}

	public Worker(String id, String firstName, String lastName, int yearOfBirth, String gender, String factory,
			String job, double workingDays) {
		super(id, firstName, lastName, yearOfBirth, gender);
		this.factory = factory;
		this.job = job;
		this.workingDays = workingDays;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(double workingDays) {
		this.workingDays = workingDays;
	}

}
