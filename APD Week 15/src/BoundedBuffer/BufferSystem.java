package BoundedBuffer;


/**
 * Demonstrates the use of buffers.
 * 
 * @author Hugh Osborne
 * @version January 2013
 */
import Semaphore.*;

public class BufferSystem extends Thread
{
    /**
     * Start up a producer and a consumer.
     * A call of main can have up to four arguments.
     * The first argument should be an integer specifying the size of the buffer.
     * If this argument is missing, or if it is not an integer, the default value of 10 is used.
     * The second argument should be a floating point number specifying
     * the number of seconds the buffer is to stay open for.  If this argument is missing, 
     * or if it is not an integer, the default value of 10 is used.
     * The remaining two arguments should be floating point numbers, specifying maximum delays
     * to be applied to the producer and consumer, thereby affecting their speeds.  The buffer
     * will be run for the first half of its run-time with the first delay applied to the
     * producer amd the second applied to the consumer.  After half the run-time the delays will
     * be swapped round.  If the third argument is missing, or if it is not a floating point
     * number the default value of 1 is used.  if the fourth argument is missing, or if it is
     * not a floating point number then the value used for the third argument will be used.
     */
    @SuppressWarnings("unchecked") // suppress warning from cast of argument of sleep
    public static void main(String[] args) {
        int bufferSize = 10;
        double bufferTimeToRun = 10.0, delay1 = 1.0, delay2 = 1.0;
        if (args.length >= 1) {
            try {
                bufferSize = Integer.valueOf(args[0]);
            } catch (NumberFormatException nfe) {
                System.out.println("Buffer size \"" + args[0] + "\" was in the wrong format.\n;" +
                                   "Using a buffer size of " + bufferSize);
            }
        } else {
            System.out.println("Buffer size was missing.\n" +
                               "Using a buffer size of " + bufferSize);
        }
        if (args.length >= 2) {
            try {
                bufferTimeToRun = Double.valueOf(args[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("Buffer run time \"" + args[1] + "\" was in the wrong format.\n;" +
                                   "Using a buffer run time of " + bufferTimeToRun + " second(s).");
            }
        } else {
            System.out.println("Buffer run time was missing.\n" +
                               "Using a buffer run time of " + bufferTimeToRun + "second(s).");
        }
        if (args.length >= 3) {
            try {
                delay1 = Double.valueOf(args[2]);
            } catch (NumberFormatException nfe) {
                System.out.println("First delay argument \"" + args[2] + "\" was in the wrong format.\n;" +
                                   "Using a delay of " + delay1 + " second(s).");
            }
        } else {
            System.out.println("First delay argument was missing.\n" +
                               "Using a delay of " + delay1 + "second(s).");
        }
        delay2 = delay1;
        if (args.length >= 4) {
            try {
                delay2 = Double.valueOf(args[3]);
            } catch (NumberFormatException nfe) {
                System.out.println("Second delay argument \"" + args[3] + "\" was in the wrong format.\n;" +
                                   "Using a delay of " + delay2 + "second(s).");
            }
        } else {
            System.out.println("Second delay argument was missing.\n" +
                               "Using a delay of " + delay2 + "second(s).");
        }
        System.out.println("Buffer can hold up to " + bufferSize + " elements");
        System.out.println("System will run for " + bufferTimeToRun + "s");
        System.out.println("System will start with producer taking up to " + delay1 + "s for each buffer access");
        System.out.println("and consumer taking up to " + delay2 + "s");
        System.out.println("System will then change to producer taking up to " + delay2 + "s");
        System.out.println("and consumer taking up to " + delay1 + "s for each buffer access");
        Buffer<Integer> buffer = new Buffer<Integer>(bufferSize);
        Producer<Integer> producer = new Producer(buffer,new IntegerFactory());
        producer.setDelay(delay1);
        Consumer<Integer> consumer = new Consumer(buffer);
        consumer.setDelay(delay2);
        producer.start();
        consumer.start();
        try {
            sleep((int) (bufferTimeToRun*500));
            producer.setDelay(delay2); // swap the delays round
            consumer.setDelay(delay1);            
            sleep((int) (bufferTimeToRun*500));
            try {
                buffer.close();
            } catch (BufferError be) {}
            consumer.join();
            producer.join();
            System.out.println("System terminated");
        } catch (InterruptedException ie) {
            System.out.println("The system was interrupted: " + ie.getMessage());
        } catch (SemaphoreLimitError sle) {
            System.out.println(sle.getMessage());
        }
    }
        
}
