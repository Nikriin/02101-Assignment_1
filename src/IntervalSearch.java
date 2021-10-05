import java.util.Scanner;

public class IntervalSearch {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		int[] input = new int[3];
		
		awaitInput(console, input);
		
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
		
		if (g1 > g2) {
			int temp = g1;
			g1 = g2;
			g2 = temp;
		}
		
		for (int i = 0; i <= g2; i++) {
			double operator;
			
			switch (i) {
				case 0:
					operator = 0;
					
				case 1:
					operator = b;
					
				default:
					operator = Math.pow(b, i);
			}
			
			if (operator >= g1 && operator <= g2) {
				outcome = true;
				break;
			}
		}
		
		return outcome;
	}

}
