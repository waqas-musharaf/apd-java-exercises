package resourceManager;

/**
 * The methods defined in this interface <i>must</i> be implemented in any resource manager.
 * All of the methods except requestResource() and releaseResource() are implemented in the
 * abstract BasicResourceManager class.
 * 
 * @author Hugh Osborne
 * @version February 2013
 */

public interface ResourceManager
{
    /**
     * Generate a random priority in the range permitted by this resource manager.
     * @return a random priority from the interval [0,MAX_PRIORITY].
     */    
    public int getRandomPriority();
    
    /**
     * Get the name of the resource managed by this resource manager.
     * @return the name of the resource managed by this resource manager.
     */
    public String getResourceName();
    
    /**
     * Check whether this manager's resource is exhausted.
     * @return true iff the resource is exhausted.
     */
    public boolean resourceIsExhausted();
    
    /**
     * Request use of this manager's resource, with the specified priority.
     * If the resource is in use the requesting user will have to wait for the resource to be released.
     * @param priority the priority level at which the resource is being requested.
     * @throws ResourceError if the implementing code throws an InterruptedException error.
     */
    public void requestResource(int priority) throws ResourceError;
    
    /**
     * Allow the resource to be used for a specified length of time.
     * Calls of this method <i>must</i> be protected by (properly implemented) calls of
     * requestResource() and releaseResource().
     * @param timeRequired the time, in milliseconds, for which the requesting user requires use of the resource.
     * @throws ResourceError if more than one user is using the resource, or if the resource is exhausted.
     */
    public void useResource(int timeRequired) throws ResourceError;
    
    /**
     * Release this manager's resource.  If any users are waiting for the resource a waiting user with the
     * highest priority should be woken.
     * @throws ResourceError if the implementing code throws an InterruptedException error.
     */
    public int releaseResource() throws ResourceError;
}
