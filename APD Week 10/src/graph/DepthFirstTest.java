package graph;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class DepthFirstTest {

	@Test
	public void DepthFirstTest() throws GraphError {
		DepthFirstTraversal<Integer> traversal = new DepthFirstTraversal<Integer>();
		List<Integer> predict = new ArrayList<>();
		
		/**
		 * Adds nodes to the traversal
		 */
		traversal.add(0);
		traversal.add(1);
		traversal.add(2);
		traversal.add(3);
		traversal.add(4);
		traversal.add(5);
		
		/**
		 * Connects nodes together
		 */
		traversal.add(0,1);
		traversal.add(0,3);
		traversal.add(1,2);
		traversal.add(2,1);
		traversal.add(2,4);
		traversal.add(4,5);
		traversal.add(5,4);
		
		/**
		 * Starts the traversal
		 */
		traversal.traverse();
		
		/**
		 * Prediction values for 'assert' comparison
		 */
		predict.add(0);
		predict.add(1);
		predict.add(2);
		predict.add(4);
		predict.add(5);
		predict.add(3);
		
		/**
		 * Checks actual values against predicted values
		 */
		assertEquals(predict,traversal.traverse());
	}
}

