package zoo.animal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Adahm
 * Where Animals get created.It keeps track of the animals gender,type, weight, birthday,<br> 
 * and what certain animals might be eating.
 */
public abstract class Animal {

	/**
	 * The counter to add 1 to the id of an animal when it is created.
	 */
	private static int counter = 0;

	/**
	 * The date is formatted by Month-day-year.
	 */
	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	/**
	 * The id number for each animal.
	 */
	protected final int id;

	/**
	 * The type of animal.
	 */
	protected final String type = "animal";

	/**
	 * The animal's birthday.
	 */
	protected LocalDate birthdate;

	/**
	 * The gender of the animal.
	 */
	protected Gender gender;

	/**
	 * The weight of the animal.
	 */
	protected float weight;

	/**
	 * The overload constructor that sets the birthday, weight, gender, and id.
	 */
	public Animal() {
		this.id = ++Animal.counter;
		this.gender = Gender.UNKNOWN;
		this.birthdate = null;
		this.weight = 0;
	}

	/**
	 * @param <T>
	 * @param The animal's birth date.
	 * @param The animal's weight.
	 * @throws Exception The exception is when the birth date is entered wrong.
	 */
	public <T> Animal(T birthdate, float weight) throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}

	/**
	 * @return The animal's id.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return The birth date of the animal.
	 */
	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	/**
	 * @return The input on keyboard for the get birth date.
	 */
	public String getBirthdateStr() {
		if (this.birthdate == null)
			return "unknown";
		else
			return Animal.FORMAT.format(this.birthdate);
	}

	/**
	 * @return The gender of the animal.
	 */
	public Gender getGender()	{
		return this.gender;
	}

	/**
	 * @return The type of animal it is.
	 */
	public String getType() {
		return this.getType();
	}

	/**
	 * @return The weight of the animal.
	 */
	public float getWeight() {
		return this.weight;
	}

	/**
	 * @param <T>
	 * @param The birth date of the animal.
	 * @throws The exception for the wrong format of date.
	 */
	public <T> void setBirthdate(T birthdate) throws Exception {

		if (birthdate instanceof String) {

			this.birthdate = LocalDate.parse((String) birthdate, Animal.FORMAT);;

		} else if (birthdate instanceof LocalDate){

			this.birthdate = (LocalDate) birthdate;;

		} else {

			throw new Exception("Invalid date MM-dd-yyyy: " + birthdate);

		}

	}

	/**
	 * @param <T>
	 * @param  The animal's gender
	 * @throws Exception for when the an invalid gender is entered.
	 */
	public <T> void setGender(T gender)	throws Exception{
		if (gender instanceof String)	{
			String s = (String) gender;

			s = s.toLowerCase();

			switch(s)	{
			case "male":
			case "m":
				this.gender = Gender.MALE;
				break;
			case "female":
			case "f":
				this.gender = Gender.FEMALE;
				break;
			default:
				throw new Exception("Invalid gender: " + s);
			}
		}else if(gender instanceof Gender)	{
			this.gender = (Gender) gender;
		}else	{
			throw new Exception("Invaid gender: " + gender);
		}
	}

	/**
	 * @param The animal's weight.
	 * @throws Exception for an invalid weight.
	 */
	public void setWeight(float weight) throws Exception {

		if (weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid weight: " + weight);
	}

	/**
	 * returns the id of the animal with the type animal.
	 */
	@Override
	public String toString()	{
		return this.id + " " + this.type;
	}

	/**
	 * To tell which animal is eating.
	 */
	abstract public void eat();	

}
