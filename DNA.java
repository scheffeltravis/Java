import java.util.*;

public class DNA {
	public static void main(String[] arguments) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter first DNA strand: ");
		String first = console.next();
		System.out.print("Enter second DNA strand: ");
		String second = console.next();
		
		substrand(first, second);
	}
	
	public static void substrand(String strand1, String strand2) {
		int length = strand1.length();
		ArrayList<String> subs = new ArrayList<String>();
		
		while (length >1) {
			int index = 0;
			
			while (index + length <= strand1.length()) {
				String substrand = strand1.substring(index, (index + length));
				index++;
				
				if (strand2.contains(substrand))
					subs.add(substrand);
			}
			
			length--;
		}
		
		System.out.println("\nCommon Substrands:");
		
		for (int i = 0; i < subs.size(); i++) {
			if (subs.get(0).length() == subs.get(i).length())
				System.out.println(subs.get(i));
		}
	}
}