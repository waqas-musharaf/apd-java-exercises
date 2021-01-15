package Semaphore;


/**
 * A wrapper for Java's Semaphore class.
 * 
 * @author Hugh Osborne 
 * @version January 2013
 */
public class LocalSemaphore extends java.util.concurrent.Semaphore implements SemaphoreInterface
{
    private String name; // the name of this semaphore (for tracing)
    
    /**
     * A generic constructor, with a limit value for bounded semaphores.
     * For unbounded semaphores, such as this one, the limit parameter is
     * ignored.
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     * @param upper limit value for the semaphore (ignored, as this type of semaphore has no upper limit)
     */
    public LocalSemaphore(String name,int initialValue,int limit) {
        this(name,initialValue);
    }
    
    /**
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     */
    public LocalSemaphore(String name,int initialValue) {
        super(initialValue);
        this.name = name;
    }
    
    /**
     * Get the name of this semaphore.
     * @return the name of this semaphore
     */
    public String getName() {
        return name;
    }

    /**
     * Acquire this semaphore
     */
    public void poll() throws InterruptedException {
        super.acquire();
    }
    
    /**
     * Release this semaphore
     */
    public void vote() throws InterruptedException, SemaphoreLimitError {
        super.release();
    }
    
}
