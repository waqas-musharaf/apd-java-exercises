package tools;
/**
 * Provides methods for slowing down processes.
 * @author hugh
 *
 */


import java.util.Random;

import errors.SetUpError;

public class Delay {
	private int  // time fields - all times in milliseconds
	   minimumDelay, // the minimum delay
	   maximumDelay; // the maximum delay
	
 // Random number generator used to generate delay intervals
	private Random random = new Random();
	
	/**
	 * The parameters specify the timing for this delay.  All times are in seconds
	 * @param minimumDelay minimum delay to be returned by the delay() method
	 * @param maximumDelay maximum delay to be returned by the delay() method
	 * @throws SetUpError if either delay is negative, or if the maximum delay is less than the minimum
	 */
	
	public Delay(double minimumDelay,double maximumDelay) throws SetUpError {
		if (minimumDelay < 0 || maximumDelay < 0) {
			throw new SetUpError("A delay must be a positive number");
		} else if (maximumDelay <= minimumDelay) {
			throw new SetUpError("The maximum delay for a clock must be more than its minimum delay");
		}
		this.minimumDelay = (int) (minimumDelay * 1000);
		this.maximumDelay = (int) (maximumDelay * 1000);
	}
	
	/**
	 * The parameters specify the timing for this delay.  All times are in seconds
	 * @param maximumDelay maximum delay to be returned by the delay() method
	 * The minimum delay is set to zero.
	 * @throws SetUpError if the maximum delay is negative
	 */
	
	public Delay(double maximumDelay) throws SetUpError {
		this(0.0,maximumDelay);
	}
	
	/**
	 * Calling thread sleeps for a random time specified by the delay parameters
	 **/
	public void delay() {
		try {
			Thread.sleep(minimumDelay + random.nextInt(maximumDelay-minimumDelay));
		} catch (InterruptedException ie) {}
	}

}
