package vn.devpro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.LoanDetail;

public class LoanDetailService {
	static Scanner sc = new Scanner(System.in);

	public static void save(LoanDetail loanDetail) {
		// TODO Auto-generated method stub
		LibraryDb.getLoanDetails().add(loanDetail);
	}

	public static List<LoanDetail> findById(int id) {
		// TODO Auto-generated method stub
		List<LoanDetail> loanDetails = new ArrayList<LoanDetail>();
		for (LoanDetail loanDetail : LibraryDb.getLoanDetails()) {
			if (loanDetail.getLoanReceiptId() == id) {
				loanDetails.add(loanDetail);
			}
		}
		return loanDetails;
	}

}
