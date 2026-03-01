package vn.devpro.lesson07.TriuTuong.ex1;

public class Box extends Rectangle {
	private double height;

	public Box(double length, double width) {
		super(length, width);
	}

	public Box(double length, double width, double height) {
		super(length, width);
		this.height = height;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
