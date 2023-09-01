package trafficControlerApp;

/**
 * @author Adahm
 *
 */
public class TrafficLight {
	private boolean red;
	private boolean yellow;
	private boolean green;
	

	/**
	 * 
	 */
	public TrafficLight() {
		this.red = true;
		this.yellow = false;
		this.green = false;
	}
	

	public boolean isRed() {
		return red;
	}
	
	public boolean isYellow() {
		return yellow;
	}
	
	public boolean isGreen() {
		return green;
	}
	

	public void redOn() {
		this.red = true;
		this.yellow = false;
		this.green = false;
	}
	
	public void yellowOn() {
		this.red = false;
		this.yellow = true;
		this.green = false;
	}
	
	public void greenOn() {
		this.red = true;
		this.yellow = false;
		this.green = false;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
