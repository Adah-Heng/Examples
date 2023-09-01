package zoo.animal;

/**
 * @author adheng01
 * Is a certain type of fish and uses fish as a base and uses fly.
 */
public class FlyingFish extends Fish implements Fly{

	/**
	 * If the fish is a flying fish.
	 */
	private final String type = "flying fish";

	/**
	 * The default class from fish.
	 */
	public FlyingFish() {
		super();
	}

	/**
	 * @param <T>
	 * @param The flying fish's birth date.
	 * @param The flying fish's weight.
	 * @throws Exception for the wrong birth date and the wrong weight.
	 */
	public <T> FlyingFish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The flying fish's birth date.
	 * @param The flying fish's weight.
	 * @param The water type.
	 * @throws Exception for the wrong birth date, weight, and water type.
	 */
	public <T> FlyingFish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight, water);
	}

	/**
	 * The over ride for flying fish's id and the type.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

	/**
	 * The over ride for to see if the flying fish is eating.
	 */
	@Override
	public void eat()	{
		System.out.println("This " + this.type + " is eating...");
	}

	/**
	 * To see if the fish is flying.
	 */
	@Override
	public void flying()	{
		System.out.println("This " + this.type + " is flying...");
	}

	/**
	 * To see if the fish is soaring.
	 */
	@Override
	public void soaring()	{
		System.out.println("This " + this.type + " is soaring...");
	}

	/**
	 * To see if the fish is soaring.
	 */
	@Override
	public void gliding()	{
		System.out.println("This " + this.type + " is gliding...");
	}


}

