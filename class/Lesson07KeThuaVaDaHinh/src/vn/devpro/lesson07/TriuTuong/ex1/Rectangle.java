package vn.devpro.lesson07.TriuTuong.ex1;

public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	public Rectangle() {
		super();
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.length * this.width;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (this.length + this.width) * 2;
	}

}
