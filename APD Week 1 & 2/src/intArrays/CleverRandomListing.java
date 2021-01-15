package intArrays;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * A more efficient extension of RandomCount
 * 
 * @author Waqas Musharaf
 * @version October 2016
 */
public class CleverRandomListing extends RandomListing
{
	/**
     * Constructor of the method
     */
	public CleverRandomListing(int size) {
		super(size);
	}
	
	/**
	 * Used to randomise the array
	 */
	protected void randomise() {
		Random rnd = ThreadLocalRandom.current();
		for (int i = getArray().length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			int a = getArray()[index];
			getArray()[index] = getArray()[i];
			getArray()[i] = a;
		}
    }
	
	/**
	 * Main method
	 */
    public static void main(String[] args) {
    	RandomListing count = new CleverRandomListing(20);
    	System.out.println(Arrays.toString(count.getArray()));
    }
}
 // End of class CleverRandomListing

