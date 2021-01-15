package resourceManager;
import java.util.Random;

/**
 * A basic resource manager, providing all of the functionality except facilities for requesting and
 * releasing resources.
 * 
 * @author Hugh Osborne
 * @version February 2013
 */

public abstract class BasicResourceManager implements ResourceManager
{
    // The resource this resource manager is managing.
    private Resource resource;
    
    // The maximum priority with which the resource can be requested. Valid priorities are in the interval [0,MAX_PRIORITY]
    private static final int MAX_PRIORITY = 10;
    /**
     * The number of priority levels.
     */
    public static final int NO_OF_PRIORITIES = MAX_PRIORITY+1;
    // Used to keep track of the number of resource users waiting at each priority level.
    private int numberWaiting[] = new int[NO_OF_PRIORITIES];
    
    /**
     * This value should be returned by the releaseResource() method if no waiting resource user can be found.
     */
    public static final int NONE_WAITING = -1;
        
    // Used for generating random priority levels
    private Random random = new Random(System.currentTimeMillis());
    
    // The number of users using the resource.  This should never be more than one.
    private int numberOfUsers;
    
    // The number of times that the resource can still be used.  The resource becomes
    // unavailable when this reaches zero.
    private int usesLeft;
    
    /**
     * Set the resource and initialise the numbers of waiting processes, and the number of users, to zero.
     * @param resource the resource managed by this manager
     * @param maxUses the maximum number of uses permitted for this manager's resource.
     * The actual number of uses permitted for the resource is set to a random value in the range (0,maxUses].
     */
    public BasicResourceManager(Resource resource,int maxUses) {
        this.resource = resource;
        for (int priority = 0; priority < NO_OF_PRIORITIES; priority++) {
            numberWaiting[priority] = 0;            
        }
        numberOfUsers = 0;
        usesLeft = random.nextInt(maxUses)+1;
    }
    
    /**
     * Get the name of the resource managed by this resource manager.
     * @return the name of the resource managed by this resource manager.
     */
    public String getResourceName() {
        return resource.getName();
    }
    
    /**
     * Note an increase, by one, in the number of processes waiting with a given priority.
     * @param priority the priority for which the increase should be noted.
     * @return the new number of users of the given priority noted as waiting
     */
    public int increaseNumberWaiting(int priority) {
        numberWaiting[priority]++;
        return numberWaiting[priority];
    }
    
    /**
     * Note a decrease, by one, in the number of processes waiting with a given priority.
     * @param priority the priority for which the decrease should be noted.
     * @return the new number of users of the given priority noted as waiting
     */
    public int decreaseNumberWaiting(int priority) {
        numberWaiting[priority]--;
        return numberWaiting[priority];
    }
    
    /**
     * Get the number of users of a given priority noted as waiting.
     * @param priority the priority of which the number of users noted as waiting is required.
     * @return the number of users of a given priority noted as waiting.
     */
    public int getNumberWaiting(int priority) {
        return numberWaiting[priority];
    }
    
    /**
     * Generate a random priority in the permitted range.
     * @return a random priority from the interval [0,MAX_PRIORITY].
     */
    public int getRandomPriority() {
        return random.nextInt(MAX_PRIORITY+1);
    }

    /**
     * Check whether the resource is exhausted.
     * @return true iff the resource is exhausted.
     */
    public boolean resourceIsExhausted() {
        return usesLeft <= 0;
    }
    
    /**
     * Allow the resource to be used for a specified length of time.
     * Calls of this method <i>must</i> be protected by (properly implemented) calls of
     * requestResource() and releaseResource().
     * @param timeRequired the time, in milliseconds, for which the requesting user requires use of the resource.
     * @throws ResourceError if more than one user is using the resource, or if the resource is exhausted.
     */
    public void useResource(int timeRequired) throws ResourceError {
        numberOfUsers++;
        if (numberOfUsers > 1) {
            throw new ResourceError(((ResourceUser) Thread.currentThread()) + " cannot use " + resource + " because it is already in use by another user");
        }
        if (resourceIsExhausted()) {
            throw new ResourceError(((ResourceUser) Thread.currentThread()) + " cannot use " + resource + " because " + resource + " has died");
        }
        resource.use(timeRequired);
        usesLeft--;
        System.out.println(resource + " has " + usesLeft + " uses left");
        numberOfUsers--;
    }
}