package vn.devpro.lesson01.excercise03;

public class Caculation {
	public static void main(String[] args) {
		Expression expression = new Expression();
		expression.input();
		System.out.printf("The value of expression is %7f", expression.value());
	}
}
