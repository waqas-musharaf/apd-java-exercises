package stringSearcher;

/**
 * Reports failures to find substrings
 * 
 * @author Hugh Osborne
 * @version October 2016
 */
public class NotFound extends Exception
{
    public NotFound()
    {
        super("A substring search failed to find its target");
    }
}