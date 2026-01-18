package vn.devpro.lesson01.excercise08;

public class StudentManagement {
	public static void main(String[] args) {
		int stt = 1;

		Student student1 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 1:");
		student1.input();

		Student student2 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 2:");
		student2.input();

		Student student3 = new Student();
		System.out.println("Nhap thong tin hoc sinh thu 3:");
		student3.input();

		System.out.printf("%-3s %-15s %-10s %-9s%n", "STT", "Ho va ten", "Ngay sinh", "Tong diem");

		System.out.printf("%-3d", stt++);
		student1.caculation();
		student1.display();

		System.out.printf("%-3d", stt++);
		student2.caculation();
		student2.display();

		System.out.printf("%-3d", stt++);
		student3.caculation();
		student3.display();
	}
}
