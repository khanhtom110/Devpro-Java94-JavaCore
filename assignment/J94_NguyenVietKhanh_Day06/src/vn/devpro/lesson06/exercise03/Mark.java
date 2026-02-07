package vn.devpro.lesson06.exercise03;

import java.util.Scanner;

public class Mark {
	private Student student;
	private Subject[] subjects;

	public void display() {
		System.out.println("\t\tBANG DIEM CA NHAN");
		student.display();
		System.out.printf("%3s %10s %25s %15s %15s%n", "STT", "Ma hoc phan", "Ten hoc phan", "So tin chi",
				"Diem hoc phan");
		for (Subject subject : subjects) {
			subject.display();
		}
		System.out.printf("Diem tong ket: %.2f%n", this.totalMark());
	}

	public double totalMark() {
		double s = 0;
		for (Subject subject : subjects) {
			s += subject.getMark();
		}
		return s;
	}

	public void editStudent() {
		this.student.edit();
	}

	public void editSubject() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\tNhap ma hoc phan can sua: ");
		String id = sc.nextLine();
		int index = this.findSubjectById(id);
		if (index == -1) {
			System.out.println("\tKhong tim thay hoc phan");
		} else {
			this.subjects[index].edit();
		}
	}

	public int findSubjectById(String id) {
		for (int i = 0; i < subjects.length; i++) {
			if (subjects[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}
