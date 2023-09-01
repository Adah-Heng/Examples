package zoo.animal;

/**
 * @author Adahm
 * If the bird is soaring or flying.
 */
public interface Fly {

	/**
	 * If the animal is flying.
	 */
	default void flying() {
		System.out.println("This animal is flying");
	}

	/**
	 * If the animal is soaring.
	 */
	default void soaring()	{
		System.out.println("This animal is soaring");
	}
	/**
	 * If the animal is gliding.
	 */
	default void gliding()	{
		System.out.println("This animal is gliding");
	}


}
