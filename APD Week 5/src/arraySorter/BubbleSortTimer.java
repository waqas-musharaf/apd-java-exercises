package arraySorter;

import RandomArray.*;

public class BubbleSortTimer {
	public static void main(String[] args) {
		BubbleSort<Integer> sorter = new BubbleSort<Integer>();
		RandomArray<Integer> generator = new RandomIntegerArray(1000000);
		sorter.timeInMillis(generator, 10, 5);
	}
}
