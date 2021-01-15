package arraySorter;

/**
 * The implementation of bubble sort from the lecture
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */
public class BubbleSort<T extends Comparable<T>> extends ArraySortTool<T>
{
    public void sort(T[] array) {
        for (int lastUnsorted = array.length-1;  // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round
            for (int nextToCompare = 0; // start comparing the first two elements
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) {
                if (array[nextToCompare].compareTo(array[nextToCompare+1]) > 0) {
                    // the elements are in the wrong order so swap them around
                    T tmp = array[nextToCompare];
                    array[nextToCompare] = array[nextToCompare+1];
                    array[nextToCompare+1] = tmp;    
                }
            }
        }
    }
}