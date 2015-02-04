//This Java program is used to simulate the game show "Let's Make a Deal", in which a user
//is given the choice of three doors and chooses one, hopefully with a prize. This program
//studies the effect of switching your choice after revealing one door.
import java.util.*;
import java.text.*;

public class Deal {
	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);
		Random randomGen = new Random();
		DecimalFormat df = new DecimalFormat("#.000");
		
		System.out.println("Welcome to \"Let's Make a Deal\"! Come on down and figure "
				+ "\nout what magnificent prizes can be won!");		
		System.out.print("\nPlease enter the number of times you wish to play: ");
		int plays = console.nextInt();
		
		System.out.println("\n      Prize           Guess           View          New Guess");
		double wins = 0;
		double prob_1 = 0;
		double prob_2 = 0;
		
		for (int i = 1; i <= plays; i++) {
			int prize = randomGen.nextInt(3) + 1;
			int guess = randomGen.nextInt(3) + 1;
			int view = 0;
			int newGuess = 0;
		
			do {
				view = randomGen.nextInt(3) + 1;
			}
			while (view == prize || view == guess);
		
			do {
				newGuess = randomGen.nextInt(3) + 1;
			}
			while (newGuess == guess || newGuess == view);
			
			if (prize == newGuess) {
				wins++;
				prob_1 = wins / plays;
				prob_2 = 1 - prob_1;
			}
		
			System.out.println("	" + prize + "		" + guess + "		" + view + "		" + newGuess);
		}
		
		System.out.println("\nProbability of winning if you switch: " + df.format(prob_1));
		System.out.println("Probability of winning if you do not switch: " + df.format(prob_2));
	}
}