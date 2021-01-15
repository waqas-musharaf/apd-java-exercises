package Search;

import java.util.Arrays; // in order to use the <tt>sort</tt> method

/**
 * A simple concrete implementation of {@link TimedSearch} using the "obvious"
 * method from week 1's lecture.
 * <p>
 * <i>Do <b>not</b> edit this class, but implement your "clever" {@link TimedSearch}
 * algorithm in a <b>separate</b> class.</i>
 * 
 * @author Hugh Osborne
 * @version September 2008
 */
public class SimpleSearchTimer extends SearchTimer
{
    /**
     * Find the kth largest element in an array of Comparables
     * using the "obvious" solution from the lecture
     * @param array array of Comparables
     * @param k index of desired element
     * @return kth largest element of array
     * @throws IndexingError if k is an invalid index
     */
    public int findKthElement(int[] array, int k) throws IndexingError {
        if (k <= 0 || k > array.length) { // check for indexing error
            throw new IndexingError();
        }
        Arrays.sort(array); // sort the whole array
        return array[array.length - k]; // desired element is kth from the end
    } // end of obvious solution method
    
    /**
     * Main method.  Provided to make the code compilable under Eclipse.
     * @throws IndexingError 
     */
    public static void main(String[] args) throws IndexingError {
    	int[] array = {3,2,5,1,4};
    	SearchTimer timer = new SimpleSearchTimer();
    	System.out.println("2nd largest element of " + Arrays.toString(array) + " is " + timer.findKthElement(array,2));
    }
}