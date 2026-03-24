package vn.devpro.lesson10.streamdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StreamDemo {
	static Scanner sc = new Scanner(System.in);

	// Hàm ghi các ký tự vào file văn bản
	public static void writeCharacterToTextFile(String path) {
		File file = new File(path);

		if (file.exists()) {
			System.out.println("File da ton tai");
			return;
		}

		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(file);
			for (char c = 'a'; c <= 'z'; c++) {
				fout.write(c);
				fout.write(32); // Ghi dau cach
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	public static void readCharacterToTextFile(String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File chua ton tai");
			return;
		}

		FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);
			for (int c = fin.read(); c != -1;) {
				System.out.print((char) c);
				c = fin.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	// Ghi dữ liệu số ra file nhị phân
	public static void writeNumberToBinaryFile(String path) {
		File file = new File(path);

		if (file.exists()) {
			System.out.println("File da ton tai");
			return;
		}

		FileOutputStream fout = null;
		DataOutputStream dout = null;
		int n = 1000;
		float f = 234.34F;
		double k = -61617.4;
		try {
			fout = new FileOutputStream(file);
			dout = new DataOutputStream(fout);
			dout.writeInt(n);
			dout.writeFloat(f);
			dout.writeDouble(k);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				dout.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	// Nếu không biết kiểu dữ liệu của các number thì không thể đọc được
	public static void readNumberToBinaryFile(String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File chua ton tai");
			return;
		}

		FileInputStream fin = null;
		DataInputStream din = null;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			System.out.println("n = " + din.readInt());
			System.out.println("f = " + din.readFloat());
			System.out.println("k = " + din.readDouble());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				din.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	// Ghi dữ liệu Object ra file nhị phân
	public static void writeObjectToBinaryFile(String path) {
		File file = new File(path);

		if (file.exists()) {
			System.out.println("File da ton tai");
			return;
		}

		FileOutputStream fout = null;
		ObjectOutputStream dout = null;
		Student student = new Student("Ngoc Trinh", 18, "Female");
		try {
			fout = new FileOutputStream(file);
			dout = new ObjectOutputStream(fout);
			dout.writeObject(student);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				dout.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	public static void readObjectToBinaryFile(String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File chua ton tai");
			return;
		}

		FileInputStream fin = null;
		ObjectInputStream din = null;
		try {
			fin = new FileInputStream(file);
			din = new ObjectInputStream(fin);
			Student student = (Student) din.readObject();
			System.out.println(student.toString());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong tim thay class");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Khong tim thay file");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				din.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi dong file");
			}
		}
	}

	// Ghi dữ liệu chuỗi ra file text
	public static void writeLine(String path) {
		File file = new File(path);
		FileWriter fw = null;
		BufferedWriter buff = null;
		try {
			fw = new FileWriter(file);
			buff = new BufferedWriter(fw);
			buff.write("Trong dam gi dep bang sen\n");
			buff.write("La xanh bong trang la chen nhuy vang\n");
			buff.write("Nho vang bong trang la xanh\n");
			buff.write("Gan bun ma chang hoi tanh mui bun\n");
		} catch (IOException e) {
			System.out.println("Loi duong dan");
		} finally {
			try {
				buff.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readLine(String path) {
		File file = new File(path);
		FileReader fr = null;
		BufferedReader buff = null;
		try {
			fr = new FileReader(file);
			buff = new BufferedReader(fr);
			String s = buff.readLine();
			while (s != null) {
				System.out.println(s);
				s = buff.readLine();
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Loi duong dan");
		}
	}

	public static void main(String[] args) {
//		String path = "D:\\Java94\\letter.txt";
//		writeCharacterToTextFile(path);
//		readCharacterToTextFile(path);

//		String path = "D:\\Java94\\number.bin";
//		writeNumberToBinaryFile(path);
//		readNumberToBinaryFile(path);

//		String path = "D:\\Java94\\student.dat";
//		writeObjectToBinaryFile(path);
//		readObjectToBinaryFile(path);

		String path = "D:\\Java94\\baitho.txt";
//		writeLine(path);
		readLine(path);
	}

}
