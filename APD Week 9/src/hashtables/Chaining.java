package hashtables;
/**
 * Simple implementation of hash tables with chaining
 * 
 * @author Hugh Osborne
 * @version October 2011
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Chaining<S,T> implements HuddersfieldHashtable<S,T>
{
    /**
     * The hash table consists of an array of ArrayLists in which we can store
     * our data.
     */
    protected ArrayList<Record<S,T>>[] table; // the hashtable
    
    /**
     * Construct an new hashtable with the specified initial size
     * @param size the initial size of the hashtable
     */
    @SuppressWarnings({"unchecked"})
    public Chaining(int size) {
        table = (ArrayList<Record<S,T>>[]) Array.newInstance(new ArrayList<Record<S,T>>().getClass(),size);
    }
}