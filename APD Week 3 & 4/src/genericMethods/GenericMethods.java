package genericMethods;

/**
 * A generic method to exchnage two elements of an array
 * 
 * @author Waqas Musharaf
 * @version October 2016
 */

public class GenericMethods {	
	/**
	 * Check if two objects are equal
	 * @param object1 the first object
	 * @param object2 the second object
	 * @return true if the objects are equal (according to the equals() method)
	 */
	public <T> boolean equals(T object1,T object2) {
		return object1.equals(object2);
	}
	
	/**
	 * Swaps the elements within two specified indices in an array
	 * @param a the array in which the elements will be swapped
	 * @param x the first index
	 * @param y the second index
	 */
    public static <T> void swap(T[] a, int x, int y) {
    		// Stores the value of a[x] in a temp variable
	        T temp = a[x];
	        // Copies the value of a[y] to a[x]
	        a[x] = a[y];
	        // Copies the value of temp to a[y], effectively completing the swap
	        a[y] = temp;
	}
}
