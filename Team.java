import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of basketball team that is made of multiple players along with the Teams stats.
 * https://github.com/Adah-Heng/Java-projects/tree/main/Section3_BB_ScoreBoard
 * @author adheng01
 *
 */
public class Team {
	
	/**
	 * The team's name.
	 */
	private String name;
	
	/**
	 * The list of players in a team.
	 */
	private List<Player> players;
	
	/**
	 * Creating teams by the team's name and the list of players.
	 */
	public Team() {
		
		this.name = "unkown";  
		this.players = new ArrayList<Player>();
	}
	/**
	 * Overload constructor for team name so you can set the team name.
	 * @param Team name.
	 */
	public Team	(String name) throws Exception	{
		this();
		this.setName(name);
	}
	
	/**
	 *Adds players through overload constructor that allows setting their name and jersey number to.<br>
	 * this method will verify that the jersey number is not already used by another player by calling the Team.getPlayer method.<br>
	 * and if it is, then it will throw an exception back to the calling method.
	 * @param Player name.
	 * @param Player jersey number.
	 * @throws Exception catches if the jersey number is assigned to a player already.
	 */
	public void addPlayer(String name, int jersey) throws Exception	{
		Player dup = this.getPlayer(jersey);
		
		if (dup == null)	{
			this.players.add(new Player(name, jersey));
		} 
		else	{
			throw new Exception("Jersey#" + jersey + "is already assigned to " + dup.getName());
		}
	}
	
	/**
	 * Player by their jersey number using the ArrayList.indexOf method<br>
	 * If the indexOf method returns -1 then this method returns null otherwise,<br>
	 * it returns the Player object associated with the jersey number.
	 * @param Player's jersey number
	 * @return player index
	 * @throws Exception for the jersey number, shot type, and check to see if there are<br>
	 * duplicate jersey number for the players.
	 */
	public Player getPlayer(int jersey) throws Exception {
		
		int index = this.players.indexOf(new Player(jersey));
		
		if (index == -1)	
			return null;
		else 
			return this.players.get(index);
		
	}
	
	/**
	 * Displays each player's detailed stats for the entire Team using the Plyer's getter 
	 * methods.<br>
	 * This method uses printf method for proper stats alignment.
	 */
	public void displayDetailStats()	{
		System.out.println("Jersey Name "  + "          Fouls 1pt2pt3pt Total");
		System.out.println("====== ============== ===== == == == ===========");
		for (int i = 0; i < this.players.size(); i++)	{
			int jersey = players.get(i).getJersey();
			String name = players.get(i).getName();
			int foul = players.get(i).getFoul();
			int freeThrow = players.get(i).getFreeThrow();
			int twoPointer = players.get(i).getTwoPointer();
			int threePointer = players.get(i).getThreePointer();
			int total = players.get(i).getPoints();
			System.out.printf("%2d %8s %13d %4d %2d %2d %10d %n", jersey ,name , foul, freeThrow, twoPointer, threePointer, total);
		}
	}
	
	/**
	 * Displays the team summary using getTeamFouls and getTeamPoints methods.
	 */
	public void displayTeamStats()	{
		System.out.print(name + " has scored " + this.getTeamPoints() + " and has " + this.getTeamFouls() + " fouls.");
	}
	
	/**
	 * Sets the team name.
	 * @param Team name.
	 */
	public void setName(String name)	{
		this.name = name;
	}
	
	/**
	 * Access to team name.
	 * @return Team name.
	 */
	public String getName()	{
		return this.name;
	}
	
	/**
	 * Gets the points from Player get points and adds them together for total amount of points.
	 * @return Team points as teamPoints.
	 */
	public int getTeamPoints()	{
		int teamPoints = 0;
		for (int i = 0; i < this.players.size(); i++)	{
			teamPoints += this.players.get(i).getPoints();
		}
		return teamPoints;
	}
	
	/**
	 * Gets the foul from Player get points and adds them together for total amount of fouls.
	 * @return The teams fouls as teamFouls.
	 */
	public int getTeamFouls()	{
		int teamFouls = 0;
		for (int i = 0; i < this.players.size(); i++)	{
			teamFouls += this.players.get(i).getFoul();
		}
		return teamFouls;
	}
}
