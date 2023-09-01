package zoo.app;

/**
 * @author adheng01
 * The Zoo_Keeper_App is where we test all of our animals to make sure that the code is working.
 *
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import zoo.animal.*;

import zoo.animal.Bird;
import zoo.animal.Fish.Water;

/**
 * The class where all the testing from animal happens.
 * 
 */
public class Zoo_Keeper_App {

	/**
	 * The date is formatted by Month-day-year.
	 */
	private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	/**
	 * An array list that keeps track of all the animals in the zoo.
	 */
	private static List<Animal> animals = new ArrayList<Animal>();

	/**
	 * The overload constructor where all of the testing happens.
	 */
	public Zoo_Keeper_App() {
	}

	/**
	 * @param args The arguments passed to test to see if all of the animals are working. 
	 * @throws Exception The exception is an errors thrown by the animal.
	 */
	public static void main(String[] args) throws Exception {

		try {

			//Animal a1 = new Animal();
			//Animal a2 = new Animal("12-31-2022", (float) 10.5);

			LocalDate birthdate = LocalDate.parse("11-30-2022", FORMAT);
			//Animal a3 = new Animal(birthdate, (float) 5.5);

			//System.out.println(a1);
			//System.out.println(a2);
			//System.out.println(a3);

			System.out.println();

			//System.out.println(a1.getBirthdateStr() + " " + a1.getWeight());
			//System.out.println(a2.getBirthdateStr() + " " + a2.getWeight());
			//System.out.println(a3.getBirthdateStr() + " " + a3.getWeight());

			//a1.setGender("female");
			//a2.setGender(Gender.FEMALE);
			//System.out.println(a1.getGender());

			//Bird b1 = new Bird();
			//Bird b2 = new Bird("12-31-2022", (float) 1.5);
			//Bird b3 = new Bird("12-31-2022", (float) 1.5, (float) 2.2);

			//System.out.println(b1);
			//System.out.println(b2);
			//System.out.println(b3.getWingspan());

			Chicken c1 = new Chicken();
			Chicken c2 = new Chicken("12-31-2022", (float) 5.7);
			Chicken c3 = new Chicken("12-31-2022", (float) 5.7, (float) 23.6);

			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3.getWingspan());

			Sparrow s1 = new Sparrow();
			Sparrow s2 = new Sparrow("12-31-2022", (float) 0.85);
			Sparrow s3 = new Sparrow("12-31-2022", (float) 0.85, (float) 8.3);

			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3.getWingspan());

			//Fish f1 = new Fish();
			//Fish f2 = new Fish("12-31-2022", (float) 1.5);
			//Fish f3 = new Fish("12-31-2022", (float) 1.5, Water.FRESH);

			//System.out.println(f1);
			//System.out.println(f2);
			//System.out.println(f3.getWater());

			Guppy g1 = new Guppy();
			Guppy g2 = new Guppy("12-31-2022", (float) .07);
			Guppy g3 = new Guppy("12-31-2022", (float) .07, "fresh");

			System.out.println(g1);
			System.out.println(g2);
			System.out.println(g3.getWater());

			FlyingFish ff1 = new FlyingFish();
			FlyingFish ff2 = new FlyingFish("12-31-2022", (float) 2.0);
			FlyingFish ff3 = new FlyingFish("12-31-2022", (float) 2.0, Water.FRESH);

			System.out.println(ff1);
			System.out.println(ff2);
			System.out.println(ff3.getWater());


			//animals.add(a1);
			//animals.add(a2);
			//animals.add(a3);

			//animals.add(b1);
			//animals.add(b2);
			//animals.add(b3);

			animals.add(c1);
			animals.add(c2);
			animals.add(c3);

			animals.add(s1);
			animals.add(s2);
			animals.add(s3);

			//animals.add(f1);
			//animals.add(f2);
			//animals.add(f3);

			animals.add(ff1);
			animals.add(ff2);
			animals.add(ff3);

			animals.add(g1);
			animals.add(g2);
			animals.add(g3);

			System.out.println(animals.get(11));

			FlyingFish myFish = (FlyingFish) animals.get(11);
			System.out.println(myFish.getWater());

			myFish.eat();



		} catch (Exception e) {
			System.out.println("The following error has occurred: ");
			System.out.println(e.getMessage());

		}
	}

}

