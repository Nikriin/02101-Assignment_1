
import java.util.Random;
import java.awt.Point;


public class PredatorPray {
	
	public static void main(String[] args) {
		runSimulation(100, 2, 5);
	}
	
	
	public static void runSimulation(int n, int s, int t) {
		System.out.println("n=" + n + " s=" + s + " t=" + t);
		if (n <= 0 || s <= 0 || t < 0) {
			System.out.println("Illegal Parameters!");
			System.exit(0);
		}
		
		Random rand = new Random();
		
		//random starting positions of prey and predator
		Point prey = new Point(rand.nextInt(n), rand.nextInt(n));
		Point predator = new Point(rand.nextInt(n), rand.nextInt(n));
		
		printPositions(prey, predator); //prints the initial positions of the beasts
		
		for (int i = 1; i <= t; i++) {
			moveBeast(prey, predator, rand, n-1, s, i); //since prey moves first, then modulo 2 can itself switch between beasts to move
			
//			checkCollision(prey, predator);
			
//			if (i % 2 == 0) {
				printPositions(prey, predator); //task specifies that the positions of both beasts are printed "after each move"
//				checkCollision(prey, predator);
//			}
			
			checkCollision(prey, predator);
		}
	}
	
	public static int RNG(Random rand, float value) {
		int randPositive = rand.nextInt((int) value+1); //random movement value in the interval [0;value]
		int randBool = rand.nextBoolean() ? 1 : 0; //gives 1, if true and 0 if not
		int rngValue = randPositive - 2 * randPositive * randBool; //finally a pseudo-random value between [-value;value]
		
		return rngValue;
	}
	
	public static void moveBeast(Point prey, Point predator, Random rand, int gridSize, int s, int turn) {
		
		prey.x += RNG(rand, s); //moves prey using a random value
		prey.y += RNG(rand, s); //RNG() is called both times, so different values can be added to the coords
		
		//adding random values to the coords means the coords might land out-of-bounds. Therefore this is checked and prey is placed on the edge, if out-of-bounds
		if (prey.x < 0) {
			prey.x = 0;
		} else if (prey.x > gridSize) {
			prey.x = gridSize;
		}
		
		if (prey.y < 0) {
			prey.y = 0;
		} else if (prey.y > gridSize) {
			prey.y = gridSize;
		}
		
		if (Math.abs(prey.x - predator.x) >= s) { //checks if predator can move the full distance of 's'
			if (prey.x - predator.x < 0) { //checks if predator is ahead of behind prey
				predator.x -= s;
			} else {
				predator.x += s;
			}
		} else {
			predator.x += prey.x - predator.x; //adds the amount needed to reach the same x-value as prey
		}
		
		if (Math.abs(prey.y - predator.y) >= s) {
			if (prey.y - predator.y < 0) {
				predator.y -= s;
			} else {
				predator.y += s;
			}
		} else {
			predator.y += prey.y - predator.y; //adds the amount needed to reach the same x-value as prey
		}
	}
	
	public static void checkCollision(Point prey, Point predator) { //simply checks if both beasts have the same coords
		if (prey.x == predator.x && prey.y == predator.y) {
			System.out.println("Catch!");
			System.exit(0);
		}
	}
	
	public static void printPositions(Point prey, Point predator) { //used to keep the for-loop for moves neat and tidy
		System.out.println("[" + prey.x + ";" + prey.y + "]  [" + predator.x + ";" + predator.y + "]");
	}
	
}
