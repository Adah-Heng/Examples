import java.util.Random; 	//the random library is used to make the number that is guessed
import java.util.Scanner;	//the scanner is used it get the user's input

/**
 * This class contains all of the fields for the game. 
 * The Github for this project is located at https://github.com/tim-t-hoff/HighLowGame.git
 * @author Adahm and Tim
 * 
 */
public class HighLowApp {

	private static Scanner sc = new Scanner(System.in);

	private Player player1;
	private Player player2; 

	private int attempts;
	private int correctAnswer;

	/**
	 * makes a new scanner instance, makes the player instances, and resets the attempts and correctAnswer fields 
	 */
	public HighLowApp() {
		HighLowApp.sc = new Scanner(System.in);

		this.player1 = new Player();
		this.player2 = new Player(); 

		this.attempts = 0;
		this.correctAnswer = 0;

	} //end of HighLowApp

	
	public void displayHeader() {
		System.out.println("=========================================================================");
		System.out.println("|                           High Low Game                               |");
		System.out.println("=========================================================================");
		System.out.println();
		System.out.println("                                Rules:                                   ");
		System.out.println();
		System.out.println("\t1. Two players will take turns guessing a random number.");
		System.out.println("\t2. The players will contunie to guessing the number until \n"
				+ "\t   they get it correct.");
		System.out.println("\t3. The players will know if they are close or not becuase \n"
				+ "\t   it will say if they are frezzing, cold, hot, or boiling.");
		System.out.println("\t4. The first player to get it right will be declared the\n"
				+ "\t   winner of the game.");
		System.out.println("\t5. The game will show the players how many guesses that\n"
				+ "\t   each took before the winner got it right ");
		System.out.println();
		System.out.println("=========================================================================");
		System.out.println();
		System.out.println("Press the Enter key to continue to the game...");
		sc.nextLine();
		System.out.println("=========================================================================");
		System.out.println();
		
	}//end of displayHeader

	/**
	 * sets up the players
	 */
	public void setName(Player player) {
		String userInput = "?";
		boolean running = true;
		System.out.println("Setting up player #" + player.getPlayerId());
		System.out.print("Please enter the player's name: ");
		
		while (running) {
			userInput = sc.nextLine();
			System.out.println();

			try {
				player.setPlayerName(userInput);
			} catch (Exception e) {
				System.out.println("/tERROR! " + e.getMessage());
			}
			
			if (player.getPlayerName().isEmpty())
				System.out.print("Player name cannot be empty. Please input a name: ");
			else
				break;
		}
	}

	public void setupPlayers() {
		this.setName(player1);
		this.setName(player2);
		System.out.println("Let the game begin!");
		
		System.out.println();
		System.out.println("=========================================================================");
		System.out.println();
	}

	/**
	 * The player inputs their guess. The number of attempts for the player is increased, and then 
	 * there is error handling to ensure it is a number. If the user guesses a correct answer, 
	 * the program returns true. If not, the user is told how close they are to the correct number
	 * based off of the text-based heat map. the program then loops
	 * 
	 * @param player
	 * @return 
	 */
	public boolean guess(Player player) {
		int playerGuess = 0;
		int distance = 0;
		String playerName = player.getPlayerName();

		attempts++;

		//logic to ensure the user inputs an integer between 1 and 100
		while(true) {
			System.out.print("What's your guess, " + playerName + ": ");

			while (!sc.hasNextInt()) { //if the scanner doesn't hold an integer, then run the code
				System.out.println("That's not a number!");
				sc.next();// clear invalid data
			}
			playerGuess = sc.nextInt(); //clear the scanner

			if (playerGuess >= 1 && playerGuess <= 100) { //only allow the user to input a number between 1 and 100
				break;
			}
			else {
				System.out.println("ERROR: Please enter a number between 1 - 100");
			}
		}

		if (playerGuess == this.correctAnswer) {
			System.out.println("Correct");
			player.addWin();
			player.setAttempts(this.attempts);
			return true;
		} 

		distance = Math.abs(playerGuess - this.correctAnswer);

		if(distance < 5) 
			System.out.println("You're nearly there! You're boiling");
		else if(distance < 10) 
			System.out.println("You're so close! You're hot");
		else if(distance < 20) 
			System.out.println("You're getting there. You're warm");
		else if(distance < 50) 
			System.out.println("You're not close! You're cold");
		else
			System.out.println("You're way far off! You're freezing");
		System.out.println();
		return false;
		
	}//end of player guess loop

	/**
	 * Displays the statistics
	 */
	public void displayStats() {
		System.out.println();
		System.out.println("=========================================================================");
		System.out.println("|                     High Low Game Player Satistics                    |");
		System.out.println("=========================================================================");
		System.out.println();
		System.out.println("Player       Lowest   Highest  Correct");
		System.out.println("Name         Geusses  Guesses  Guesses");
		System.out.println();
		System.out.printf("%-13s%4d     %4d     %4d\n", player1.getPlayerName(), player1.getWins(),
				player1.getHighestAttempts(), player1.getLowestAttempts()); 
		System.out.printf("%-13s%4d     %4d     %4d\n", player2.getPlayerName(), player2.getWins(), 
				player2.getHighestAttempts(), player2.getLowestAttempts());
		System.out.println();
		System.out.println();
	}

	/**
	 * this first makes the random field set to a Random() object from the java.util.Random library. 
	 * then makes cont = 'yes' and correct = false so the loop continues until a correct answer is 
	 * given. 
	 */
	public void playGame() {
		Random random = new Random();

		String cont = "yes";
		boolean correct = false;

		while (cont.equals("y") || cont.equals("yes")) {

			this.attempts = 0;
			this.correctAnswer = random.nextInt(100) + 1;

			correct = false;

			while (!correct) {
				
				//this if else block is used to determine which player is chosen to play. 
				if (attempts % 2 == 0) 
					correct = this.guess(this.player1);
				else
					correct = this.guess(this.player2);
			}
			
			System.out.println();
			System.out.println("=========================================================================");
			sc.nextLine(); // clear input buffer, leftover from nextInt
			System.out.println();
			System.out.print("Press the Enter key to display the game stats...");
			sc.nextLine(); //makes a pause for the previous statement

			this.displayStats();

			System.out.println("=========================================================================");
			System.out.println();

			while (true) {
				System.out.print("Do you want to play again (y=yes, n=no): ");
				cont = sc.nextLine();
				System.out.println();

				if (cont.equals("y") || cont.equals("yes") || cont.equals("n") || cont.equals("no"))
					break;
				else
					System.out.println("Invalid input! Please try again..");

			} // end of yes / no loop
			
			System.out.println("=========================================================================");
			System.out.println();
			
		} // end of the continue while loop

	} // end of playGame method

	/**
	 * The closing display 
	 */
	public void displayClosing() {
		System.out.println("Good bye " + player1.getPlayerName() + " and " + player2.getPlayerName() + ". I hope you come back soon!");
	}

	public static void main(String[] args) {

		HighLowApp app = new HighLowApp();

		app.displayHeader();

		app.setupPlayers();

		app.playGame();

		app.displayClosing();

		sc.close();

	}//end of main
	
}//end of the class
