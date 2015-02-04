//This Java program checks to see if a given credit card number is valid or not.
import java.util.*;

public class LuhnsTest {
	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a 16-digit credit card number: ");
		if (console.hasNextLong())
			verify(console.nextLong());
		else
			System.out.println("This is not a 16-digit number.");
	}
	
	//Verifies whether or not the given input is an integer with 16-digits and then 
	//determines if the number is a valid credit card number or not.	
	public static void verify(long cardNumber) {
		int count = 0;
		int sum = 0;
		
		if (cardNumber > 0 && cardNumber == Math.floor(cardNumber)) {
			while (cardNumber != 0) {
				int digit = (int)(cardNumber % 10);
				cardNumber /= 10;
				count++;
				
				if (count % 2 == 0) {
					digit *= 2;
					
					if (digit > 9)
						digit = digit % 10 + 1;
					
					sum += digit;
				}
				else
					sum += digit;
			}
			
			if (count == 16) {
				if (sum % 10 == 0)
					System.out.println("This is a valid credit card number.");
				else
					System.out.println("This is an invalid credit card number.");
			}
			else 
				System.out.println("This is not a 16-digit number.");
		}
		else
			System.out.println("This is not a 16-digit number.");
	}
}