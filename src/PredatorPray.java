
import java.util.Random;
import java.awt.Point;

public class PredatorPray {
	
	public static void main(String[] args) {
		
		runSimulation(10, 5, 10);
		
	}
	
	
	public static void runSimulation(int n, int s, int t) {
		System.out.println("n=" + n + " s=" + s + " t=" + t);
		if (n <= 0 || s <= 0 || t < 0) {
			System.out.println("Illegal Parameters!");
		}
		
		Random rand = new Random();
		
		//random starting positions of prey and predator
		Point prey = new Point(rand.nextInt(n)+1, rand.nextInt(n)+1); //we want the interval [1;n]
		Point predator = new Point(rand.nextInt(n)+1, rand.nextInt(n)+1);
		int mover = newMover(rand, s); //generates a new value to add to the beasts
		
		printPositions(prey, predator); //prints the initial positions of the beasts
		
		for (int i = 1; i <= t; i++) {
			moveBeast(prey, predator, mover, i, n); //since prey moves first, then modulo 2 can itself switch between beasts to move
			mover = newMover(rand, s);
			
			printPositions(prey, predator); //task specifies that the positions of both beasts are printed "after each move"
			
			checkCollision(prey, predator);
		}
	}
	
	public static int newMover(Random rand, int s) {
		int randPos = rand.nextInt(s+1); //random movement value in the interval [0;s]
		int randBool = rand.nextBoolean() ? 1 : 0; //gives 1, if true and 0 if not
		int randMove = randPos - 2 * randPos * randBool; //finally a pseudo-random value between [-s;s]
		
		return randMove;
	}
	
	public static void moveBeast(Point prey, Point predator, int mover, int turn, int gridSize) {
		if (turn % 2 == 1) { //checks whether to move the prey or the predator
			
			if (prey.x + mover <= gridSize) {
				prey.x += mover;
			} else {
				prey.x = gridSize;
			}
			
			if (prey.y + mover <= gridSize) {
				prey.y += mover;
			} else {
				prey.y = gridSize;
			}
			
		}
		else {
			//the task seems to specify that the mover is added to the coords, and not that the distance moved has to max be 'mover'
		}
	}
	
	public static void printPositions(Point prey, Point predator) {
		System.out.println("[" + prey.x + ";" + prey.y + "] [" + predator.x + ";" + predator.y + "]");
	}
	
	public static void checkCollision(Point prey, Point predator) {
		if (prey.x == predator.x && prey.y == predator.y) {
			System.out.println("Caught!");
			System.exit(0);
		}
	}
	
}
