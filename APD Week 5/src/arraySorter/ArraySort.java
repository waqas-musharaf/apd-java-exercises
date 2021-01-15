package arraySorter;

/**
 * Defines the interface for array sorting algorithms
 * 
 * @author Hugh Osborne
 * @version October 2016
 */

public interface ArraySort<T extends Comparable<T>>
{
    /**
     * Sort the array
     */
    public void sort(T[] array);
}