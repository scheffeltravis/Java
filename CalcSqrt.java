//This Java program takes in a positive double and uses the Newtonian method to calculate 
//both roots and gives the difference from the accurate roots.
import java.text.DecimalFormat;
import java.util.Scanner;


public class CalcSqrt {
	public static void main(String[] arguments) {
		Scanner console  = new Scanner(System.in);
		System.out.print("Please enter a positive number: ");
		double given = console.nextDouble();
		
		while (given < 0) {
			System.out.println("That is not a positive number.");
			System.out.print("\nPlease enter a positive nmuber: ");
			given = console.nextDouble();
		}
		
		Newt(given);
	}

	//This method takes in the given double and performs the Newtonian method to 
	//calculate the roots.
	public static void Newt(double n) {
		DecimalFormat df = new DecimalFormat("#.00");
		double oldGuess = n / 2.0;
		double newGuess = ((n / oldGuess) + oldGuess) / 2.0;
		double dif = newGuess - Math.sqrt(n);
		
		while (Math.abs(newGuess - oldGuess) > 0) {
			oldGuess = newGuess;
			newGuess = ((n / oldGuess) + oldGuess) / 2.0;
			dif = newGuess - Math.sqrt(n);
		}
		
		System.out.println("\nThe square roots are " + newGuess +  " and " + -newGuess);
		System.out.println("Difference: " + df.format(dif));
	}
}