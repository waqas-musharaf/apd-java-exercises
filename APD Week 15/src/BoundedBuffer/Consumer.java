package BoundedBuffer;


/**
 * a simple consumer class.
 * 
 * @author Hugh Osborne
 * @version January 2013
 */

import java.util.Random;
import Semaphore.*;

public class Consumer<T> extends Thread
{
    private Buffer<T> buffer; // the buffer used by this consumer
    private int delay;        // maximum delay between each buffer access (in millis)
    
    public Consumer(Buffer<T> buffer) {
        this.buffer = buffer;
        setName("Consumer");
    }
    
    /**
     * Set the delay for this consumer.  The consumer will wait for a length of time
     * after each buffer access.
     * @param delay the maximum length of time, in seconds, that the consumer will wait.
     */
    public void setDelay(double delay) {
        this.delay = (int) (delay*1000);
    }
    
    public void run() {
        try {
            while (buffer.isOpen()) {
            	System.out.println("Consumer: Retrieving data item");
                T item = buffer.get();
                System.out.println("Consumer: Retrieved " + item + " from the buffer");
                try {
                    sleep(new Random().nextInt(delay));
                } catch (InterruptedException ie) {}
            }
            System.out.println("Consumer has finished");
        } catch (BufferError be) {
            System.out.println(be.getMessage());
        } catch (SemaphoreLimitError sle) {
            System.out.println(sle.getMessage());
        }
    }
}
