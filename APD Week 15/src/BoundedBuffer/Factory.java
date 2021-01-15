package BoundedBuffer;


/**
 * Factories make things.  A Factory has a make() method that will create and return
 * an object of the required type/
 * 
 * @author Hugh Osborne 
 * @version January 2013
 */
public interface Factory<T>
{
    /**
     * Build and return a new item
     * @return item the new item created
     */
    public T make();
}
