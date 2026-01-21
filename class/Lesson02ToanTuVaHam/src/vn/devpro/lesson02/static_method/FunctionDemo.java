package vn.devpro.lesson02.static_method;

public class FunctionDemo {
	public static int sum(int a, int b) {
		int s;
		s = a + b;
		return s;
	}

	public static void main(String[] args) {
		int x = 5, y = 7;
		int c = sum(x, y);
		System.out.println("result: " + c);
	}
}
