package Search;

/**
 * The interface discussed in week 1's lecture
 * <p>
 * <i>This is an interface, and specifies the signature(s) of method(s) that
 * you should implement in (a) <b>separate</b> class(es).  You should <b>not</b> edit
 * this class!
 * 
 * @author Hugh Osborne
 * @version October 2013
 */

public interface TimedSearch
{
    /**
     * Find the kth largest element in an array of ints
     * @param array array of int                 
     * @param k index of the element to be found                       
     * @return  kth largest integer in array
     * @throws IndexingError if k is not a valid index
     **/

    public int findKthElement(int[] array, int k) throws IndexingError;
    
    /**
     * Find the time it takes to find the solution
     * @param array array of int
     * @param k the index of the int to be found
     * @return the time taken for solution to find the kth largest entry
     *    in the array
     * @throws IndexingError if k is not a valid index
     **/
     public double time(int[] array,int k) throws IndexingError;
}