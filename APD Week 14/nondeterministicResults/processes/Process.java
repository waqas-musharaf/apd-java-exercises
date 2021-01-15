package processes;

/**
 * Define a process with two shared variables.
 * This class is abstract because it does not implement
 * run.
 */
public abstract class Process extends Thread {
	protected static int x = 0;
	protected static int y = 2;
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
}
