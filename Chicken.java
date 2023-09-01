package zoo.animal;

/**
 * @author Adahm
 * Allows the creation of chickens takes information from bird.
 */
public class Chicken extends Bird{

	/**
	 * Makes sure that the animal is a chicken
	 */
	private final String type = "chicken";

	/**
	 * Takes the default constructor from bird.
	 */
	public Chicken() {
		super();
	}

	/**
	 * @param <T>
	 * @param The birth date of the chicken.
	 * @param The chicken's weight
	 * @throws Exception is when there is a invalid weight and birthday.
	 */
	public <T> Chicken(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The chicken's birth date.
	 * @param The weight of the chicken.
	 * @param The wing span of the chicken.
	 * @throws Exception for the birth date and weight.
	 */
	public <T> Chicken(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	/**
	 * The overload for the id of the chicken and the type.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

	/**
	 * If the chicken is eating.
	 */
	@Override
	public void eat()	{
		System.out.println("This " + this.type + " is eating...");
	}

}
