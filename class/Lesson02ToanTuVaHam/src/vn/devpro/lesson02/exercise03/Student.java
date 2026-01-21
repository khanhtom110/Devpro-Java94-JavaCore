package vn.devpro.lesson02.exercise03;

public class Student {
	String code;
	String firstName;
	String lastName;
	String dateOfBirth;

	Subject s1 = new Subject();
	Subject s2 = new Subject();
	Subject s3 = new Subject();
	Subject s4 = new Subject();
	Subject s5 = new Subject();

	public static Student input() {
		Student st = new Student();
		System.out.println("Nhap thong tin mon thu nhat");
		st.s1 = Subject.input();
		System.out.println("Nhap thong tin mon thu hai");
		st.s2 = Subject.input();
		System.out.println("Nhap thong tin mon thu ba");
		st.s3 = Subject.input();
		System.out.println("Nhap thong tin mon thu bon");
		st.s4 = Subject.input();
		System.out.println("Nhap thong tin mon thu nam");
		st.s5 = Subject.input();

	}

	public static void display(Student st) {
//		BANG DIEM CA NHAN
//		Ma sinh vien: xxxxxx
//		Ho va ten: Nguyen Van A
//		Ngay sinh: xx/xx/xxxx
//		Danh sach diem cac mon hoc:
//		Ma mon  Ten mon    So tin chi  Diem
//		...
//		Diem tong ket: x.xx
	}
}
