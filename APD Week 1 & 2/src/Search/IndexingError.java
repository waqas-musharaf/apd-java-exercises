package Search;

/**
 * Use to report index out of bounds errors
 * 
 * @author Hugh Osborne
 * @version September 2016
 **/
public class IndexingError extends Exception
{
    /**
     * Used to report an index out of bounds error
     **/
    public IndexingError() {
        super("Index out of bounds");
    }
}
