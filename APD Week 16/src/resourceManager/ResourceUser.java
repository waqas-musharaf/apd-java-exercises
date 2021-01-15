package resourceManager;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * A process that makes use of a number of resources.
 * The resources are managed by, and accessed through resource managers.
 * 
 * @author Hugh Osborne 
 * @version February 2013
 */

public class ResourceUser extends Thread
{
    // The managers of the resources that this resource user wishes to use.  A resource
    // user will terminate once all resource managers have terminated (because their
    // resources are no longer available.  The resource managers need to be stored in
    // a list rather than a set in order to allow random access.
    private List<ResourceManager> managers;
    // Used to determine the time for which this resource user requires a resource
    private Random random = new Random(System.currentTimeMillis());
    // The maximum length of time for which this resource user will require any resource.
    private int maxTimeRequiredMillis;
    // The current priority at which the resource user is currently operating.
    // The default value is the lowest priority - i.e. 0
    private int priority = 0;

    /**
     * Set the name and maximum useage time, and initialise the resource managers.
     * @param the name of this resource user.
     * @param maxTimeRequired the maximum time, in seconds, for which this resource user will
     * ever require any resource.
     * @resourceManagers the managers of the resources this resource user is going to use.
     */
    public ResourceUser(String name,double maxTimeRequired,Set<ResourceManager> managers) {
        setName(name);
        maxTimeRequiredMillis = (int) (maxTimeRequired*1000);
        this.managers = new ArrayList<ResourceManager>(managers);
    }
    
    /**
     * Check whether this resource user is still active.  Every time a resource manager reports
     * that its resource is no longer available that resource manager is removed from the resource
     * manager list.  A resource user becomes inactive when all of the resource managers' resources
     * have become unavailable, and all of the resource managers have therefore been remove from the
     * resource manager list.
     * @return true iff there are one or more resource managers still in the resource manager list.
     */
    public boolean isActive() {
        return managers.size() > 0;
    }
    
    /**
     * Construct a string containing this resource user's name and information about its current priority level.
     */
    public String toString() {
        return getName() + "(priority: " + priority + ")";
    }
    
    /**
     * Run this resource user.  The resource user will run until all of the resources are exhausted.
     * In each cycle the resource user will:
     * <ul>
     *  <li> Select an active resource (manager), if such exists.
     *  <li> Request a resource at a random priority level.
     *  <li> Wait, if necessary, for the resource to become available
     *  <li> Use the resource for a random length of time.
     * </ul>
     */
    public void run() {
        while (isActive()) {
            ResourceManager manager;
            do {
                manager = managers.get(random.nextInt(managers.size())); // select a resource
                if (manager.resourceIsExhausted()) { // is the resource still available?
                    managers.remove(manager); // if not remove the resource manager from the list
                }
            } while (manager.resourceIsExhausted() && isActive()); // repeat until an active resource is found, or all resources are exhausted
            if (isActive()) { // check again if still active - the last resource might have been exhausted
                priority = manager.getRandomPriority(); // set a random priority for this resource request
                try {
                    int timeRequired = random.nextInt(maxTimeRequiredMillis)+1; // pick a length of time to request use of the resource for
                    System.out.println(this + " is requesting " + manager.getResourceName());
                    manager.requestResource(priority); // request the resource - the resource manager should suspend this resource user if the resource is not available
                    System.out.println(this + " gained access to " + manager.getResourceName()); // request successfull - resource available
                    manager.useResource(timeRequired); // use the resource
                    int newThreadsPriority = manager.releaseResource(); // release the resource - the request returns the priority of the process, if any, woken by this request
                    if (newThreadsPriority == BasicResourceManager.NONE_WAITING) {
                        System.out.println(this + " released " + manager.getResourceName() + ", there were no waiting processes");
                    } else {
                        System.out.println(this + " released " + manager.getResourceName() + ", to a process with priority " + newThreadsPriority);
                    }
                } catch (ResourceError error) {
                    System.out.println("***" + error.getMessage());
                }
            }
            try {
                sleep(random.nextInt(maxTimeRequiredMillis)+1); // pause 
            } catch (InterruptedException ie) {}
        }
    }
        
}
