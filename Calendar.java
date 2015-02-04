//This Java program checks what day of the week the first day of the given 
//month is for the given year between 1900 and 2100.
import java.util.*;

public class Calendar {
	
	static int index = 0;
	static int year = 0;
	static int[] month = {11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int day = 0;
	static boolean leap = false;
	
	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);
		
		introduction();
		year(console);
		month(console);
		day(console);
		weekDay(day, month[index - 1], year);
	}
	
	//This method simply introduces what the Java program does.
	public static void introduction() {
		System.out.println("This program simply takes in the year, month, and day"
				+ " given\nby the user, and prints out the day of the week it was.\n");
	}
	
	//This method checks to see if the year is within the correct range.
	public static void year(Scanner console) {
		do {
			System.out.print("Please enter a year between 1900 and 2100: ");
			year = console.nextInt();
		} 
		while (year < 1900 || year > 2100);
		
		leap = ((year % 400 == 0 || year % 100 != 0) && year % 4 == 0);
	}
	
	//This method checks to see if the month is within the correct range.
	public static void month(Scanner console) {
		do {
			System.out.print("Please enter a month: ");
			index = console.nextInt();
		} 
		while (index < 1 || index > 12);
	}
	
	//This method checks to see whether the given day is available for the month.
	public static void day(Scanner console) {
		int[] days = {31, 0, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};
				
		days[1] = leap ? 29 : 28;
		
		do {
			System.out.print("Please enter a day: ");
			day = console.nextInt();
		}
		while (day < 1 || day > days[index-1]);
	}

	public static void weekDay(int day, int month, int year) {
		String[] weekDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		if (month == 11 || month == 12)
			year -= 1;
				
		int c = year % 100;
		int d = year / 100;
		
		int z = (((13 * month - 1) / 5) + (c / 4) + (d / 4) + day + c - (2 * d));
		int r = z % 7;
				
		System.out.println("\nThat day is a " + weekDay[r]);
	}
}