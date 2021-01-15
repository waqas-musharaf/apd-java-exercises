package graph;
/**
 * Superclass for specific graph errors
 * 
 * @author Hugh Osborne
 * @version December 2013
 */
public class GraphError extends Exception
{
    public GraphError() {
        super("Unspecified graph error");
    }
    
    public GraphError(String message) {
        super(message);
    }
}