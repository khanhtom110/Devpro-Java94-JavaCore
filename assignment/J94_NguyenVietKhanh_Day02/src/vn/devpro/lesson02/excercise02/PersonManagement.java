package vn.devpro.lesson02.excercise02;

public class PersonManagement {
	public static void main(String[] args) {
		System.out.println("Nhap thong tin cong dan thu 1: ");
		Person person1 = Person.input();
		System.out.println("Nhap thong tin cong dan thu 2: ");
		Person person2 = Person.input();
		System.out.println("Nhap thong tin cong dan thu 3: ");
		Person person3 = Person.input();

		System.out.printf("%-15s %-15s %-12s %-9s %-25s %-15s%n", "So can cuoc", "Ho va ten", "Ngay sinh", "Gioi tinh",
				"Dia chi", "So dien thoai");
		Person.display(person1);
		Person.display(person2);
		Person.display(person3);

	}
}
