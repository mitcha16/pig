package project2;
import java.util.Random;
	public class dice {
		private static int sides;
		private static Random random;
		/*creates a 6 sided die*/
		public dice() {
			sides = 6;
			random = new Random();
		}
		/*generates a random number based off of how many sides are on the die*/
		public static int roll() {
			return random.nextInt(sides) + 1;
		}

	}


