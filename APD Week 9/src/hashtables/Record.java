package hashtables;
/**
 * Models an entry in a hash table.
 * @author Hugh Osborne
 * @version November 2013
 */
public class Record<S,T> {
    S key;
    T value;
        
    protected Record(S key,T value) {
        this.key = key;
        this.value = value;
    }
        
    protected S getKey() {
        return key;
    }
        
    protected T getValue() {
        return value;
    }
}