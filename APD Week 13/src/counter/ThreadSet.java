package counter;
import java.util.Set;
import java.util.HashSet;

/**
 * Provide facilities for building a collection of Counters and
 * running them simultaneously
 * 
 * @author Hugh Osborne 
 * @version January 2016
 */
public interface ThreadSet<T extends Thread> extends Set<T>
{
	/**
	 * Run all the threads in this thread set in parallel, and wait for them to finish
	 */
	public void runSet() throws InterruptedException;
}
