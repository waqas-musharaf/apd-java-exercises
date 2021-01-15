package resourceManager;

/**
 * Report errors arising from the management and use of resources.
 * 
 * @author Hugh Osborne
 * @version February 2013
 */

public class ResourceError extends Exception
{
    public ResourceError(String message) {
        super("Resource error: " + message);
    }
}
