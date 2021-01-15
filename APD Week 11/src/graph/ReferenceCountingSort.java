package graph;

import java.util.*;
import graph.GraphError;
/**
 * An implementation of the TopologicalSort interface, using a reference counting topological sort
 * 
 * @author Waqas Musharaf
 * @version January 2017
 */
public class ReferenceCountingSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T>  {
	
	/**
	 * Initialises the hash map and the array list containing the sorted elements
	 */
	private HashMap <T,Integer> hash = new HashMap <T,Integer>();
	private List<T> RCS = new ArrayList<T>();
	
	/**
	 * Returns the topological sort
	 * 
	 * @throws GraphError if the list is not valid
	 */
	@Override
	public List<T> sort() throws GraphError {
		return RCS;
	}
	
	/**
	 * Searches for the next node with no references
	 * 
	 * @return A node that is not in the list and has no references
	 * @return Null, if there is no such node 
	 */
	private T nextNoReference() {
		for (T node: getNodes()) {
			if (hash.get(node) == 0 && !RCS.contains(node)) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Adds all nodes with no references to the hash map
	 * 
	 * @throws GraphError if node is invalid
	 */
	private void setUpReferenceCount() throws GraphError {
		for (T node: getNodes()) {
			hash.put(node, 0);
		}
		for (T node: getNodes()) {
			for (T next: neighbours(node)) {
				if (hash.get(next) != null) {
					hash.put(next, hash.get(next) + 1);
				}			
			}
		}
	}
	
	/**
	 * Adds nodes to the list when visited
	 * 
	 * @throws GraphError if node is invalid
	 */
	private void visitNode(T node) throws GraphError {
		RCS.add(node);
		for (T next: neighbours(node)) {
			if (hash.get(next) != null) {
				hash.put(next, hash.get(next) - 1);
			}
		}
	}
	
	/**
	 * Starts the sort
	 */
	public void doSort() throws GraphError {
		setUpReferenceCount();
		T node;
		while ((node = nextNoReference()) != null) {
			visitNode(node);
		}
	}
}
