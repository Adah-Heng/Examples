package zoo.animal;

/**
 * @author Adahm
 * To create a fish and has different types of water for the fish to live in.
 */
public abstract class Fish extends Animal{

	/**
	 * The type of water that the fish lives in.
	 */
	protected Water water;

	/**
	 * To tell if the animal is a fish.
	 */
	private final String type = "fish";

	/**
	 * The enum to tell which type of water needs to be used.
	 */
	public enum Water	{
		FRESH,
		SALT,
		UNKNOWN
	}

	/**
	 * The default constructor and the type of water.
	 */
	public Fish() {
		super();
		this.water = Water.UNKNOWN;
	}

	/**
	 * @param <T>
	 * @param The fish's birth date.
	 * @param The fish's weight.
	 * @throws Exception for the birth date and the weight if they are incorrectly put in.
	 */
	public <T> Fish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The fish's birth date.
	 * @param The weight of the fish.
	 * @param The type of water.
	 * @throws Exception for the birth date and the weight if they are incorrectly put in.
	 */
	public <T> Fish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	/**
	 * @return the water type either fresh, salt, or unknown.
	 */
	public Water getWater()	{
		return this.water;
	}

	/**
	 * @param <T>
	 * @param The water type.
	 * @throws Exception if anything other than the water types or unknown is entered.
	 */
	public <T> void setWater(T water)	throws Exception{
		if (water instanceof String)	{
			String s = (String) water;

			s = s.toLowerCase();

			switch(s)	{
			case "freshwater":
			case "fresh":
			case "f":
				this.water = Water.FRESH;
				break;
			case "salt":
			case "saltwater":
			case "s":
				this.water = Water.SALT;
				break;
			default:
				this.water = Water.UNKNOWN;
			}
		}else if(water instanceof Water)	{
			Water w = (Water) water;
			this.water = w;
		}else	{
			throw new Exception("Invaid water type: " + water);
		}
	}

	/**
	 * The id of the fish and the type of fish
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}
}
