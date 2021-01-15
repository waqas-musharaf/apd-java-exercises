package arraySorter;

import RandomArray.*;

public class QuickSortTimer {
	public static void main(String[] args) {
		QuickSort<Integer> sorter = new QuickSort<Integer>();
		RandomArray<Integer> generator = new RandomIntegerArray(1000000);
		sorter.timeInMillis(generator, 10, 5);
	}
}
