package genericMethods;

import java.util.Arrays;

public class GenericMethodTest {

	public static void main(String[] args){
		
		Integer[] test = {15, 3, 9, 18, 22, 4, 6};
		System.out.print("Before swap: ");
		System.out.println(Arrays.toString(test));
		
		GenericMethods.swap(test, 0, 1);
		System.out.print("After swap: ");
		System.out.println(Arrays.toString(test));
	}
}
