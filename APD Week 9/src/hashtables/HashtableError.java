package hashtables;
/**
 * Simple error reporting for hashtables
 * 
 * @author Hugh Osborne
 * @version November 2013
 */
public class HashtableError extends Exception
{
    public HashtableError() {
        super();
    }
    
    public HashtableError(String message) {
        super(message);
    }
}
