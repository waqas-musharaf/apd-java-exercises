

/**
 * The implementation of the quick sort algorithm
 * 
 * @author Waqas Musharaf 
 * @version November 2016
 */
public class QuickSort <T extends Comparable<T>> extends ArraySortTool<T>
{
	Integer partition(T[] array, int left, int right)
	{	
		int x = left, y = right;
		T temp;
		T pivot = array[(left + right) / 2];
		
		while (x <= y) {
			while (array[x].compareTo(pivot) < 0) x++;
			while (pivot.compareTo(array[y]) < 0) y--;
			
			if (x <= y) {
				temp = array[x];
				array[x] = array[y];
				array[y] = temp;
				x++;
				y--;
			}
		};
		return x;
	}
	
	public void sort(T[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1)
			sort(array, left, index - 1);
		if (index < right)
			sort(array, index, right);
	}
}