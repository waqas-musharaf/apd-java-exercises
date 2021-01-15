package railways;
import java.util.ArrayList;
import java.util.List;

import errors.ProgrammingError;
import errors.RailwaySystemError;
import errors.SetUpError;
import tools.Clock;


public class RailwaySystem {
	
	private Clock clock = null; // the clock used to time railways - must be initialised for each run
	private List<Railway> railways;

	public RailwaySystem(List<Railway> railways,Clock clock) {
		this.clock = clock;
		this.railways = railways;
		clock.register(this);
		for (Railway railway: railways) {
			railway.register(this);
		}
	}
	
	/**
	 * Start the railway system
	 */
	private void start() {
		clock.start();
		for (Railway railway: railways) {
			railway.start();
		}
	}
	
	/**
	 * Wait for the system to stop
	 */
	private void stop() throws RailwaySystemError {
		try {
			clock.join();
			for (Railway railway: railways) {
				railway.join();
			}
		} catch (InterruptedException interrupt) {
			throw new RailwaySystemError("The railway system was interrupted: " + interrupt.getMessage());
		}
	}
	
	/**
	 * Given a railway, get the next one in the system's list
	 * @param railway the given railway
	 * @return the next railway in the list 
	 * @throws ProgrammingError if railway is neither peru not bolivia
	 */
	public Railway getNextRailway(Railway railway) throws ProgrammingError {
		int index = railways.indexOf(railway);
		if (index == -1) { // railway is not in the list
			throw new ProgrammingError(railway.name() + " is not registered with this system");
		}
		return railways.get((index+1) % railways.size());
	}
	
	/**
	 * Get this system's clock
	 * @return the system's clock
	 * @throws SetUpError if the clock is not initialised
	 */
	public Clock getClock() throws SetUpError {
		if (clock == null) {
			throw new SetUpError("Clock has not been intialised");
		}
		return clock;
	}
	
	/**
     * Provide a facility for switching tracing on/off.
     **/
    private boolean tracingOn = false;
    
    /**
     * Switch tracing on.
     **/
    public void traceOn() {
        tracingOn = true;
    }
    
    /**
     * Switch tracing off.
     **/
    public void traceOff() {
        tracingOn = false;
    }
    
    /**
     * Trace, if tracing is on
     * @param trace the trace to be output
     */
    public synchronized void trace(String trace) {
    	if (tracingOn) {
    		System.out.println(trace);
    	}
    }
    
    public static void main(String[] args) throws RailwaySystemError {
    	List<Railway> railways = new ArrayList<Railway>();
    	railways.add(new Peru());
    	railways.add(new Bolivia());
    	Clock clock = new Clock(1.0,20); // 20 ticks of 1 second
    	RailwaySystem system = new RailwaySystem(railways,clock);
    	system.traceOn();
    	system.start();
    	system.stop();
    }
 }
