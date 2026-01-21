package vn.devpro.lesson02.operator;

public class ToanTuBaNgoi {
	public static void main(String[] args) {
		int a = 5, b = 4, c = 6;
		int max = a;
		max = (max < b) ? b : max;
		max = (max < c) ? c : max;
		System.out.println("Gia tri lon nhat la: " + max);
	}
}
