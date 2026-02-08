package vn.devpro.lesson06.exercise04;

public class Weightlifter {
	private String name;
	private double[] reps = new double[3];
	private double result;

	public Weightlifter(String name, double rep0, double rep1, double rep2) {
		super();
		this.name = name;
		this.reps[0] = rep0;
		this.reps[1] = rep1;
		this.reps[2] = rep2;
		this.result = rep0 + rep1 + rep2;
	}

	public Weightlifter() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getReps() {
		return reps;
	}

	public void setReps(double[] reps) {
		this.reps = reps;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public void display() {
		System.out.printf("%-10s %10.1f %10.1f %10.1f %10.1f%n", this.name, this.reps[0], this.reps[1], this.reps[2],
				this.result);
	}

}
