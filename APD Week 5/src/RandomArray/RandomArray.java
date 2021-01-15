package RandomArray;

/**
 * A utility for generating random arrays.
 * @author Hugh Osborne
 * @version October 2016
 *
 * @param <T> the type of objects in the generated arrays
 */
public interface RandomArray<T> {
	
	/**
	 * Generate a random array of the specified size
	 * @return a new array of the specified size containing random elements of the
	 * specified type
	 */
	public T[] randomArray(int size);

}
