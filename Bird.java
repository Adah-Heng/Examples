package zoo.animal;
/**
 * 
 */

/**
 * @author adheng01
 * If the animal is a bird it tracks the wing span.
 */

public abstract class Bird extends Animal{

	/**
	 * To see if the animal is a bird
	 */
	private final String type = "bird";

	/**
	 * The wing span of the bird.
	 */
	private float wingspan;

	/**
	 * The default constructor that takes the default constructor of animal.
	 */
	public Bird() {
		super();
		this.wingspan = 0;
	}

	/**
	 * @param <T>
	 * @param The bird's birth date.
	 * @param The bird's weight.
	 * @throws Exception for the invalid weight from animal class.
	 */
	public <T> Bird(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	/**
	 * @param <T>
	 * @param The bird's birth date.
	 * @param The bird's weight.
	 * @param The bird's wing span.
	 * @throws Exception for the weight of the bird and wing span.
	 */
	public <T> Bird(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight);
		this.setWingspan(wingspan);
	}

	/**
	 * @return The bird's wing span.
	 */
	public float getWingspan() {
		return this.wingspan;
	}

	/**
	 * @param Wing span can be set for the bird.
	 * @throws Exception if the an invalid wing span is put in.
	 */
	public void setWingspan(float wingspan) throws Exception {
		if(wingspan > 0)
			this.wingspan = wingspan;
		else
			throw new Exception("Invaild wingspan: " + wingspan);
	}

	/**
	 * The override allows the id to set and the type of bird to be set.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

}
