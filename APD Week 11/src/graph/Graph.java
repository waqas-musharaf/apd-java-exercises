package graph;
/** This code defines an interface and should not be modified.
 * 
 * @author Hugh Osborne
 * @version November 2013
 */

import java.util.Set;

public interface Graph<T> {

    /**
     * @return (<tt>node</tt> is a node in this graph)
     */
    public boolean contains(T node);
    
    /**
     * @return (there is an edge from <tt>start</tt> to <tt>end</tt> in this graph)
     */
    public boolean contains(T start,T end);
    
    /**
     * Add node <tt>node</tt> to the graph
     * @throws GraphError if the node is already in this graph
     */
    public void add(T node) throws GraphError;
    
    /**
     * Remove node <tt>node</tt>, and all edges leading to and from it, from this graph
     * @throws GraphError if the node does not exist
     */
    public void remove(T node) throws GraphError;
    
    /**
     * Add an edge from <tt>start</tt> to <tt>end</tt> to this graph
     * @throws GraphError if the edge already exists, or if either <tt>start</tt> or <tt>end</tt> is not a node in this graph
     */
    public void add(T start, T end) throws GraphError;

    /**
     * Remove the edge from <tt>start</tt> to </tt>end</tt> from the graph
     * @throws GraphError if there is no such edge in this graph
     */
    public void remove(T start, T end) throws GraphError;

    /**
     * @return a list of the immediate successors of node <tt>node</tt>
     * @throws GraphError if <tt>node</tt> is not a node in this graph
     */
    public Set<T> neighbours(T node) throws GraphError;

    /**
     * @return the number of nodes currently in this graph
     */
    public int noOfNodes();
    
    /**
     * @return a set containing all the nodes in this graph
     */
    public Set<T> getNodes();

    /**
     * @return the number of edges currently in this graph
     */
    public int noOfEdges();

}