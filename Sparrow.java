package zoo.animal;

/**
 * @author Adahm
 * Creates sparrows
 */
public class Sparrow extends Bird implements Fly{

	/**
	 * To see if animal is a sparrow
	 */
	private final String type = "sparrow";

	/**
	 * The default constructor from animal.
	 */
	public Sparrow() {
		super();
	}

	/**
	 * @param <T>
	 * @param The sparrow's birth date.
	 * @param The sparrow's weight.
	 * @throws Exception for the birth date and the weight if it is entered wrong.
	 */
	public <T> Sparrow(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The sparrow's birth date.
	 * @param The sparrow's weight.
	 * @param The sparrow's wing span.
	 * @throws Exception for the birth date, the weight, and wing span if it is entered wrong.
	 */
	public <T> Sparrow(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	/**
	 * The over ride constructor for the id of the sparrow and the type.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

	/**
	 * The over ride constructor to see if the sparrow is eating.
	 */
	@Override
	public void eat()	{
		System.out.println("This " + this.type + " is eating...");
	}

	/**
	 * The over ride constructor to see if the sparrow is flying.
	 */
	@Override
	public void flying()	{
		System.out.println("This " + this.type + " is flying...");
	}

	/**
	 * The over ride constructor to see if the sparrow is soaring.
	 */
	@Override
	public void soaring()	{
		System.out.println("This " + this.type + " is soaring...");
	}

	/**
	 * The over ride constructor to see if the sparrow is gliding.
	 */
	@Override
	public void gliding()	{
		System.out.println("This " + this.type + " is gliding...");
	}
}

