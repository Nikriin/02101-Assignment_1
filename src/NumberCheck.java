
public class NumberCheck {

	public static void main(String[] args) {
		//doing a little thinking, to figure out a possible solution:
		
		//start a for-loop to split 'number' into digits - but every 2nd digit is used as is
		//use substring to split 'number' into each "digit" (it's still a string, so they're not digits yet)
		//use parseInt() or valueOf() to get the value of each "digit" - 
		
		//repeat the above section until the entire number is processed 
		
		
		//start computing cross sum:
		
		//double the first digit - if >10, then (mod 10) + 1 (fx. 7 becomes ((7*2) mod 10) + 1)
		//potentially store each new digit in another int[] for debug purposes
		//add the new digits together
		//determine (crossSum mod 10 == 0): return boolean value of this
		
		//don't know if the string will contain a negative numbers
		//not sure how those should be handled - should they be treated as invalid inputs?
		//Or maybe I should just use the absolute value of it
		//would also need to make sure the length doesn't count the negative sign ._.
		
		
//		String num = "1234";
//		String firstNum = num.substring(0,1);
//		int firstInt = Integer.valueOf(firstNum);
//		System.out.println(firstInt);
		
		System.out.println(check("41032111"));
	}
	
	public static boolean check(String number) {
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
				if (digits[j] * 2 >= 10) { //
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
