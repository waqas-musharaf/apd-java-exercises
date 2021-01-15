package BoundedBuffer;


/**
 * A simple producer class.
 * 
 * @author Hugh Osborne 
 * @version January 2013
 */

import java.util.Random;
import Semaphore.*;

public class Producer<T> extends Thread
{
    private Buffer<T> buffer;   // the buffer used by this producer
    private Factory<T> factory; // the factory used by the producer to produce items
    private int delay;          // maximum wait between each buffer access (in millis)
    
    public Producer(Buffer<T> buffer,Factory<T> factory) {
        this.buffer = buffer;
        this.factory = factory;
        setName("Producer");
    }
    
    /**
     * Set the delay for this producer.  The producer will wait for a length of time
     * after each buffer access.
     * @param delay the maximum length of time, in seconds, that the producer will wait.
     */
    public void setDelay(double delay) {
        this.delay = (int) (delay*1000);
    }
    
    public void run() {
        try {
            while (buffer.isOpen()) { // as long as the buffer is open
                T item = factory.make();
                System.out.println("Producer: adding " + item);
                buffer.put(item);
                System.out.println("Producer: Added " + item + " to the buffer");
                try {
                    sleep(new Random().nextInt(delay));
                } catch (InterruptedException ie) {}
            }
            System.out.println("Producer has finished");
        } catch (BufferError be) {
            System.out.println(be.getMessage());
        } catch (SemaphoreLimitError sle) {
            System.out.println(sle.getMessage());
        }
    }
}
