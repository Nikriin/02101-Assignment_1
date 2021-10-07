
import java.util.Arrays;

public class NumberCheck {

	public static void main(String[] args) {
		
		System.out.println(check("23485798846345435787683654535454836783548787374"));
		
	}
	
	public static boolean check(String number) {
		number = number.replaceFirst("^0+(?!$)", ""); //uses neg-lookahead to remove 0's, until it finds a non-zero; then stops replacing
		int[] newNumDigits = toIntArray(number);
		int crossSum = 0;
		
		for (int i = 0; i < newNumDigits.length; i++) { //computes the cross sum
			crossSum += newNumDigits[i];
		}
		
		if (crossSum % 10 == 0) { // determines the final value - is it true or is it false?
			return true;
		} else {
			return false;
		}
	}
	
	public static int[] toIntArray(String input) {
		int[] digits = new int[input.length()]; //will contain the original digits
		int[] newDigits = new int[digits.length]; //will contain the digits after altering them
		
		for (int i = 0; i < input.length(); i++) {
			String charHolder = input.substring(i, i+1); //it's still a string, but only contains a char
			digits[i] = Integer.valueOf(charHolder); //converts the "digit" to an actual integer
		}
		for (int j = 0; j < digits.length; j++) {
			if (j % 2 == 0) {
				if (digits[j] * 2 >= 10) {
				newDigits[j] = ((digits[j] * 2) % 10) + 1;
				} else {
					newDigits[j] = (digits[j] * 2);
				}
			} else {
				newDigits[j] = digits[j]; //every 2nd number is just skipped
			}
		}
		
		return newDigits;
	}

}
