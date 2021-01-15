package resourceManager;
import java.util.Set;
import java.util.HashSet;

/**
 * Utilities for populating a set resource managers and a set of resource users, and then running them.
 * Each resource user will try to make use of each resource.
 * 
 * @author Hugh Osborne
 * @version February 2013
 */

public class ResourceSystem
{
    // The set of managers managing the resources to be used by the resource users
    private Set<ResourceManager> managers;
    // The set of resource users
    private Set<ResourceUser> users;
    
    /**
     * Initialise the resource managers and resource users sets.
     */
    public ResourceSystem() {
        managers = new HashSet<ResourceManager>();
        users = new HashSet<ResourceUser>();
    }
    
    /**
     * Add a new resource by creating one, with the appropriate manager.
     * @param name the name of the resource to be added.
     * @param maxUseages the maximum number of times this resource can be used (the actual number may
     * be lower - see BasicResourceManager)
     */
    public void addResource(String name,int maxUseages) {
        managers.add(new LockResourceManager(new Resource(name),maxUseages));
    }
    
    /**
     * Add a new resource user.  The resource user may make use of all the resources created.
     * @param name the name of the resource user.
     * @param maxDelay the maximum time, in seconds, that the resource user will ever use any resource.
     */
    public void addUser(String name,double maxDelay) {
        users.add(new ResourceUser(name,maxDelay,managers));
    }
    
    /**
     * Run this resource user.  Each resource user will run until all the resources at its disposal are exhausted.
     * @throws ResourceError if there is an InterruptedException while the system waits to <tt>join()</tt> the resource users.
     */
    public void run() throws ResourceError {
        for (ResourceUser user: users) {
            user.start();
        }
        try {
            for (ResourceUser user: users) {
                user.join();
            }
        } catch (InterruptedException ie) {
            throw new ResourceError("The system was interrupted while waiting for the resource users to terminate.\n" + ie.getMessage());
        }
    }
}
