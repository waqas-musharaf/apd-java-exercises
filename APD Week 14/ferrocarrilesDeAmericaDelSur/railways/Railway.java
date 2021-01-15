package railways;
import errors.ProgrammingError;
import errors.RailwaySystemError;
import errors.SafetyViolationError;
import tools.Delay;

/**
 * Defines a basic railway system, for two railways with a shared single track pass.
 * 
 * @author hugh
 *
 */
public abstract class Railway extends Thread {
	private String name; // the name of the railway
	private static Basket sharedBasket = new Basket("shared basket"); // a shared basket for notifications
	private Basket basket; // private basket
	
	private RailwaySystem railwaySystem; // the system this railway forms part of
	private Delay delay; // the delay used by this railway
	private Position position; // the position of the train on this railway
	
	public Railway(String name,Delay delay) {
		this.name = name;
		this.delay = delay;
		position = Position.END_PASS; // all trains start just after the
		basket = new Basket(name + "'s basket");
	}

	/**
	 * Register this railway with a railway system
	 * @param railwaySystem the railway system this railway must be registered with
	 */
	public void register(RailwaySystem railwaySystem) {
		this.railwaySystem = railwaySystem;
	}
	
	/**
	 * Get the railway system this railway is registered with
	 * @return the railway system this railway is registered with
	 * @throws ProgrammingError if the railway is not registered
	 */
	public RailwaySystem getRailwaySystem() throws ProgrammingError {
		if (railwaySystem == null) {
			throw new ProgrammingError(name + " is not registered with a railway system");
		}
		return railwaySystem;
	}
	
	/**
	 * Get this railway's name
	 * @return this railway's name
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Get this railways private basket
	 * @return this railway's private basket
	 */
	public Basket getBasket() {
	    return basket;
	}
	
	/**
	 * Get the shared basket.
	 */
	public static Basket getSharedBasket() {
		return sharedBasket;
	}
	
	/**
	 * Use delay to generate a delay for this railway
	 */
	public void delay() {
		delay.delay();
	}
	
	// Fields keeping track of trains in the pass
	private static int trainsInPass = 0; // how many trains are in the pass
	
	public static enum Position {
		START_PASS, IN_PASS, END_PASS;
		
		public String toString() {
			switch (this) {
			case START_PASS: return "at the start of the pass";
			case IN_PASS: return "in the pass";
			case END_PASS: return "at the end of the pass";
			default: return "at an undefined position on the railway (ERROR)";
			}
		}
	}
	/**
	 * Enter the pass.
	 * This method does <i>not</i> check if it is safe to enter the pass. It is merely for
	 * administration of the information about trains in the pass.
	 * @throws ProgrammingError if this railway thinks it already has a train in the pass.
	 */
	private synchronized void enterPass() throws ProgrammingError {
		railwaySystem.trace(name + ": entering pass");
		if (position != Position.START_PASS) {
			throw new ProgrammingError(name + " cannot enter the pass, it is not " + Position.START_PASS + ", it is " + position + ".");
		}
		position = Position.IN_PASS;
		trainsInPass++;
	}
	
	/**
	 * Leave the pass.
	 * This method is merely for administration of the information about trains in the pass.
	 * @throws ProgrammingError if this railway thinks it does not have a train in the pass,
	 *                          or if there is no record of any trains in the pass.
	 */
	private synchronized void leavePass() throws ProgrammingError {
		if (position != Position.IN_PASS) {
			throw new ProgrammingError(name + " cannot leave the pass, it is not " + Position.IN_PASS + ", it is " + position + ".");
		}
		if (trainsInPass == 0) {
			throw new ProgrammingError("There is no train to leave the pass (even though " + name + " thinks it is in the pass.");
		}
		position = Position.END_PASS;
		trainsInPass--;
		railwaySystem.trace(name + ": leaving pass");
	}

	/**
	 * Travel round the safe part of the railway (outside the pass)
	 */
	public void choochoo() throws ProgrammingError {
		if (position != Position.END_PASS) {
			throw new ProgrammingError(name + " cannot traverse safe section, it is not " + Position.END_PASS + ", it is " + position + ".");
		}
		railwaySystem.trace (name + ": choo-choo");
		delay();
		position = Position.START_PASS;
	}
	
	/**
	 * Have a siesta.
	 */
	public void siesta() {
		railwaySystem.trace(name + ": zzzzz");
		delay();
	}
	
	/**
	 * Cross the pass.
	 * @throws SafetyViolationError if there is/are already train(s) on the pass.
	 */
	public void crossPass() throws RailwaySystemError {
		enterPass();
		if (trainsInPass > 1) {
			throw new SafetyViolationError("There are now " + trainsInPass + " trains in the pass!");
		}
		railwaySystem.trace(name + ": crossing pass");
		delay();
		leavePass();
	}
	
	// Error flag must be shared so that we can stop all railways if something goes wrong	
	private static boolean errorFlag = false;
	protected static String errorMessage = "";
	
    /**
     * Run the railway.
     */
    public void run() {
    	setErrorFlag(false);
    	try {
    		runTrain();
    	} catch (RailwaySystemError error) {
    		setErrorFlag(true);
    		errorMessage = error.getMessage();
    		System.out.println("!!! Something went wrong with the railway.\n\t" + errorMessage);
    	}
    	if (errorOccurred()) {
    		System.out.println("!!! " + name() + " shut down because of an error.\n\t" + errorMessage);
    	} else {
    		System.out.println(name() + " shut down because time limit was reached.");
    	}
    }
    
    /**
     * Each railway should independently define how the trains are to be run, using the basket(s)
     * to maintain safety on the pass.
     */
    public abstract void runTrain() throws RailwaySystemError;

	public static boolean errorOccurred() {
		return errorFlag;
	}

	public static void setErrorFlag(boolean errorFlag) {
		Railway.errorFlag = errorFlag;
	}
	
}
