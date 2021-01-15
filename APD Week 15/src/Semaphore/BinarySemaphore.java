package Semaphore;


/**
 * Blocking binary semaphores
 * 
 * @author Hugh Osborne 
 * @version January 2013
 */
public class BinarySemaphore extends BlockingSemaphore
{
    /**
     * A generic constructor, with a limit value for bounded semaphores.
     * For binary semaphores, which have a limit of one, the limit parameter is
     * ignored.
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     * @param upper limit value for the semaphore (ignored, as this type of semaphore has no upper limit)
     */
    public BinarySemaphore(String name,int initialValue,int limit)
    {
        this(name,initialValue);
    }

    /**
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     */
    public BinarySemaphore(String name,int initialValue)
    {
        super(name,initialValue,1);
    }
}
