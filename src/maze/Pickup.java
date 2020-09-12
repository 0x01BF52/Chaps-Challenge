package maze;

/**
 * Base class for objects the Chap can pick up
 * 
 * @author Ian 300474717
 *
 */

public abstract class Pickup extends Containable{

	public Pickup(String filename, String initials) {
		super(filename, initials);
	}

	/**
	 * Trigger any events when Chap walks over the Tile which contains this Containable
	 * @param c 	Chap
	 */
	public abstract void onWalked(Chap c);

}
