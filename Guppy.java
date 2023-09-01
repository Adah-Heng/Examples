package zoo.animal;

/**
 * @author Adahm
 * Creates guppies.
 */
public class Guppy extends Fish{

	/**
	 * To see if animal is a guppy.
	 */
	private final String type = "guppy";

	/**
	 * The default construct from animal.
	 */
	public Guppy() {
		super();
	}

	/**
	 * @param <T>
	 * @param The guppy's birth date.
	 * @param The guppy's weight.
	 * @throws Exception for the wrong in put of date for birth date and weight. 
	 */
	public <T> Guppy(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The guppy's birth date.
	 * @param The guppy's weight.
	 * @param The water type.
	 * @throws Exception for the wrong in put of date for birth date, weight,and water type. 
	 */
	public <T> Guppy(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight, water);
	}

	/**
	 * The overload for id of the guppy and the type.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

	/**
	 * If the guppy is eating.
	 */
	public void eat()	{
		System.out.println("This " + this.type + " is eating...");
	}

}
