package graph;

import java.util.*;
/**
 * An implementation of the Traversal interface using Depth-First Traversal
 * 
 * @author Waqas Musharaf
 * @version January 2017
 */
public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

	private Set<T> visited;
	private List<T> traversal;
	
	@Override
	/**
	 * If the 'nextUnvisited' method returns a node, the 'nextUnvisited' method is executed
	 * Repeats until the 'nextUnvisited' method doesn't return a node
	 * 
	 * @return An array list of traversed nodes
	 * @throws GraphError if the node is not a node in the graph
	 */
	public List<T> traverse() throws GraphError { 
		visited = new HashSet<T>();
		traversal = new ArrayList<T>();
		while(nextUnvisited() !=null) {
			traverse(nextUnvisited());
		};
		return (ArrayList<T>) traversal;
	}
	
	/**
	 * Checks next node, to see if it has been visited. If node has been visited, checks following node.
	 * Repeats until an unvisted node is found, or the list ends
	 * 
	 * @return an unvisited node, or return null if no such node exists
	 */
	protected T nextUnvisited() {
		for (T node: getNodes()) {
			if (!visited.contains(node)) {
				return node;
			}
		} 
			return null;
	}
	
	/**
	 * Keeps check of visited and traversed nodes.
	 * Forces visits of unvisited child nodes of pre-visited nodes
	 * 
	 * @throws GraphError if the node is not a node in the graph
	 */
	public void traverse (T node) throws GraphError {
		visited.add(node);
		traversal.add(node);
		for (T child : neighbours(node)) {
			if (!visited.contains(child)) {
				traverse(child);
			}
		}
	}
}

