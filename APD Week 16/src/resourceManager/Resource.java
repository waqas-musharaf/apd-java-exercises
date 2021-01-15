package resourceManager;

/**
 * Models a resource used by a process
 * 
 * @author Hugh Osborne
 * @version February 2013
 */

public class Resource
{
    // The name of this resource
    private String name;
    
    /**
     * Set the resource's name and determine the number of times it can be used.
     * @param name the resource's name
     * @param maxUseagesToLive the maximum number of times the resource can be used.
     * The actual number of useages will be a random value in the range (0,maxUseagesToLive].
     */
    public Resource(String name) {
        this.name = name;
    }
    
    /**
     * Get the resource's name
     * @return the resource's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Construct a string containing information about this resource. 
     * @return A string containing the resource's name, and information on how many uses 
     * it has left.
     */
    public String toString() {
        return getName();
    }

    /**
     * Use this resource, and print information about its use.
     * @param timeRequired the time, in milliseconds, for which the user wants to use the resource
     */
    public void use(int timeRequired) {
        Thread user = Thread.currentThread();
        System.out.println(user.getName() + " is using " + this);
        try {
            Thread.sleep(timeRequired);
        } catch (InterruptedException ie) {
            // not bothered if its interrupted
        }
        System.out.println(user.getName() + " has finished using " + this);
    }
}
