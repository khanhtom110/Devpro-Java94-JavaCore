package vn.devpro.lesson07.TriuTuong.ex1;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	// Phai override lai phuong thuc triu tuong

	@Override
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * this.radius;
	}
}
