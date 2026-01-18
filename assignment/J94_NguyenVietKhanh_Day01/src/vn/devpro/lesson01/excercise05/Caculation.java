package vn.devpro.lesson01.excercise05;

public class Caculation {
	public static void main(String[] args) {
		Cuboid cuboid = new Cuboid();
		cuboid.input();
		System.out.printf("Dien tich xung quanh cua hinh hop chu nhat la: %.3f%n", cuboid.lateralSurfaceArea());
		System.out.printf("Dien tich toan phan cua hinh hop chu nhat la: %.3f%n", cuboid.totalSurfaceArea());
		System.out.printf("The tich cua hinh hop chu nhat la: %.3f%n", cuboid.volume());
	}
}
