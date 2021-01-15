package resourceManager;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * An implementation of the requestResource() and releaseResource() methods using locks and conditions
 * 
 * @author Waqas Musharaf
 * @version March 2017
 */

public class LockResourceManager extends BasicResourceManager {
	
	private Lock lock = new ReentrantLock();
	private Condition[] queues = new Condition[NO_OF_PRIORITIES];
	boolean used;
	/**
	 * Instantiates resource and maxUses
	 * 
	 * @param resource: the resource managed by this manager
	 * @param maxUses: the maximum number of uses permitted for this manager's resource.
	 */
	public LockResourceManager(Resource resource, int maxUses) {
		super(resource, maxUses);
		for (int priority = 0; priority < NO_OF_PRIORITIES; priority++) {
			queues[priority] = lock.newCondition();
		}
	}
	/**
	 * Request use of this manager's resource, with the specified priority.
	 * If the resource is in use the requesting user will have to wait for the resource to be released.
	 */
	@Override
	public void requestResource(int priority) throws ResourceError {
		lock.lock();
		try
		{
			if (used) {
				increaseNumberWaiting(priority);
				queues[priority].await();
				decreaseNumberWaiting(priority);
			}
		used = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	/**
	 * Release this manager's resource.  If any users are waiting for the resource a waiting user with the
     * highest priority will be woken.
	 */
	@Override
	public int releaseResource() throws ResourceError {
		lock.lock();
		try
		{
			for (int x = NO_OF_PRIORITIES; x == 0; x--) {
				if (getNumberWaiting(x) > 0) {
					queues[x].signal();
					break;
				}
			}
		}
		finally {
			lock.unlock();
		}
		return 0;
	}
}
