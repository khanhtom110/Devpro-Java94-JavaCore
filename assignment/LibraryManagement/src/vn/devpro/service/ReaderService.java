package vn.devpro.service;

import java.util.List;

import vn.devpro.database.LibraryDb;
import vn.devpro.model.Reader;

public class ReaderService {

	public static List<Reader> findAll() {
		// TODO Auto-generated method stub
		return LibraryDb.getReaders();
	}

	public static boolean existsByName(String name) {
		// TODO Auto-generated method stub
		for (Reader reader : LibraryDb.getReaders()) {
			String currentName = reader.getFirstName() + " " + reader.getLastName();
			if (currentName.equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void save(Reader reader) {
		// TODO Auto-generated method stub
		LibraryDb.getReaders().add(reader);
	}

	public static Reader getByCode(String code) {
		// TODO Auto-generated method stub
		for (Reader reader : LibraryDb.getReaders()) {
			if (reader.getCode().equals(code)) {
				return reader;
			}
		}
		return null;
	}

	public static void update(Reader reader) {
		// TODO Auto-generated method stub
		int index = findByCode(reader.getCode());
		if (index == -1) {
			System.out.println("Khong ton tai");
			return;
		}
		LibraryDb.getReaders().set(index, reader);
	}

	public static int findByCode(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getReaders().size(); i++) {
			if (LibraryDb.getReaders().get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		LibraryDb.getReaders().remove(index);
	}

	public static void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < LibraryDb.getReaders().size() - 1; i++) {
			for (int j = LibraryDb.getReaders().size() - 1; j > i; j--) {
				Reader currentReader = LibraryDb.getReaders().get(j);
				Reader previousReader = LibraryDb.getReaders().get(j - 1);
				if (currentReader.getLastName().compareTo(previousReader.getLastName()) < 0) {
					Reader tmp = previousReader;
					LibraryDb.getReaders().set(j - 1, currentReader);
					LibraryDb.getReaders().set(j, tmp);
				}
			}
		}
	}

}
