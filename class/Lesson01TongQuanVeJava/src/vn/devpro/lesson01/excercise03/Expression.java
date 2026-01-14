package vn.devpro.lesson01.excercise03;

import java.util.Scanner;

public class Expression {
	int a;
	int b;
	double x;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("a=");
		this.a = sc.nextInt();
		System.out.print("b=");
		this.b = sc.nextInt();
		System.out.print("x=");
		this.x = sc.nextDouble();
	}

	public double value() {
		return a / 10.0 + Math.pow(a, b) - Math.sin(Math.PI * x / 3) / Math.sqrt(Math.pow(a + b, 2) + 5)
				+ Math.log(Math.pow(a, 2) + 1) - Math.log(4 * Math.pow(x, 2 * a) + 3) / Math.log(3) / 2.55;
	}
}
