package hashtables;
// This code should not be modified.

import java.lang.reflect.Array;

public abstract class OpenAddressing<S,T> implements HuddersfieldHashtable<S,T> {

    protected Record<S,T>[] table; // the hashtable

    /**
     * Construct an open addressing hashtable with the specified
     * initial size.
     * @param size the (intial) size of the hash table
     */
    @SuppressWarnings({"unchecked"})
    public OpenAddressing(int size) {
        table = (Record<S,T>[]) Array.newInstance(new Record<S,T>(null,null).getClass(),size);
    }
    
    /**
     * Calulate an index in the hashtable for an entry with the given key.  Return the entry's
     * index if it exists.  If there is no such entry return the index of the
     * next free field in the hashtable (for this key).
     * @param key the key being looked for
     * @return the index of the entry with this key, if it exists
     * @return the address of the next free space if there is no such key in the table
     * @throws HashtableError if the table is full and does not contain an entry with the given key
     */
    protected abstract int index(S key) throws HashtableError;
    
}