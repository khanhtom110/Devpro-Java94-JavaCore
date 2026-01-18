package vn.devpro.lesson01.excercise04;

public class Caculation {
	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		triangle.input();
		System.out.printf("Chu vi hinh tam giac do la: %.3f%n", triangle.perimeter());
		System.out.printf("Dien tich hinh tam giac do la: %.3f", triangle.area());
	}
}
