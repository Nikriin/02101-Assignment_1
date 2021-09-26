import java.util.Scanner;

public class IntervalSearch {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		int[] input = new int[3]; //for storing the users input values
		
		awaitInput(console, input);
		
		if (!(input[0] <= input[1])) { //ensures that only valid bounds are used, as invalid ones are caught by this
			System.out.println("Invalid interval! Lower boundary was greater than the upper boundary.");
			System.exit(0);
		}
		//(originally tried a try-catch with an assertion, instead of an if-statement
		//but apparently assertions are not exceptions, so they aren't caught
		//if-statement is shorter anyway, but just wanted to try using something I haven't worked with much
		
		System.out.println(intervalContains(input[0], input[1], input[2])); //prints either 'true' or 'false'
		
		console.close(); //this is a zombie-free zone
	}
	
	
	public static void awaitInput(Scanner console, int[] values) {
		values[0] = console.nextInt();
		values[1] = console.nextInt();
		values[2] = console.nextInt();
	}
	
	
	public static boolean intervalContains(int g1, int g2, int b) {
		boolean outcome = false; //starting value - false from the start
		
		for (int i = 0; i <= g2; i++) { //possible solutions must be in the interval [0;g2], therefore stops when out of bounds
			
			if (Math.pow(i, b) >= g1 && Math.pow(i, b) <= g2) { //performs the check specified in the problem
				outcome = true; //sets outcome to 'true' since a valid value for 'i' has been found
			}
		}
		
		return outcome; //return the outcome - which will be true if a valid value was found
	}

}
