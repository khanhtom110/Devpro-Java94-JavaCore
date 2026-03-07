package vn.devpro.lesson08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
	public static void init(ArrayList<Staff> staffs) {
		staffs.add(new Worker("CN01", "Nguyen Van", "A", 2005, "Nam", "Nha may Hoa Lac", "Cong nhan san xuat", 28));
		staffs.add(new Worker("CN02", "Nguyen Van", "C", 2005, "Nam", "Nha may Hoa Lac", "Giam sat", 22));
		staffs.add(new Worker("CN03", "Nguyen Thi", "B", 2005, "Nu", "Nha may Hoa Lac", "Cong nhan san xuat", 23));
		staffs.add(new Worker("CN04", "Nguyen Van", "E", 2005, "Nam", "Nha may Hoa Lac", "Dong goi san pham", 12));
		staffs.add(new Worker("CN05", "Nguyen Thi", "D", 2005, "Nu", "Nha may Hoa Lac", "Giam sat", 18));
		staffs.add(new Manager("CB01", "Trinh Van", "Quyet", 1997, "Nam", "Ke toan", "Truong phong", 1.8, "C"));
		staffs.add(new Manager("CB02", "Trinh Thi", "Thanh", 1997, "Nu", "Ke toan", "Nhan vien", 1.4, "D"));
		staffs.add(new Manager("CB03", "Ngo Van", "Quyen", 1997, "Nam", "Ke toan", "Nhan vien", 1.5, "B"));
		staffs.add(new Manager("CB04", "Trinh Thi Tuyet", "Mai", 1997, "Nu", "Ke toan", "Nhan vien", 2.3, "A"));
		staffs.add(new Manager("CB05", "Phan", "Quan", 1997, "Nam", "Ke toan", "Truong phong", 2.0, "B"));
	}

	public static void display(ArrayList<Staff> staffs) {
		System.out.printf("%-5s %-25s %-8s %-9s %-20s %-25s %-21s %-13s%n", "Ma NV", "Ho va ten", "Nam sinh",
				"Gioi tinh", "Xuong/Phong", "Cong viec/Chuc vu", "HS Luong/So ngay cong", "Luong");
		for (Staff staff : staffs) {
			staff.display();
		}
	}

	public static void displayManWorker(ArrayList<Staff> staffs) {
		System.out.printf("%-5s %-25s %-8s %-9s %-20s %-25s %-21s %-13s%n", "Ma NV", "Ho va ten", "Nam sinh",
				"Gioi tinh", "Xuong/Phong", "Cong viec/Chuc vu", "HS Luong/So ngay cong", "Luong");
		for (Staff staff : staffs) {
			if (staff.gender.equals("Nam") && staff.id.contains("CN"))
				staff.display();
		}
	}

	public static void displayWomanManager(ArrayList<Staff> staffs) {
		System.out.printf("%-5s %-25s %-8s %-9s %-20s %-25s %-21s %-13s%n", "Ma NV", "Ho va ten", "Nam sinh",
				"Gioi tinh", "Xuong/Phong", "Cong viec/Chuc vu", "HS Luong/So ngay cong", "Luong");
		for (Staff staff : staffs) {
			if (staff.gender.equals("Nu") && staff.id.contains("CB"))
				staff.display();
		}
	}

	public static void MaxSalaryManager(ArrayList<Staff> staffs) {
		double max = 0;
		System.out.printf("%-5s %-25s %-8s %-9s %-20s %-25s %-21s %-13s%n", "Ma NV", "Ho va ten", "Nam sinh",
				"Gioi tinh", "Xuong/Phong", "Cong viec/Chuc vu", "HS Luong/So ngay cong", "Luong");
		for (Staff staff : staffs) {
			if (staff instanceof Manager) {
				Manager manager = (Manager) staff;
				if (manager.salary() > max) {
					max = manager.salary();
				}
			}
		}
		for (Staff staff : staffs) {
			if (staff instanceof Manager) {
				Manager manager = (Manager) staff;
				if (manager.salary() == max) {
					staff.display();
				}
			}
		}
	}

	public static void MinSalaryWorker(ArrayList<Staff> staffs) {
		double min = Double.MAX_VALUE;
		System.out.printf("%-5s %-25s %-8s %-9s %-20s %-25s %-21s %-13s%n", "Ma NV", "Ho va ten", "Nam sinh",
				"Gioi tinh", "Xuong/Phong", "Cong viec/Chuc vu", "HS Luong/So ngay cong", "Luong");
		for (Staff staff : staffs) {
			if (staff instanceof Worker) {
				Worker worker = (Worker) staff;
				if (worker.salary() < min) {
					min = worker.salary();
				}
			}
		}
		for (Staff staff : staffs) {
			if (staff instanceof Worker) {
				Worker worker = (Worker) staff;
				if (worker.salary() == min) {
					staff.display();
				}
			}
		}
	}

	public static double TotalManager(ArrayList<Staff> staffs) {
		double res = 0;
		for (Staff staff : staffs) {
			if (staff instanceof Manager) {
				res += ((Manager) staff).salary();
			}
		}
		return res;
	}

	public static double TotalWorker(ArrayList<Staff> staffs) {
		double res = 0;
		for (Staff staff : staffs) {
			if (staff instanceof Worker) {
				res += ((Worker) staff).salary();
			}
		}
		return res;
	}

	public static void ChangeWorker(ArrayList<Staff> staffs) {
		for (int i = 0; i < staffs.size() - 1; i++) {
			for (int j = staffs.size() - 1; j > i; j--) {
				if (staffs.get(j - 1) instanceof Worker && !(staffs.get(j) instanceof Worker)) {
					Staff temp = staffs.get(j);
					staffs.set(j, staffs.get(j - 1));
					staffs.set(j - 1, temp);
				}
			}
		}
	}

	public static void sort(ArrayList<Staff> staffs) {
		Collections.sort(staffs, new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
	}
}
