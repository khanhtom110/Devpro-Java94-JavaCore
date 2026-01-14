package vn.devpro.lesson01.exercise06;

public class StudentManagement {
	public static void main(String[] args) {
		Student student = new Student();
		student.input();
		System.out.printf("%3s %-25s %-10s %-9s %-7s %-10s%n", "STT", "Ho va ten", "Ngay sinh", "Gioi tinh",
				"Diem trung binh", "XLDD");
		int stt = 1;
		System.out.printf("%3d", stt++);
		student.display();
//		Tao 3 sinh vien roi display 3 sv o cuoi cung
	}

}
