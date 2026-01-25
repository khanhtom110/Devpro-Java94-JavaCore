package vn.devpro.lesson03.switchcasedemo;

public class SwitchCaseDemo {
	public static String nameOfDay(int day) {
		String str;
		switch (day) {
		case 0:
			str = "Sunday";
			break;
		case 1:
			str = "Monday";
			break;
		case 2:
			str = "Tuesday";
			break;
		case 3:
			str = "Wednesday";
			break;
		case 4:
			str = "Thursday";
			break;
		case 5:
			str = "Friday";
			break;
		case 6:
			str = "Saturday";
			break;
		default:
			str = "Invalid day";
		}
		return str;
	}

	public static void main(String[] args) {
		int day = 5;
		System.out.println(nameOfDay(day));
	}
}
