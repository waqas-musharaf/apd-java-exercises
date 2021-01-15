package hashtables;
import java.util.Random;

/**
 * A facility for generating random integers within a specified
 * range
 * 
 * @author Hugh Osborne 
 * @version October 2011
 */
public class RandomInteger implements RandomGenerator<Integer>
{
    private int from, to; // the range within which the generated values must fall (inclusive)
    private final static int DEFAULT_FROM = 0, DEFAULT_RANGE = 10;
    private Random random = new Random(); // the random generator
    
    /**
     * @param from the lowest value that should be generated
     * @param to the highest value that should be generated
     */
    public RandomInteger(int from,int to) throws RandomGenerator.Error {
        setRange(from,to);
    }
    
    public RandomInteger(int from) throws RandomGenerator.Error {
        this(from,from + DEFAULT_RANGE);
    }
    
    public RandomInteger() throws RandomGenerator.Error {
        this(DEFAULT_FROM,DEFAULT_FROM + DEFAULT_RANGE);
    }
    
    /**
     * Set the range of numbers to be generated
     * @throw RandomGenerator.Error if the bottom of the range is higher
     * than the top
     */
    private void setRange(int from,int to) throws RandomGenerator.Error {
        if (from > to) {
            throw new RandomGenerator.Error("range of integer values should go from low to high");
        } else {
            this.from = from;
            this.to = to;
        }
    }
    
    /**
     * Generate a random integer in the specified range
     * @return a random integer between from and to (inclusive)
     */
    public Integer generate() {
        return new Integer(from + random.nextInt(1+to-from));
    }
        
}
