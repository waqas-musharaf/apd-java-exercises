package graph;
/**
 * An implementation of graphs using adjacency lists
 * 
 * @author Hugh Osborne
 * @version November 2013
 */

// Will use a hashtable to implement the adjacency list
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyGraph<T> implements Graph<T>
{
    // The adjacency list: maps a node to a set containing the neighbours of that node
    private HashMap<T,Set<T>> adjacencyList = new HashMap<T,Set<T>>();
    
    // Fields used to keep the number of nodes and edges in the graph
    private int noOfNodes = 0, noOfEdges = 0;
    
    /**
     * @return (<tt>node</tt> is a node in this graph)
     */
    public boolean contains(T node) {
        return getNodes().contains(node);
    }
    
    /**
     * @return (there is an edge from <tt>start</tt> to <tt>end</tt> in this graph)
     */
    public boolean contains(T start,T end) {
        // check that both nodes are in the graph, and then check that "end" is in
        // "start"'s entry in the adjacency list
        return contains(start) && contains(end) && adjacencyList.get(start).contains(end);
    }
    
    /**
     * Add node <tt>node</tt> to the graph
     * @throws GraphError if the node is already in this graph
     */
    public void add(T node) throws GraphError {
        if (contains(node)) {
            throw new GraphError("Cannot add " + node + " to the graph.  This node is already in the graph already contains " + node);
        } else {
            // Add a new entry to the adjacency list.  This is a new node, so it will not yet have any
            // neighbours, so its entry in the adjacency list will be a new, empty, set
            adjacencyList.put(node,new HashSet<T>());
            // increase number of nodes
            noOfNodes++;
        }
    }
    
    /**
     * Remove node <tt>node</tt>, and all edges leading to and from it, from this graph
     * @throws GraphError if the node does not exist
     */
    public void remove(T node) throws GraphError {
        if (!contains(node)) {
            throw new GraphError("Cannot remove " + node + " from the graph.  No such node.");
        } else {
            // remove the node and all edges leaving it by removing its entry in the adjacency list
            // before doing so reduce the number of edges about to be removed
            noOfEdges -= neighbours(node).size();
            adjacencyList.remove(node);
            // reduce number of nodes
            noOfNodes--;
            // remove any links to the node by removing the node, if present, from all of the remaining
            // entries in the adjacencyList
            for (T start: adjacencyList.keySet()) {
                if (contains(start,node)) {
                    // reduce number of edges
                    noOfEdges--;
                    // remove edge
                    remove(start,node);
                }
            }
        }
    }
    
    /**
     * Add an edge from <tt>start</tt> to <tt>end</tt> to this graph
     * @throws GraphError if the edge already exists, or if either <tt>start</tt> or <tt>end</tt> is not a node in this graph
     */
    public void add(T start, T end) throws GraphError {
        if (contains(start,end)) {
            throw new GraphError("Cannot add " + start + "==>" + end + " to the graph.  This link is already in the graph.");
        } else if (!contains(start) || !contains(end)) {
            throw new GraphError("Cannot add " + start + "==>" + end + " to the graph.  One or more of the nodes is not in the graph.");
        } else {
            // add the edge by adding "end" to "start"'s entry in the adjacency list
            adjacencyList.get(start).add(end);
            // increase number of edges
            noOfEdges++;
        }
    }

    /**
     * Remove the edge from <tt>start</tt> to </tt>end</tt> from the graph
     * @throws GraphError if there is no such edge in this graph
     */
    public void remove(T start, T end) throws GraphError {
        if (!contains(start,end)) {
            throw new GraphError("Cannot remove " + start + "==>" + end + " from the graph.  There is no such edge in the graph.");
        } else {
            // delete "end" from "start"'s entry in the adjacency list
            adjacencyList.get(start).remove(end);
            // decrease the number of edges
            noOfEdges--;
        }
    }

    /**
     * @return a set of the immediate successors of node <tt>node</tt>
     * @throws GraphError if <tt>node</tt> is not a node in this graph
     */
    public Set<T> neighbours(T node) throws GraphError {
        // The neighbours can be accessed through this node's entry in the adjacency list.
        // Note: Create a copy of the entry to avoid users being able to change the adjacency list.
        HashSet<T> copy = new HashSet<T>();
        for (T member: adjacencyList.get(node)) {
            copy.add(member);
        }
        return copy;
    }

    /**
     * @return the number of nodes currently in this graph
     */
    public int noOfNodes() {
        return noOfNodes;
    }
    
    /**
     * @return a set of the nodes in the graph
     */
    public Set<T> getNodes() {
        // Note: The nodes can be accessed through the adjacency list's key set.
        // Note: Create a copy of the key set to avoid users being able to change the adjacency list
        HashSet<T> copy = new HashSet<T>();
        for (T member: adjacencyList.keySet()) {
            copy.add(member);
        }
        return copy;
    }
    
    /**
     * @return the number of edges currently in this graph
     */
    public int noOfEdges() {
        return noOfEdges;
    }
}