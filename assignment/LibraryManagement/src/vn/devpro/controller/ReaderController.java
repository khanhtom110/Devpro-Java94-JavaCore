package vn.devpro.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Reader;
import vn.devpro.service.ReaderService;

public class ReaderController {
	public static Scanner sc = new Scanner(System.in);

	public static void execute() {

		do {
			System.out.println("\t\tCAP NHAT THONG TIN NGUOI DOC");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1.Hien thi danh sach");
			System.out.println("\t2.Them moi");
			System.out.println("\t3.Sua thong tin");
			System.out.println("\t4.Xoa thong tin");
			System.out.println("\t5.Sap xep");
			System.out.println("\t0.Quay lai");
			System.out.print("Lua chon cua ban la: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				read();
				break;
			case 2:
				create();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				sort();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le, xin chon lai");
			}
		} while (true);

	}

	private static void read() {
		// TODO Auto-generated method stub
		List<Reader> readers = ReaderService.findAll();
		System.out.println("\t\tDANH SACH NGUOI DOC");
		System.out.printf("%3s %17s %-25s %10s %9s %8s%n", "ID", "Ma nguoi doc", "Ho va ten", "Ngay sinh", "Gioi tinh",
				"Hoc sinh");
		for (Reader reader : readers) {
			reader.display();
		}
	}

	private static void create() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tTHEM MOI NGUOI DOC");
		System.out.print("\tNhap ho nguoi doc: ");
		String firstName = sc.nextLine();
		if (firstName == null || firstName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}

		System.out.print("\tNhap ten nguoi doc: ");
		String lastName = sc.nextLine();
		if (lastName == null || lastName.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}
		String name = firstName + " " + lastName;

		if (ReaderService.existsByName(name)) {
			// Ten nguoi doc co the trung nhau nen hoi nguoi quan tri de xac nhan lai
			int tmp;
			System.out.print("\tTen da ton tai, ban co muon huy hay khong(1-co,2-khong): ");
			tmp = Integer.parseInt(sc.nextLine());
			if (tmp == 1) {
				return;
			}
		}

		System.out.print("\tNhap ngay sinh: ");
		String dateOfBirth = sc.nextLine();
		if (dateOfBirth == null || dateOfBirth.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}

		System.out.print("\tNhap gioi tinh: ");
		String gender = sc.nextLine();
		if (gender == null || gender.trim().length() <= 0) {
			System.out.println("\tKhong duoc de trong");
			return;
		}

		System.out.print("\tNguoi doc co phai hoc sinh khong (1-co,2-khong): ");
		boolean isStudent = false;
		int choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			isStudent = true;
		}

		Reader reader = new Reader();
		reader.setId(LibraryDb.getReaderId());
		reader.setCode("RD" + new Date().getTime() + LibraryDb.getReaderId());
		reader.setFirstName(firstName);
		reader.setLastName(lastName);
		reader.setDateOfBirth(dateOfBirth);
		reader.setGender(gender);
		reader.setStudent(isStudent);
		LibraryDb.setReaderId(LibraryDb.getReaderId() + 1);

		ReaderService.save(reader);
		System.out.println("Tao nguoi doc thanh cong");
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tSUA THONG TIN NGUOI DOC");
		System.out.print("\tNhap ma nguoi doc can sua: ");
		String code = sc.nextLine();
		Reader reader = ReaderService.getByCode(code);
		if (reader == null) {
			System.out.println("Khong ton tai");
			return;
		}

		int choose;
		System.out.print("\tBan co muon sua ho va ten khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ho: ");
			String firstName = sc.nextLine();
			if (firstName == null || firstName.trim().length() <= 0) {
				System.out.println("\tKhong duoc de trong");
				return;
			}

			System.out.print("\tNhap ten: ");
			String lastName = sc.nextLine();
			if (lastName == null || lastName.trim().length() <= 0) {
				System.out.println("\tKhong duoc de trong");
				return;
			}
			String name = firstName + " " + lastName;

			if (ReaderService.existsByName(name)) {
				// Ten nguoi doc co the trung nhau nen hoi nguoi quan tri de xac nhan lai
				int tmp;
				System.out.print("\tTen da ton tai, ban co muon huy hay khong(1-co,2-khong): ");
				tmp = Integer.parseInt(sc.nextLine());
				if (tmp == 1) {
					return;
				}
			}

			reader.setFirstName(firstName);
			reader.setLastName(lastName);
		}

		System.out.print("\tBan co muon sua ngay sinh khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap ngay sinh: ");
			String dateOfBirth = sc.nextLine();
			if (dateOfBirth == null || dateOfBirth.trim().length() <= 0) {
				System.out.println("\tKhong duoc de trong");
				return;
			}

			reader.setDateOfBirth(dateOfBirth);
		}

		System.out.print("\tBan co muon sua gioi tinh khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			System.out.print("\tNhap gioi tinh: ");
			String gender = sc.nextLine();
			if (gender == null || gender.trim().length() <= 0) {
				System.out.println("\tKhong duoc de trong");
				return;
			}

			reader.setGender(gender);
		}

		System.out.print("\tNguoi do co phai hoc sinh khong (1-co, 0-khong): ");
		choose = Integer.parseInt(sc.nextLine());
		if (choose == 1) {
			reader.setStudent(true);
		} else {
			reader.setStudent(false);
		}

		ReaderService.update(reader);
		System.out.println("Sua thong tin nguoi doc thanh cong");
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\tXOA THONG TIN NGUOI DOC");
		System.out.print("\tNhap ma nguoi doc can xoa: ");
		String code = sc.nextLine();
		int index = ReaderService.findByCode(code);
		if (index == -1) {
			System.out.println("Ma nguoi doc khong chinh xac");
			return;
		}
		ReaderService.delete(index);
		System.out.println("Xoa nguoi doc thanh cong!");
	}

	private static void sort() {
		// TODO Auto-generated method stub
		ReaderService.sort();
		read();
	}

}
