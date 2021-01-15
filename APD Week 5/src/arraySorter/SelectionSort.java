package arraySorter;

/**
 * The implementation of the selection sort algorithm
 * 
 * @author Waqas Musharaf 
 * @version November 2016
 */
public class SelectionSort <T extends Comparable<T>> extends ArraySortTool<T>
{
	public void sort(T[] array)
	{
		int x, y, first;
		T temp;
		for (x = array.length-1; x > 0; x--)
		{
			first = 0;
			for (y = 1; y <= x; y++)
			{
				if (array[y].compareTo(array[first]) < 0)
					first = y;
			}
			temp = array[first];
			array[first] = array[x];
			array[x] = temp;
		}
	}
}
