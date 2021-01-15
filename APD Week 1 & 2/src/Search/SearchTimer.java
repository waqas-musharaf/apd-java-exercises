package Search;

/**
 * An abstract class example from week 1's lecture
 * <p>
 * This class impelements the {@link time} method from the {@link TimedSearch}
 * interface, but not the {@link TimedSearch.findKthElement} method.
 * <p>
 * <i>Note: You should <b>not</b> edit this file.  Any code you implement should
 * be in (a) <b>separate</b> class(es).
 * 
 * @author Hugh Osborne 
 * @version September 2016
 */
public abstract class SearchTimer implements TimedSearch
{
    /**
     * Finds the time a TimedSearch implementation takes to find the kth largest element
     * in an array of ints
     * @param array array of ints
     * @param k search index
     * @return kth largest element in array
     * @throws IndexingError if k is an invalid index
     **/
     
    public double time(int[] array,int k) throws IndexingError {
        long startTime = System.nanoTime();
        int answer = findKthElement(array,k);
        return ((double) (System.nanoTime() - startTime))/1000;
    } // end of method time
}