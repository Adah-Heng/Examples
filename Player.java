/**
 * Class used to create objects for Player
 * @author Adahm and Tim
 *
 */
public class Player {
	
	private static int lastNumber = 0;
	private int playerId;
	private String playerName;
	private int wins;
	private int lowestAttempts;
	private int highestAttempts;
	
	/**
	 * Initializes the fields of the class
	 */
	public Player() {

		this.playerId = ++Player.lastNumber;
		this.playerName = "Unoknwn";
		this.wins = 0;
		this.lowestAttempts = 0;
		this.highestAttempts = 0;
	} 
	
	/**
	 * The overload constructor used to call an already existing player instance
	 * @param playerName
	 */
	public Player(String playerName) {
		this(); 
		
		this.playerName = playerName;
		
	}

	/**
	 * returns player name
	 * @return
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * allows user to put in their name
	 * @param playerName
	 */
	public void setPlayerName(String playerName){
		
		if (playerName == "")	{
			System.out.println("Player name cannot be empty.");
		}
		else
			this.playerName = playerName;
	}

	/**
	 * returns the wins of the player
	 * @return
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * adds wins the player
	 */
	public void addWin() {
		this.wins++;
	}
	
	/**
	 * returns the lowest attempts of the player
	 * @return
	 */
	public int getLowestAttempts() {
		return lowestAttempts;
	}

	/**
	 * sets the lowest and / or highest number of attempts the player has if needed 
	 * @param attempts
	 */
	public void setAttempts(int attempts) {
		//if the player has more attempts than previously recorded, 
		//replace the score with that
		if (attempts > this.highestAttempts) 
			this.highestAttempts = attempts;
		
		//if the player has less attempts than previously recorded, 
		//replace the score with that
		if (attempts < this.lowestAttempts)
			this.lowestAttempts = attempts;
		
		//you can't have a score of 0 attempts, so it defaults to the most 
		//recent score
		else if (this.lowestAttempts == 0)
			this.lowestAttempts = attempts;
	}
	
	/**
	 * returns the highest attempts
	 * @return
	 */
	public int getHighestAttempts() {
		return highestAttempts;
	}

	/**
	 * returns the player ID
	 * @return
	 */
	public int getPlayerId() {
		return this.playerId;
	} 
	
}
