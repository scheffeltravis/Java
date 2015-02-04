//This Java program will take the Hailstone Sequence of all numbers in the range given 
//by the user. Then it will print off the number with the largest 
//number of steps within the sequence.
import java.util.*;

public class Hailstone {

	static int start = 0;
	static int end = 0;

	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);

		range(console);
		sequence(start, end);
	}

	//This method asks the user for a range of numbers.
	public static void range(Scanner console) {
		do {System.out.print("Please enter the starting and ending number of the range: ");
		start = console.nextInt();
		end = console.nextInt();
		}
		while (start > end || start < 0);
	}

	//This method calculates the Hailstone sequence of each number in the range.
	public static void sequence(int start, int end) {
		
		int cycleLength = 0;
		int largest = 0;
		
		for (int i = start; i <= end; i++) {
			int n = i;
			int count = 0;
					
			while (n != 1) {
				if (n % 2 == 1)
					n = 3 * n + 1;
				else
					n = n / 2;
				count++;
			}
			
			if (count >= cycleLength) {
				cycleLength = count;
				largest = i;
			}
		}
		
		System.out.println("The number " + largest + " has the longest cycle length of " + cycleLength + ".");
	}
}