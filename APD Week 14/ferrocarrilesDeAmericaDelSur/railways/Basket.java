package railways;
import errors.ProgrammingError;

/**
 * Models baskets for the railway system.
 * Baskets can have stones put in them or removed from them.
 * @author hugh
 *
 */
public class Basket {
	private String name; // the name of this basket, for tracing
	private int stones = 0; // the number of stones in the basket
	
	public Basket(String name) {
		this.name = name;
	}
	
	/**
	 * Put a stone in the basket.  The capacity of baskets is unlimited.
	 */
	private synchronized void putStone() {
		stones++;
	}
	
	/**
	 * The delayed version of putStone
	 */
	public void putStone(Railway railway) throws ProgrammingError {
		railway.getRailwaySystem().trace(railway.name() + ": adding stone to " + name + " (" + stones + " stone" + (stones == 1 ? "" : "s") + " in the basket)");
		railway.delay();
		putStone();
	}
	
	/**
	 * Remove a stone from the basket.
	 * @throws ProgrammingError if there is no stone to remove
	 */
	private synchronized void takeStone() throws ProgrammingError {
		if (stones > 0) {
			stones--;
		} else {
			throw new ProgrammingError("Cannot remove a stone from " + name + ".  The basket is empty");
		}
	}
	
	/**
	 * The delayed version of takeStone
	 */
	public void takeStone(Railway railway) throws ProgrammingError {
		railway.getRailwaySystem().trace(railway.name() + ": removing stone from " + name + " (" + stones + " stone" + (stones == 1 ? "" : "s") + " in the basket)");
		railway.delay();
		takeStone();
	}
	
	/**
	 * Check if the basket contains at least one stone.
	 * @return true iff there is at least one stone in the basket
	 */
	synchronized boolean hasStone() {
		return stones > 0;
	}
	
	/**
	 * The delayed version of hasStone
	 */
	public boolean hasStone(Railway railway) throws ProgrammingError {
		railway.getRailwaySystem().trace(railway.name() + ": checking " + name + " for stones");
		railway.delay();
		return hasStone();
	}

}
