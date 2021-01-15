package BoundedBuffer;


/**
 * A simple buffer error class.
 * 
 * @author Hugh Osborne 
 * @version January 2013
 */
public class BufferError extends Exception
{
    public BufferError() {
        super("Buffer error: no further information");
    }
    
    public BufferError(String message) {
        super("Buffer error: " + message);
    }
}
