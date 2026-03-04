package vn.devpro.lesson07;

import java.util.Scanner;

public class EmployeeManagement {
	static Scanner sc = new Scanner(System.in);

//	public static void input(Worker[] workers) {
//		/*
//		 * for (int i = 0; i < workers.length; i++) { workers[i] = new Worker();
//		 * System.out.println("Nhap thong tin cong nhan thu " + (i + 1));
//		 * workers[i].input(); }
//		 */
//		workers[0] = new Worker("001", "Nguyen Van", "A", new Date(1, 1, 2000), new Job("CV01", "Ke toan"), 2, 20);
//		workers[1] = new Worker("002", "Nguyen Van", "C", new Date(2, 1, 2000), new Job("CV01", "Ke toan"), 1, 20);
//		workers[2] = new Worker("003", "Nguyen Van", "B", new Date(5, 1, 2000), new Job("CV01", "Ke toan"), 2, 0);
//		workers[3] = new Worker("004", "Nguyen Van", "E", new Date(10, 1, 2000), new Job("CV01", "Ke toan"), 3, 0);
//		workers[4] = new Worker("005", "Nguyen Van", "D", new Date(19, 1, 2000), new Job("CV01", "Ke toan"), 1, 18);
//	}

	public static void display(Worker[] workers) {
		System.out.println("\t\tDANH SACH CONG NHAN");
		System.out.printf("%5s %-24s %10s %-20s %9s %13s%n", "Ma NV", "Ho va ten", "Ngay sinh", "Cong viec",
				"So ngay LV", "Luong");
		for (int i = 0; i < workers.length; i++) {
			workers[i].display();
		}
	}

	/*
	 * public static void displayBySalary(Worker[] workers) {
	 * System.out.println("\t\tDANH SACH CONG NHAN LUONG < 5.000.000");
	 * System.out.printf("%5s %-15s %-8s %10s %9s %13s%n", "Ma NV", "Ho dem", "Ten",
	 * "Ngay sinh", "So ngay LV", "Luong"); for (int i = 0; i < workers.length; i++)
	 * { if (workers[i].salary() < 5000000) workers[i].display(); } }
	 * 
	 * public static Worker[] addWorker(Worker[] workers) { Worker worker = new
	 * Worker("006", "Nguyen Van", "F", new Date(1, 9, 2002), new Job("CV01",
	 * "Ke toan"), 1, 17); Worker[] newWorkers = new Worker[workers.length + 1]; for
	 * (int i = 0; i < workers.length; i++) { newWorkers[i] = workers[i]; }
	 * System.out.print("\tNhap vi tri muon them vao: "); int k =
	 * Integer.parseInt(sc.nextLine()); if (k >= 1 && k <= newWorkers.length - 1) {
	 * for (int i = newWorkers.length - 1; i > k - 1; i--) { newWorkers[i] =
	 * newWorkers[i - 1]; } newWorkers[k - 1] = worker; } else if (k ==
	 * newWorkers.length) { newWorkers[k - 1] = worker; } else {
	 * System.out.println("Vi tri khong hop le"); return workers; } return
	 * newWorkers; }
	 * 
	 * public static double total(Worker[] workers) { double s = 0; for (Worker
	 * worker : workers) { s += worker.salary(); } return s; }
	 * 
	 * public static void changeByWorkingDays(Worker[] workers) { for (int i = 0; i
	 * < workers.length - 1; i++) { for (int j = i + 1; j <= workers.length - 1;
	 * j++) { if (workers[i].getWorkingDays() == 0) { Worker tmp = workers[i];
	 * workers[i] = workers[j]; workers[j] = tmp; } } } }
	 * 
	 * public static void displayByWorkingDays(Worker[] workers) {
	 * System.out.println("\t\tDANH SACH CONG NHAN CO SO NGAY CONG = 0");
	 * System.out.printf("%5s %-15s %-8s %11s %9s %13s%n", "Ma NV", "Ho dem", "Ten",
	 * "Ngay sinh", "So ngay LV", "Luong"); for (int i = 0; i < workers.length; i++)
	 * { if (workers[i].getWorkingDays() == 0) { workers[i].display(); } } }
	 * 
	 * public static void sortByName(Worker[] workers) { for (int i = 0; i <=
	 * workers.length - 2; i++) { for (int j = workers.length - 1; j > i; j--) { if
	 * (workers[j].getLastName().compareTo(workers[j - 1].getLastName()) < 0) {
	 * Worker tmp = workers[j]; workers[j] = workers[j - 1]; workers[j - 1] = tmp; }
	 * } } }
	 */

	public static void main(String[] args) {
		display(Db.getWorkers());

		/*
		 * Worker[] workers = new Worker[5]; input(workers);
		 * 
		 * do { System.out.println("\t\tCHUONG TRINH QUAN LY CONG NHAN");
		 * System.out.println("Moi chon chuc nang");
		 * System.out.println("\t1. Hien thi danh sach cong nhan");
		 * System.out.println("\t2. Hien thi danh sach cong nhan co luong < 5.000.000");
		 * System.out.println("\t3. Them 1 cong nhan moi");
		 * System.out.println("\t4. Tinh tong luong"); System.out.println(
		 * "\t5. Chuyen CN khong di lam xuong cuoi DS && hien thi danh sach cong nhan so ngay cong = 0"
		 * ); System.out.println("\t6. Sap xep danh sach cong nhan theo ten");
		 * System.out.println("\t0. Thoat"); System.out.print("Lua chon cua ban: "); int
		 * choose = Integer.parseInt(sc.nextLine()); switch (choose) { case 1:
		 * display(workers); break; case 2: displayBySalary(workers); break; case 3:
		 * workers = addWorker(workers); display(workers); break; case 4:
		 * System.out.printf("Tong luong cua cac nhan vien la: %,.0f%n",
		 * total(workers)); break; case 5: changeByWorkingDays(workers);
		 * display(workers); displayByWorkingDays(workers); break; case 6:
		 * sortByName(workers); display(workers); break; case 0:
		 * System.out.println("Thoat chuong trinh..."); System.exit(0); default:
		 * System.out.println("Lua chon khong hop le, vui long chon lai"); } } while
		 * (true);
		 */
	}
}
