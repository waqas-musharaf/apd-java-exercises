package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

	private Queue<T> toDo; // the to do list
	private List<T> traversal; // the traversal
	
	@Override
	/**
	 * Perform a breadth first traversal of the graph and return a list of nodes
	 * in the order in which they are visited.
	 * @return a breadth first traversal of the graph
	 */
	public List<T> traverse() throws GraphError {
		traversal = new ArrayList<T>(); // start a new traversal
		toDo = new ArrayDeque<T>(); // with a new toDo list
		T node = getUnvisitedNode(); // get an unvisited node
		while (node != null) { // while there is at least one unvisited node
			toDo.add(node); // add the unvisited node to the to do list
			traverseToDoList(); // and traverse the to do list
			node = getUnvisitedNode(); // and then get another unvisited node
		}
		return traversal;
	}

	/**
	 * Check if a node has been "visited".  A node counts as visited if it is:
	 * <ul>
	 *   <li> either in the traversal, having actually been visited
	 *   <li> or in the to do list, and therefore scheduled to be visited
	 * </ul>
	 * @return this node has been visited, or is scheduled to be visited
	 */
	private boolean isVisited(T node) {
		return
				traversal.contains(node) // the node has been visited and is in the traversal
				|| toDo.contains(node); // or it is in the to do list, and will therefore be visited
	}
	
	/**
	 * Get the next "unvisited" node.  This method will actually also count nodes
	 * that are scheduled to be visited (i.e. in the to do list) as visited.
	 * @return a node that has not yet been visited, and that is not yet scheduled to be visited, or return null if no such node exists
	 */
	private T getUnvisitedNode() {
		for (T node: getNodes()) { // check all the nodes
			if (!isVisited(node)) { // if this node has not been "visited"
				return node; // then this is an unvisited node
			}
		}
		// checked all nodes, and there are no unvisited nodes
		return null; // so return null
	}
	
	/**
	 * Use the to do list to traverse the graph.  
	 * @throws GraphError if node is not a node in the graph
	 */
	private void traverseToDoList() throws GraphError {
		while (toDo.size() > 0) { // as long as there are still nodes in the to do list
			T node = toDo.remove(); // get the next node from the to do list
			visitNode(node); // and visit that node
		}
	}
	
	/**
	 * Visit a node.
	 * @throws GraphError if node is not a node in the graph
	 */
	private void visitNode(T node) throws GraphError {
		if (isVisited(node)) return; // if the node is already visited do nothing
		traversal.add(node); // add the node to the traversal
		for (T neighbour: neighbours(node)) { // for all this node's neighbours
			if (!isVisited(neighbour)) // if the neighbour hasn't been visited
				toDo.add(neighbour); // add it to the end of the to do list
		}
	}
}