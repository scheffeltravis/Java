//This Java program takes in either an integer or binary number and converts it to 
//the other.

import java.util.*;

public class BinaryConverter {
	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);
		System.out.print("Would you like to convert an integer or binary number? ");
		
		String input = console.nextLine().toLowerCase();
		
		if (input.contains("integer") && input.contains("binary"))
			System.out.println("You must choose one or the other.");
		else if (input.contains("integer"))
			convertInteger(console);
		else if (input.contains("binary"))
			convertBinary(console);
		else 
			System.out.println("You must choose either an integer or binary number!");
	}
		
	public static void convertBinary(Scanner console) {
		System.out.print("Please enter a binary number: ");
		if (console.hasNextInt())
			integerNumber(console.next());
		else 
			System.out.println("You did not enter a binary number!");
	}
	
	public static void integerNumber(String binary) {
		int integer = 0;
		
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '0')
				integer += 0;
			else if (binary.charAt(i) == '1')
				integer += Math.pow(2, (binary.length() - i - 1));
		}
		System.out.println("Integer: " + integer);
	}
	
	public static void convertInteger(Scanner console) {
		
		System.out.print("Please enter a nonnegative integer: ");
		if (console.hasNextLong())
			binaryNumber(console.nextLong());
		else 
			System.out.println("You did not enter an integer!");
	}
	
	public static void binaryNumber(long number) {
		String binary = "";
		
		if (number > 0) {
			while (number != 0) {
				binary = (number % 2) + binary;
				number /= 2;
			}
			System.out.println("Binary: " + binary);
		}
		else 
			System.out.println("You did not enter a NONNEGATIVE integer!");
	}
}