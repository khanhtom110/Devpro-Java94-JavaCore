package vn.devpro.service;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.LoanReceipt;

public class LoanReceiptService {

	public static void save(LoanReceipt loanReceipt) {
		// TODO Auto-generated method stub
		LibraryDb.getLoanReceipts().add(loanReceipt);
	}

	public static LoanReceipt getById(int loanReceiptId) {
		// TODO Auto-generated method stub
		for (LoanReceipt loanReceipt : LibraryDb.getLoanReceipts()) {
			if (loanReceipt.getId() == loanReceiptId) {
				return loanReceipt;
			}
		}
		return null;
	}

	public static List<LoanReceipt> findAll() {
		List<LoanReceipt> loanReceipts = new ArrayList<LoanReceipt>();
		for (LoanReceipt loanReceipt : LibraryDb.getLoanReceipts()) {
			loanReceipts.add(loanReceipt);
		}
		return loanReceipts;
	}

	public static boolean existsById(int id) {
		// TODO Auto-generated method stub
		for (LoanReceipt loanReceipt : LibraryDb.getLoanReceipts()) {
			if (loanReceipt.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public static void delete(int id) {
		// TODO Auto-generated method stub
		int index = findById(id);
		if (index == -1) {
			System.out.println("\tCo loi xay ra");
			return;
		}
		LibraryDb.getLoanReceipts().remove(index);
	}

	private static int findById(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getLoanReceipts().size(); i++) {
			if (LibraryDb.getLoanReceipts().get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
