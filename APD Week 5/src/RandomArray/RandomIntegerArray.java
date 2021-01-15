package RandomArray;

import java.util.Random;
/**
 * Class for generating areays of random Integers.  The strings will be chosen
 * from within the range of the RandomIntegerArray object's minimum and
 * maximum fields (inclusive).
 * 
 * @author Hugh Osborne
 * @version October 2016
 */
public class RandomIntegerArray implements RandomArray<Integer>
{
    private int minimum, maximum;
    private Random random = new Random();
    
    public RandomIntegerArray(int minimum,int maximum) {
        if (maximum < minimum) {
            int tmp = minimum;
            minimum = maximum;
            maximum = tmp;  // make sure minimum <= maximum
        }
        this.minimum = minimum;
        this.maximum = maximum+1; // to make range inclusive
    }
    
    public RandomIntegerArray(int value) {
        if (value <= 0) {
            minimum = value;
            maximum = 1;
        } else {
            minimum = 0;
            maximum = value+1;
        }
    }
    
    public Integer[] randomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = minimum + random.nextInt(maximum-minimum);
        }
        return array;
    }
}