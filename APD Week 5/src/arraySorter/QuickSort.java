package arraySorter;

/**
 * The implementation of the quick sort algorithm
 * 
 * @author Waqas Musharaf 
 * @version November 2016
 */
public class QuickSort <T extends Comparable<T>> extends ArraySortTool<T>
{
	private T array[];
	private int length;
	
	public void sort(T[] array) {
		if (array == null || array.length == 0) {
            return;
        }
        this.array = array;
        length = array.length;
        sort(0, length - 1);
    }

    private void sort(int left, int right) {

        int i = left, j = right;
        T pivot = array[left + (right - left) / 2];
        
        while (i <= j) {
        	while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (left < j)
            sort(left, j);
        if (i < right)
            sort(i, right);
    }
    
    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

