package hashtables;

/**
 * Defines the interface for locally implemented hashtables
 * 
 * @author Hugh Osborne 
 * @version October 2011
 */
public interface HuddersfieldHashtable<S,T>
{

    /** This method should store the given data in the array at the position given by the 
     *  key's hash code (taken modulo the table's size).
     *  @param key the key to be used to access the hash table
     *  @param data the data to be inserted
     *  @throws HashtableError if the table is full
     */

    public void insert(S key,T data) throws HashtableError;
    
    /**
     * This method should retrieve a value from a hash table
     * @param key the key to be used to retrieve the object
     * @returns the object specified by the key (if present in the table)
     * @throws HashtableError if no object with that key is present in the table
     */
    public T retrieve(S key) throws HashtableError;
}
