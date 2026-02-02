package vn.devpro.lesson05.arrayusage;

public class Demo2 {
	public static void change(int n, byte[] b) {
		int i = 0;
		while (n > 0) {
			b[i] = (byte) (n % 2);
			n /= 2;
			i++;
		}
		// Dao nguoc mang b
		int j = 0, k = b.length - 1;
		while (j < k) {
			byte tmp = b[j];
			b[j] = b[k];
			b[k] = tmp;
			j++;
			k--;
		}
	}

	public static void main(String[] args) {
		int n = 156988;
		byte[] b = new byte[32];
		for (int i = 0; i < b.length; i++) {
			b[i] = 0;
		}
		change(n, b);
		System.out.print(n + " = ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
	}
}
