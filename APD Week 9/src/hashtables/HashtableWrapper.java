package hashtables;

/**
 * A wrapper for the Hashtable class
 * 
 * @author Hugh Osborne 
 * @version October 2011
 */
public class HashtableWrapper<S,T> extends java.util.Hashtable<S,T>
{
    public HashtableWrapper(int size) {
        super(size);
    }
    
    public static void main(String[] args) {
		HashtableWrapper<String, Integer> hashtable = new HashtableWrapper<String, Integer>(5);
		
		hashtable.put("fred", 37);
		hashtable.put("is", 69);
		hashtable.put("dead", 0);
		hashtable.put("but", 999);
		hashtable.put("not", -42);
		hashtable.put("me!", -1);
		
		System.out.println(hashtable);
	}
}
