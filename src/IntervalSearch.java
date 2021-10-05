import java.util.Scanner;

public class IntervalSearch {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		int[] input = new int[3];
		
		awaitInput(console, input);
		
		if (!(input[0] <= input[1])) {
			int temp = input[0];
			input[0] = input[1];
			input[1] = temp;
		}
		
		System.out.println(intervalContains(input[0], input[1], input[2]));
		
		console.close();
	}
	
	
	public static void awaitInput(Scanner console, int[] values) {
		values[0] = console.nextInt();
		values[1] = console.nextInt();
		values[2] = console.nextInt();
	}
	
	
	public static boolean intervalContains(int g1, int g2, int b) {
		boolean outcome = false;
		
		for (int i = 0; i <= g2; i++) {
			
			if (Math.pow(b, i) >= g1 && Math.pow(b, i) <= g2) {
				outcome = true;
			}
		}
		
		return outcome;
	}

}
