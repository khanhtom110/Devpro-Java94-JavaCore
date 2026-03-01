package vn.devpro.lesson07.TriuTuong.ex1;

public class Demo {
	public static void main(String[] args) {
		Shape shape = new Circle(10);
		System.out.println("Chu vi: " + shape.perimeter());
		System.out.println("Dien tich: " + shape.area());
		shape = new Rectangle(3, 2);
		System.out.println("Chu vi: " + shape.perimeter());
		System.out.println("Dien tich: " + shape.area());
		shape = new Box(1, 2, 3);
		System.out.println("Chu vi: " + shape.perimeter());
		System.out.println("Dien tich: " + shape.area());
	}
}
