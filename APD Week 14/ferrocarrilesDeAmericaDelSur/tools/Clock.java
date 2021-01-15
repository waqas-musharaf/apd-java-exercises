package tools;
import errors.SetUpError;
import railways.Railway;
import railways.RailwaySystem;


/**
 * Provides a clock system for railways, which will set an alarm that goes off after a certain length of time
 * @author hugh
 *
 */
public class Clock extends Thread {
	private boolean timeOut; // used to indicate whether the alarm has gone off
	private int tickTime; // time between ticks on this clock
	private int ticks; // number of ticks before the alarm goes off

	private RailwaySystem railwaySystem; // the railway system this clock is registered with
	
	/**
	 * The parameters specify the timing for this clock, in seconds
	 * @param tickTime the time between ticks on this clock
	 * @param ticks the number of ticks before the alarm should go off
	 * @throws SetUpError if a negative alarm time is specified
	 */
	
	public Clock(double tickTime, int ticks) throws SetUpError {
		if (tickTime < 0) {
			throw new SetUpError("A tick time on a clock must be a positive number");
		}
		this.tickTime = (int) (tickTime * 1000);
		if (ticks < 0) {
			throw new SetUpError("The number of ticks on the clock must be positive.");
		}
		this.ticks = ticks;
	}
	
	/**
	 * Register this clock with a railway system
	 * @param railwaySystem the railway system this clock is to be registered with
	 */
	public void register(RailwaySystem railwaySystem) {
		this.railwaySystem = railwaySystem;
	}
    
    /**
     * Has the alarm gone off for this clock?
     * @return true iff the alarm has gone off
     */
    public synchronized boolean timeOut() {
		return timeOut;
	}
	
    /**
     * Run this clock.  Sleep for the required time, then let the alarm off.
     */
	public void run() {
		timeOut = false;
		try {
			for (int tick = 0; tick < ticks; tick++) {
				if (Railway.errorOccurred()) {
					railwaySystem.trace("\t\t\t\t\t\tClock: emergency stop");
					break;
				}
				railwaySystem.trace("\t\t\t\t\t\tClock: tick tock");
				sleep(tickTime);
			}
		} catch (InterruptedException interrupt) {}
		timeOut = true;
		railwaySystem.trace("\t\t\t\t\t\tClock: brrrrring!");
	}
}

    

