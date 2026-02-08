package vn.devpro.lesson06.exercise03;

import java.util.Scanner;

public class Mark {
	private Student student;
	private Subject[] subjects;

	public void display() {
		System.out.println("\t\tBANG DIEM CA NHAN");
		student.display();
		System.out.printf("%3s %-12s %-25s %15s %15s%n", "STT", "Ma hoc phan", "Ten hoc phan", "So tin chi",
				"Diem hoc phan");
		bubbleSort();
		int stt = 1;
		for (Subject subject : subjects) {
			System.out.printf("%3d ", stt++);
			subject.display();
		}
		System.out.printf("Diem tong ket: %.2f%n", this.totalMark());
	}

	public void bubbleSort() {
		for (int i = 0; i < subjects.length - 1; i++) {
			for (int j = subjects.length - 1; j > i; j--) {
				if (subjects[j].getName().compareTo(subjects[j - 1].getName()) < 0) {
					Subject tmp = subjects[j];
					subjects[j] = subjects[j - 1];
					subjects[j - 1] = tmp;
				}
			}
		}
	}

	public void customDisplay() {
		System.out.println("\t\tDANH SACH HOC PHAN CO DIEM <6");
		System.out.printf("%3s %-12s %-25s %15s %15s%n", "STT", "Ma hoc phan", "Ten hoc phan", "So tin chi",
				"Diem hoc phan");
		int stt = 1;
		for (Subject subject : subjects) {
			if (subject.getMark() < 6) {
				System.out.printf("%3d ", stt++);
				System.out.printf("%-12s %-25s %15.1f %15.2f%n", subject.getId(), subject.getName(),
						subject.getCredit(), subject.getMark());
			}
		}
	}

	public double totalMark() {
		double s = 0;
		double c = 0;
		for (Subject subject : subjects) {
			s += subject.getMark() * subject.getCredit();
			c += subject.getCredit();
		}
		return s / c;
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

	public Mark() {
		super();
	}

	public Mark(Student student, Subject[] subjects) {
		super();
		this.student = student;
		this.subjects = subjects;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}

}
