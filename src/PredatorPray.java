
import java.util.Random;

public class PredatorPray {

	public static void main(String[] args) {
		
		
		
	}
	
	public static void runSimulation(int n, int s, int t) {
		System.out.println("n=" + n + "s=" + s + "t=" + t);
		
		Random rand = new Random();
		
		int randPos = rand.nextInt(s+1);
		int randBool = rand.nextBoolean() ? 1 : 0; //gives 1, if true and 0 if not
		int randMove = randPos - 2 * randPos * randBool; //finally a pseudo-random value between [-s;s]
		
		
	}

}
