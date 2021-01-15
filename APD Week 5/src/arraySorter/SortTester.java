package arraySorter;

import RandomArray.RandomArray;

/**
 * The test class SortTester.
 *
 * @author  Hugh Osborne
 * @version October 2016
 */
public class SortTester<T extends Comparable<T>> extends junit.framework.TestCase
{
    public void test(ArraySortTool<T> sorter,RandomArray<T> generator,int size)
    {
        T[] array = generator.randomArray(size);
        sorter.sort(array);
        assert(sorter.isSorted(array));
    }
    
}