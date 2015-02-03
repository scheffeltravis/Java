//This Java program estimates the value of pi by taking the ratio of imaginary darts 
//which hit a square board with the unit circle inscribed within it.
import java.util.*;
import java.text.*;

public class CalculatePi {
	public static void main(String[] arguments) {
		DecimalFormat df = new DecimalFormat("#.000000");
		Random randomGen = new Random();
		Scanner console = new Scanner(System.in);
		
		System.out.print("How many darts would you like to throw? ");
		int numThrows = console.nextInt();
		
		int inside = 0;
		
		for (int i = numThrows; i >= 0; i--) {
			double xPos = randomGen.nextDouble() * 2 - 1.0;
			double yPos = randomGen.nextDouble() * 2 - 1.0;
			
			if (isInside(xPos, yPos))
				inside++;
		}
		
		double calculatedPi = 4 * computePi(numThrows, inside);
		
		System.out.println("\nCalculated Pi = " + calculatedPi);
		System.out.println("Difference = " + df.format(calculatedPi - Math.PI));
	}
	
	//This method checks to see if the imaginary dart is within the circle on the board.
	public static boolean isInside(double xPos, double yPos) {
		return (Math.sqrt(xPos * xPos + yPos * yPos) <= 1.0);
	}
	
	//This method computes Pi based on the number of imaginary darts inside the circle, 
	//divided by the number of darts outside of the circle.
	public static double computePi(int numThrows, int inside) {
		return ((double)inside / numThrows);
	}
}