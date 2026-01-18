package vn.devpro.lesson01.excercise01;

public class Caculation {
	public static void main(String[] args) {
		Trapezoid trapezoid = new Trapezoid();
		trapezoid.input();
		System.out.printf("Dien tich hinh thang la: %.3f", trapezoid.area());
	}
}
