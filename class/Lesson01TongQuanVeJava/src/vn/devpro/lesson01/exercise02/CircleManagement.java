package vn.devpro.lesson01.exercise02;

public class CircleManagement {
	public static void main(String[] args) {
		// Khai bao va khoi tao mot doi tuong circle
		Circle circle = new Circle();
		circle.input();
		System.out.printf("Chu vi la %.5f%n", circle.perimeter());
		System.out.printf("Dien tich la %.5f%n", circle.area());
	}
}
