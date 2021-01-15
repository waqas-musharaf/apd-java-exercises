package graph;
/**
 * Superclass for specific graph errors
 * 
 * @author Hugh Osborne
 * @version December 2013
 */
public class GraphError extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphError() {
        super("Unspecified graph error");
    }
    
    public GraphError(String message) {
        super(message);
    }
}