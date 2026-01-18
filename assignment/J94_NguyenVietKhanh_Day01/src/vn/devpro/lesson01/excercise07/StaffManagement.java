package vn.devpro.lesson01.excercise07;

public class StaffManagement {
	public static void main(String[] args) {
		int stt = 0;
		double sum = 0;

		Staff staff1 = new Staff();
		System.out.println("Nhap thong tin can bo 1:");
		staff1.input();
		sum += staff1.getSalary();

		Staff staff2 = new Staff();
		System.out.println("Nhap thong tin can bo 2:");
		staff2.input();
		sum += staff2.getSalary();

		Staff staff3 = new Staff();
		System.out.println("Nhap thong tin can bo 3:");
		staff3.input();
		sum += staff3.getSalary();

		System.out.printf("%3s %-15s %-10s %-10s %-12s %-10s%n", "STT", "Ho va ten", "Ngay sinh", "So ngay LV",
				"Gio lam them", "Luong");
		System.out.printf("%-3d", stt++);
		staff1.display();
		System.out.printf("%-3d", stt++);
		staff2.display();
		System.out.printf("%-3d", stt++);
		staff3.display();
		System.out.printf("Tong luong: %10.2f", sum);
	}
}
