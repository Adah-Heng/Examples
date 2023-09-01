/**
 * https://github.com/Adah-Heng/Java-projects/tree/main/Section3_BB_ScoreBoard
 * A Player on a basketBall Team plus the player's stats.
 * @author adheng01
 *
 */
public class Player {
	/**
	 * The name of the player.
	 */
	private String name;
	
	/**
	 * The number on the jersey.
	 */
	private int jersey;
	
	/**
	 * The number of fouls the player has.
	 */
	private int foul;
	
	/**
	 * How many free throws the player made.
	 */
	private int freeThrow;// is one point field goal
	
	/**
	 * How many two pointers the player made.
	 */
	private int twoPointer;// is 2 point field goal
	
	/**
	 * How many three pointers the player made.
	 */
	private int threePointer;// is 3 point field goal

	/**
	 * Where the player gets the methods defined and the name set to unknown.
	 */
	public Player()	{
		this.name = "unknown";
		this.jersey = 0;
		this.foul = 0;
		this.freeThrow = 0;
		this.twoPointer = 0;
		this.threePointer = 0;

	}
	
	/**
	 * The overload constructor for Player that makes sure jersey is in range.
	 * @param The player's jersey number.
	 * @throws Exception to find if the player's jersey number is out of range.
	 */
	public Player(int jersey) throws Exception	{
		this();
		this.setJersey(jersey);
	}
	
	/**
	 * Allows creating a player only if setting the jersey number.<br>
	 * This is necessary when trying to find a Player in the Team's ArrayList.<br>
	 * The constructor calls this.setJersey method for data validation.
	 * @param The player's name.
	 * @param The player's jersey number.
	 * @throws Exception to find if the player's jersey number is out of range.
	 */
	public Player(String name, int jersey) throws Exception	{
		this();
		this.setName(name);
		this.setJersey(jersey);
	}
	
	/**
	 * Gets player's name.
	 * @return The player's name.
	 */
	public String getName()	{
		return this.name;
	}
	
	/**
	 * Gets the player's jersey number.
	 * @return The player's jersey number.
	 */
	public int getJersey()	{
		return this.jersey;
	}
	
	/**
	 * Sets the player's name.
	 * @param The player's name.
	 */
	public void setName(String name)	{
		this.name = name;
	}
	
	/**
	 * Gets the player's fouls and adds one if they have one.
	 * @return Player's fouls.
	 */
	public int getFoul(){
		return this.foul;
	}
	
	/**
	 * Sets the jersey number for player if it is between 1-99.
	 * @param Player's jersey number.
	 * @throws Exception to find if the player's jersey number is out of range.
	 */
	public void setJersey(int jersey) throws Exception	{
		if (jersey >= 0 && jersey <= 99)
			this.jersey = jersey;
		else
			throw new Exception("Invaild jersey number. Must be between 0-99");
	}
	
	/**
	 * Gets the number of free throws the player made.
	 * @return Player's free throws.
	 */
	public int getFreeThrow()	{
		return this.freeThrow;
	}
	
	/**
	 *  Gets the number of two pointers the player made.
	 * @return Player's two pointers.
	 */
	public int getTwoPointer()	{
		return this.twoPointer;
	}

	/**
	 *  Gets the number of three pointers the player made by a player.
	 * @return Player's three pointers.
	 */
	public int getThreePointer()	{
		return this.threePointer;
	}
	
	/**
	 * Increments appropriate field goal type using a switch that has error handling to catch<br>
	 * the wrong shot type number.
	 * @param The player's shotType.
	 * @throws Exception to find if the shot type is not valid.
	 */
	public void shot(int shotType) throws Exception	{
		switch (shotType)	{
		case 1: 
			this.freeThrow++;
			break;
		case 2: 
			this.twoPointer++;
			break;
		case 3: 
			this.threePointer++;
			break;
		default: 
			throw new Exception("Invaild shot type:" + shotType);
		}
	}
	
	/**
	 * Runs the equation to find the total points the player made.
	 * @return The equation is returned as this.getPoints.
	 */
	public int getPoints()	{
		return (this.threePointer * 3) + (this.twoPointer * 2) + this.freeThrow;

	}
	
	/**
	 * Displays the player's jersey number, fouls, name, and the calculated getPoint equation.
	 */
	public void displayStats()	{
		System.out.println("Jersey number: " + this.jersey + " name: " 
				+ this.name + " Fouls =" + this.foul + " Points =" + this.getPoints());
	}


	/**
	 * Instead of verifying two players are identical by equal identities.<br>
	 * This method will verify two players are the same ONLY their jersey number.<br>
	 * This allows the ArrayList.getIndex() method to return a player's by only by checking<br>
	 * their jersey number.
	 * @param Object A player object to check equality of ONLY the jersey number.
	 * @param  True if the two player's jersey number are equal.
	 */
	public boolean equals(Object object)	{
		if(!(object instanceof Player))
			return false;

		Player other = (Player)object;

		if(this.jersey== other.getJersey())
			return true;
		else
			return false;
	}
}


