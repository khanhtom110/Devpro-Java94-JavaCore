package vn.devpro.lesson05.arrayusage;

class Result {
	int index;
	double sum;

}

public class Matrix {
	public static double[][] init() {
		double[][] a = { { 2.3, 4.5, -9.5, 6.8, 6.7, 8.2, 4.33 }, // a[0]
				{ 2.3, 4.5, -9.5, 6.8, 6.7, 8.2, 7.33 }, // a[1]
				{ 2.3, 6.5, -9.5, 6.8, 6.7, 8.2, 4.33 }, { 2.3, 4.5, -9.5, 6.8, 6.7, 8.2, 4.33 },
				{ 2.3, 4.5, -99.5, 6.8, 6.7, 8.2, 4.33 }, { 2.3, 4.5, -9.5, 6.8, 88.7, 8.2, 4.33 } };
		return a;
	}

	public static void display(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%6.1f", a[i][j]);
			}
			System.out.println();
		}

	}

	// Tinh tong cua mot dong
	public static double sum(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	// Tim dong co tong lon nhat va tong
	public static Result maxRow(double[][] a) {
		Result res = new Result();
		res.sum = sum(a[0]);
		res.index = 0;

		for (int i = 1; i < a.length; i++) {
			double s = sum(a[i]);
			if (s > res.sum) {
				res.sum = s;
				res.index = i;
			}
		}
		return res;
	}

	// Ham tinh tong cac phan tu tren cot
	public static double sumCol(double[][] a, int col) {
		double s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[i][col];
		}
		return s;
	}

	// Tim cot co tong nho nhat va tong
	public static Result minCol(double[][] a) {
		Result res = new Result();
		res.index = 0;
		res.sum = sumCol(a, 0);
		for (int j = 1; j < a[0].length; j++) {
			double s = sumCol(a, j);
			if (s < res.sum) {
				res.sum = s;
				res.index = j;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		double[][] a = init();
		System.out.println("Mang da duoc khoi tao:");
		display(a);
		Result res = maxRow(a);
		System.out.println("Dong co tong lon nhat la: " + res.index);
		System.out.println("Tong do la: " + res.sum);

		Result res2 = minCol(a);
		System.out.println("Cot co tong nho nhat la: " + res2.index);
		System.out.println("Tong do la: " + res2.sum);
	}
}
