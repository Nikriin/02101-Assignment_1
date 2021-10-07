
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
//		Point prey = new Point(rand.nextInt(n)+1, rand.nextInt(n)+1); //we want the interval [1;n]
//		Point predator = new Point(rand.nextInt(n)+1, rand.nextInt(n)+1);
		
		Point prey = new Point(RNG(rand, n/2), RNG(rand, n/2));
		Point predator = new Point(RNG(rand, n/2), RNG(rand, n/2));
		
		int mover = RNG(rand, s); //generates a new value to add to the beasts
		
		printPositions(prey, predator); //prints the initial positions of the beasts
		System.out.println();
		
		for (int i = 1; i <= t; i++) {
			moveBeast(prey, predator, mover, i, n/2); //since prey moves first, then modulo 2 can itself switch between beasts to move
			mover = RNG(rand, s); //generates a new random mover-value
			
			printPositions(prey, predator); //task specifies that the positions of both beasts are printed "after each move"
			
			checkCollision(prey, predator);
		}
	}
	
	public static int RNG(Random rand, float value) {
		int randPositive = rand.nextInt((int) value+1); //random movement value in the interval [0;value]
		int randBool = rand.nextBoolean() ? 1 : 0; //gives 1, if true and 0 if not
		int rngValue = randPositive - 2 * randPositive * randBool; //finally a pseudo-random value between [-value;value]
		
		return rngValue;
	}
	
	public static void moveBeast(Point prey, Point predator, int mover, int turn, int gridSize) {
		if (turn % 2 == 1) { //checks whether to move the prey or the predator
			
			prey.x += mover;
			prey.y += mover;
			
			if (prey.x < -gridSize) { //checks if prey is now out-of-bounds and if so, places prey at the edge
				prey.x = -gridSize;
			} else if (prey.x > gridSize) {
				prey.x = gridSize;
			}
			
			if (prey.y < -gridSize) {
				prey.y = -gridSize;
			} else if (prey.y > gridSize) {
				prey.y = gridSize;
			}
			
		}
		else {
			
			float distX = Math.abs(prey.x - predator.x); //distance is always positive
			float distY = Math.abs(prey.y - predator.y); // "
			float diff = 0;
			
			if (predator.x + mover <= distX && predator.y + mover <= distY) { //only move predator, if it brings it closer to prey
				if (distX >= distY && distX > Math.abs(mover)) {
						diff = 1 - (Math.abs(mover - distX)) / distX; //find the max value that can be added to predator.x
						
						predator.x += predator.x * diff; //multiplies by the max value,
						predator.y += predator.y * diff; //to find the value that predator can move
						
						System.out.println("distances: " + distX + " , " + distY);
						System.out.println("mover: " + mover);
						System.out.println("predator moved sideways");
						System.out.println("difference: " + diff);
				}
				else if (distY >= distX && distY > Math.abs(mover)) {
					diff = 1 - (Math.abs(mover - distY)) / distY;
					
					predator.x += predator.x * diff;
					predator.y += predator.y * diff;
					
					System.out.println("distances: " + distX + " , " + distY);
					System.out.println("mover: " + mover);
					System.out.println("predator moved vertically");
					System.out.println("difference: " + diff);
				}
				else { //if prey is not either of the above, it must be within range
					predator.x = prey.x;
					predator.y = prey.y;
					
					System.out.println("distances: " + distX + " , " + distY);
					System.out.println("mover: " + mover);
					System.out.println("predator moved to the prey");
					System.out.println("difference: " + diff);
				}
			}
			else {
				System.out.println("distances: " + distX + " , " + distY);
				System.out.println("mover: " + mover);
				System.out.println("predator didn't move");
			}
			
		    //predator is not allowed out-of-bounds either
			if (predator.x < -gridSize) {
				predator.x = -gridSize;
			} else if (prey.x > gridSize) {
				predator.x = gridSize;
			}
			
			if (predator.y < -gridSize) {
				predator.y = -gridSize;
			} else if (prey.y > gridSize) {
				predator.y = gridSize;
			}
			
			System.out.println();
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
