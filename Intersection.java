/**
 * 
 */
package trafficControlerApp;

/**
 * @author Adahm
 *
 */
public class Intersection {
	
	private Street street1;
	private Street street2;

	/**
	 * 
	 */
	public Intersection() {
		this.street1 = new Street();
		this.street2 = new Street();
	}
	
	public Intersection(String name1, String name2) {
		this.street1 = new Street(name1);
		this.street2 = new Street(name2);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
