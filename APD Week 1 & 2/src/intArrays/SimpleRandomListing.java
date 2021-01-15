package intArrays;

import java.util.Arrays; // in order to be able to use the fill(...) method
/**
 * An extension of RandomCount
 * 
 * @author Hugh Osborne
 * @version September 2016
 */
public class SimpleRandomListing extends RandomListing
{
    /**
     * Constructor
     */
    public SimpleRandomListing(int size) {
        super(size);
    }
    
    /**
     * Randomise the array
     */
    protected void randomise() {
		// Creates a new array 'copy', with size equal to original array
		int[] copy = new int[getArray().length];
		// Boolean 'used' is used to indicate if elements in the original array have been used
        boolean[] used = new boolean[getArray().length];
        // Initialises each element in the original array as not used
        Arrays.fill(used,false);
        
        for (int index = 0; index < getArray().length; index++) {
        	int randomIndex;
        	do {
        		// Assigns a random index within the bounds of the original array to 'randomIndex'
                randomIndex = getRandomIndex();
            } 
        	// While the element at index 'randomIndex' of the original array is not used... (do)
        	while (used[randomIndex]);
        	// Adds the element at index 'randomIndex' of the original array to the current index of the copy array
            copy[index] = getArray()[randomIndex];
            // Changes the value of 'used' to true for the element at index 'randomIndex' of the original array 
            used[randomIndex] = true;
        }
        for (int index = 0; index < getArray().length; index++) {
        	// Replaces each element in each index of the original array with each element in the corresponding index of the copy array
            getArray()[index] = copy[index];
        }
    }
    
    public static void main(String[] args) {
    	RandomListing count = new SimpleRandomListing(100000);
    	System.out.println(Arrays.toString(count.getArray()));
    }

} // End of class SimpleRandomCount