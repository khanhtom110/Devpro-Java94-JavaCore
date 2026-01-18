package vn.devpro.lesson01.exercise06;

public class StudentManagement {
	public static void main(String[] args) {
		Student student1 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 1: ");
		student1.input();

		Student student2 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 2: ");
		student2.input();

		Student student3 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 3: ");
		student3.input();

		System.out.printf("%3s %-25s %-12s %-9s %-7s %-10s%n", "STT", "Ho va ten", "Ngay sinh", "Gioi tinh", "Diem TB",
				"Xep loai");
		int stt = 1;
		System.out.printf("%3d", stt++);
		student1.display();
		System.out.printf("%3d", stt++);
		student2.display();
		System.out.printf("%3d", stt++);
		student3.display();

	}

}
