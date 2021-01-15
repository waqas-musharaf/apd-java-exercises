package arraySorter;

import RandomArray.RandomArray;

/**
 * Adds a time method to array sorter classes to report the time taken for a sort
  * 
 * @author Hugh Osborne
 * @version October 2016
 */
public abstract class ArraySortTool<T extends Comparable<T>> implements ArraySort<T>
{
    /**
     * @param inArray an array to be sorted
     * @return the time, in milliseconds, taken to sort the array
     */
    private double timeTakenMillis(T[] array) {
        double startTime = System.nanoTime();
        sort(array);
        return ((System.nanoTime()-startTime)/1000000.0);
    }
    
    /**
     * Run a sequence of tests on sets of arrays of increasing size, reporting the average time taken for each
     * size of array. For each size of array, <tt>noPerSize</tt> tests will be run, and the average time taken.  
     * Timings will be generated for array sizes 1,2,...,9,10,20,...,90,100,200,...,900,1000,2000,...until the
     * maximum time is exceeded.  Times are reported in milliseconds. 
     * @param generator an array generator for generating the random arrays
     * @param noPerSize the number of timings per array size set
     * @param maxTimeSeconds the cut-off time in seconds - once a timing takes longer than this the timing sequence will be terminated
     */
    public void timeInMillis(RandomArray<T> generator,int noPerSize,int maxTimeSeconds)
    {
    	int size = 1;  // initial size of array to test
    	int step = 1;  // initial size increase
    	int stepFactor = 10; // when size reaches 10*current size increase step size by 10
    	double averageTimeTaken;
    	do {
    		double totalTimeTaken = 0;
    		for (int count = 0; count < noPerSize; count++) {
    			T[] array = generator.randomArray(size);
    			totalTimeTaken += timeTakenMillis(array);
    		}
    		averageTimeTaken = totalTimeTaken/noPerSize;
	        System.out.format("Average time to sort %d elements was %.3f milliseconds.\n",size,averageTimeTaken);
	        size += step;
	        if (size >= stepFactor*step) step *= stepFactor;   		
    	} while (averageTimeTaken < maxTimeSeconds*1000);
   		System.out.println("Tests ended.");
    }

    /**
     * Check whether a given array is sorted.
     * @param array the array to be checked
     * @return true iff the array is sorted - either ascending or descending
     * The first non-equal neighbouring elements will determine the expected
     * order of sorting.
     */
    public boolean isSorted(T[] array) {
        int detectedDirection = 0; // have not yet detected increasing or decreasing
        T previous = array[0];
        for (int index = 1; index < array.length; index++) {
            int currentDirection = previous.compareTo(array[index]); // compare previous and current entry
            if (currentDirection != 0) { // if current pair increasing or decreasing
                if (detectedDirection == 0) { // if previously no direction detected
                    detectedDirection = currentDirection; // remember current direction
                } else if (detectedDirection * currentDirection < 0) { // otherwise compare current and previous direction
                    return false; // if they differ array is not sorted
                }
            }
            previous = array[index];
        }
        // reached end of array without detecting pairs out of order
        return true;
    }
}