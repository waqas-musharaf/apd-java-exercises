package railways;

import errors.RailwaySystemError;
import errors.SetUpError;
import tools.Clock;
import tools.Delay;

public class Peru extends Railway {
	/**
	 * @throws RailwaySystemError if there is an error in constructing the delay
	 * Change the parameters of the Delay constructor in the call of the superconstructor to
	 * change the behaviour of this railway.
	 */
	public Peru() throws SetUpError{
		super("Peru",new Delay(0.1,0.3));
	}

    /**
     * Run the train on the railway.
     * This method provides (incorrect) synchronisation attempting to avoid more than one train in the 
     * pass at any one time.
     */
    public void runTrain() throws RailwaySystemError {

    	Clock clock = getRailwaySystem().getClock();
    	Railway nextRailway = getRailwaySystem().getNextRailway(this);
    	
    	while (!clock.timeOut()) {
    		choochoo();
    		getBasket().putStone(this);
    		while (nextRailway.getBasket().hasStone(this)) { 
    			if  (getSharedBasket().hasStone()) {
    				getBasket().takeStone(this);
    				while (!getSharedBasket().hasStone()) { 
    					siesta();
    				}
    				getBasket().putStone(this);
    			}
    		}
    		crossPass();
    		getBasket().takeStone(this);
    		getSharedBasket().putStone(this);
    	}
    }
}
