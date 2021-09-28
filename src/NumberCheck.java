
public class NumberCheck {

	public static void main(String[] args) {
		//doing a little thinking, to figure out a possible solution:
		
		//get the length of 'number', while it's still a string and store it for later
		//store a copy of 'number' as an int (parseInt() or valueOf() will be useful here)
		
		//use mod to divide by the length of 'number' (this gets the first digit - store it in an int[])
		//use substring to remove the first digit from the string and convert to int again
		//use mod of the length/10, in order to get the next digit - store in int[] from before
		
		//repeat the above section until the length is 1 - use the number itself once it is
		
		
		//start computing cross sum:
		
		//double the first digit - if >10, then (mod 10) + 1 (fx. 7 becomes ((7*2) mod 10) + 1)
		//potentially store each new digit in another int[] for debug purposes
		//add the new digits together
		//determine (crossSum mod 10 == 0): return boolean value of this
	}
	
	public static boolean check(String number) {
		return false;
	}

}
