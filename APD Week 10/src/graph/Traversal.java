package graph;

/**
 * Defines the interface for graph traversals
 * 
 * @author Hugh Osborne
 * @version November 2013
 */

import java.util.List;

public interface Traversal<T> extends Graph<T>
{
    /**
     * @return a traversal of the graph in which each node is visited exactly once
     */
    public List<T> traverse() throws GraphError;
}