package hashtables;
/**
 * Hashtables that can be populated by random elements.
 * 
 * @author Hugh Osborne
 * @version October 2011
 */
public abstract class FillingHashtable<S,T> extends HashtableWrapper<S,T>
{
    public FillingHashtable(int size) {
        super(size);
    }
    
    /**
     * Populate the hashtable with randomly generated key, value pairs.
     * @param noOfElements the number of elements to be added to the hashtable.
     * @param keyGenerator a random generator for generating objects of the key type.
     * @param valueGenerator a random generator for generating objects of the value type.
     */
    public abstract void fill(int noOfElements,RandomGenerator<S> keyGenerator,RandomGenerator<T> valueGenerator);
}