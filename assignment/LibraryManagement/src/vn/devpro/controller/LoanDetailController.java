package vn.devpro.controller;

import java.util.List;
import java.util.Scanner;

import vn.devpro.model.LoanDetail;
import vn.devpro.model.LoanReceipt;
import vn.devpro.service.LoanDetailService;
import vn.devpro.service.LoanReceiptService;

public class LoanDetailController {
	static Scanner sc = new Scanner(System.in);

	public static void read() {
		System.out.print("\tNhap ma phieu: ");
		int id = Integer.parseInt(sc.nextLine());
		LoanReceipt loanReceipt = LoanReceiptService.getById(id);
		if (!LoanReceiptService.existsById(id)) {
			System.out.println("\tMa phieu khong ton tai");
			return;
		}
		loanReceipt.display();
		List<LoanDetail> loanDetails = LoanDetailService.findById(id);
		System.out.printf("%3s %-35s %-25s %-15s %10s%n", "ID", "Ten sach", "Tac gia", "Ten the loai", "Ngay tra");
		for (LoanDetail detail : loanDetails) {
			detail.display();
		}
	}

	public static void delete() {
		// TODO Auto-generated method stub
		System.out.print("\tNhap ma phieu: ");
		int id = Integer.parseInt(sc.nextLine());
		LoanReceipt loanReceipt = LoanReceiptService.getById(id);
		if (!LoanReceiptService.existsById(id)) {
			System.out.println("\tMa phieu khong ton tai");
			return;
		}
		LoanReceiptService.delete(id);
		System.out.println("\tDa xoa thanh cong!");
	}

}
