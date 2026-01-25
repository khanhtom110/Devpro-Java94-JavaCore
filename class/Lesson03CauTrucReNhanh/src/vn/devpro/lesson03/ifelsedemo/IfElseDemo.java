package vn.devpro.lesson03.ifelsedemo;

public class IfElseDemo {
	public static void OddEven(int x) {
		int r = x % 2;
		if (r == 0) {
			System.out.println(x + " la so chan");
		} else {
			System.out.println(x + " la so le");
		}
	}

	public static void main(String[] args) {
		int m = 12;
		int n = 5;
		OddEven(m);
		OddEven(n);
	}
}
