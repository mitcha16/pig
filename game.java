/*Mitch Ashby
 * CS 121
 * 1/29/2015 
 */
package project2;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
	/*inititalizes variables*/
	static int numDice = 0;
	String name;
	static int result = 0;
	
	static dice Dice;
	static {
		Dice = new dice();
	}
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int numPlayers;
		do {
			System.out
					.println("How many players will be playing this game? You can have anyhere between 2 to 10 players.");
			numPlayers = input.nextInt();
			/*ensures that a valid number of players is entered*/
			if (numPlayers < 2 || numPlayers > 10) {
				System.out.println("That is not a valid number of players.");
			}
		} while (numPlayers < 2 || numPlayers > 10);
		/*uses ArrayLists to store the player names and scores*/
		ArrayList<String> Players = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		System.out
				.println("Enter the names of the players in the order in which you would like to play.");
		/*records the name of the players and adds them to the ArrayList*/
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Enter the name of the next player.");
			Players.add(input.next());
			scores.add(0);

		}
		/*determines what the players will play to*/
		int limit;
		System.out.println("What score would you like to play to?");
		limit = input.nextInt();
		int j = 0;
		/*continues the game until a player wins*/
		while (true) {
			String currentPlayer = Players.get(j);
			System.out.println("It is " + currentPlayer + "'s turn!");
			int score = play();
			if (numDice > 0 && result == numDice) {

				scores.set(j, 0);
				System.out
						.println(currentPlayer
								+ " has rolled all ones! Their score has been reset to 0.");

			}
			int scoreTotal = score + scores.get(j);

			scores.set(j, scoreTotal);

			if (scores.get(j) >= limit) {
				System.out.println(currentPlayer + " has won! Their score was "
						+ scores.get(j));
				System.exit(0);

			}
			int print=0;
			while(print<numPlayers){
			System.out.println(Players.get(print)+":"+scores.get(print));
			print=print+1;
			}
			j = j + 1;
			if (j >= numPlayers) {
				j = 0;
			}
		}

	}
/*the main "game play" method that will roll the appropriate number of dice*/
	public static int play() {
		
		System.out.println("How many dice would you like to roll?");
		numDice = input.nextInt();
		result = 0;
		int Totalresults = 0;
		boolean isOne = true;
		for (int i = 1; i <= numDice; i++) {

			result = Proll();
			
			if (result == 1) {
				isOne = false;
			}

			if (isOne == false) {
				System.out.println("You rolled a one, you recieved 0 points.");
				return 0;
			}

			Totalresults = Totalresults + result;

		}
		System.out.println("You rolled a total of "+Totalresults);
		numDice=0;
		return (Totalresults);
	}
/*roll method that calls the dice class*/
	private static int Proll() {
		int Presult = dice.roll();

		return Presult;
	}

}
