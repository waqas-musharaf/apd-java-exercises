package hashtables;

/**
 * Random generators must provide a method that returns a random
 * value of the specified type
 * 
 * @author Hugh Osborne
 * @version October 2011
 */

public interface RandomGenerator<T>
{
    /**
     * Generate and return a random value
     * @returns a random value of type T
     */
    public T generate();
    
    public class Error extends Exception {
        public Error(String message) {
            super("Random generator error: " + message);
        }
    }
}
