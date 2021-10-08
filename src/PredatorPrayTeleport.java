import java.awt.Point;
import java.util.Random;

public class PredatorPrayTeleport {

	public static void main(String[] args) {
		runSimulation(10000, 3, 10);
	}
	
	
	public static void runSimulation(int n, int s, int t) {
		System.out.println("n=" + n + " s=" + s + " t=" + t);
		if (n <= 0 || s <= 1 || t < 0) { //'s' must now be 2 or more, therefore <= 1 is an illegal parameter
			System.out.println("Illegal Parameters!");
			System.exit(0); //this terminates the program
		}
		
		Random rand = new Random();
		
		//random starting positions of prey and predator
		Point prey = new Point(rand.nextInt(n), rand.nextInt(n));
		Point predator = new Point(rand.nextInt(n), rand.nextInt(n));
		
		printPositions(prey, predator); //prints the initial positions of the beasts
//		System.out.println();
		
		for (int i = 1; i <= t; i++) {
			moveBeast(prey, predator, rand, n-1, s, i); //since prey moves first, then modulo 2 can itself switch between beasts to move
//			mover = RNG(rand, s); //generates a new random mover-value
			
//			if (i % 2 == 0) {
				printPositions(prey, predator); //task specifies that the positions of both beasts are printed "after each move"
//				checkCollision(prey, predator);
//			}
			
			checkCollision(prey, predator);
		}
	}
	
	public static int RNG(Random rand, float value) { //just used for generating random values for 's'
		int randPositive = rand.nextInt((int) value+1); //random movement value in the interval [0;value]
		int randBool = rand.nextBoolean() ? 1 : 0; //gives 1, if true and 0 if not
		int rngValue = randPositive - 2 * randPositive * randBool; //finally a pseudo-random value between [-value;value]
		
		return rngValue;
	}
	
	public static void moveBeast(Point prey, Point predator, Random rand, int gridSize, int s, int turn) {
		
		if (prey.x % s == 0 && prey.x != 0 && prey.y % s == 0 && prey.y != 0) { //first teleport right away, if possible
			prey.x = rand.nextInt(gridSize);
			prey.y = rand.nextInt(gridSize);
			
//				System.out.println("Prey teleportet to: [" + prey.x + "," + prey.y + "] !");
		}
		else { //if teleporting is not an option, move like normal
			prey.x += RNG(rand, s); //moves prey using the randomized value
			prey.y += RNG(rand, s); //same value is added to *both* coordinates, as was expressly specified in the task
			
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
