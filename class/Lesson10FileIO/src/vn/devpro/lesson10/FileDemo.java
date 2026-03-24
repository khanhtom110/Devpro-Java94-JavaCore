package vn.devpro.lesson10;

import java.io.File;

public class FileDemo {
	public static void createFolder(String path) {
		// Directory-Folder
		File file = new File(path);
		if (file.exists()) {
			System.out.println("Thu muc da ton tai");
		} else if (file.mkdirs()) { // make directory
			System.out.print("Da tao duoc thu muc '" + file.getName() + "'");
			System.out.println(" trong duong dan '" + file.getParent() + "'");
		} else {
			System.out.println("Loi duong dan");
		}
	}

	public static void listOfSubFolderAndFiles(String path) {
		File file = new File(path);
		String[] list = file.list();
		System.out.println("DANH SACH THU MUC CON VA CAC FILE TRONG '" + file.getPath() + "'");
		for (String s : list) {
			System.out.println("\t" + s);
		}
	}

	public static void main(String[] args) {
		String path = "D:/Java94";
		createFolder(path);
	}
}
