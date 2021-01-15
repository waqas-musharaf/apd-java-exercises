package graph;

import java.util.List;

public interface TopologicalSort<T> extends Graph<T> {
	
	/**
	 * Do a topological sort on this graph, if it is acyclic.  A topological sort is a listing of the nodes in
	 * the (acyclic) graph such that if there is a path in the graph from node A to node B then node A will appear
	 * before node B in the listing.
	 * @return A topological sort of this graph
	 * @throws GraphError if the graph is not acyclic
	 */
	public List<T> sort() throws GraphError;

}
