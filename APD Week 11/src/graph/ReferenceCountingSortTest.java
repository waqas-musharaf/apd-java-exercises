package graph;

import static org.junit.Assert.*;
import graph.GraphError;
import java.util.*;
import org.junit.Test;

public class ReferenceCountingSortTest {

	@Test
	public void ReferenceCountingSortTest() throws GraphError {
		ReferenceCountingSort<Integer> RCS = new ReferenceCountingSort<Integer>();
		List<Integer> predict = new ArrayList<>();
		
		/**
		 * Adds nodes to the graph
		 */
		RCS.add(0);
		RCS.add(1);
		RCS.add(2);
		RCS.add(3);
		RCS.add(4);
		RCS.add(5);
		RCS.add(6);
		RCS.add(7);
		RCS.add(8);
		RCS.add(9);
		
		/**
		 * Connects nodes together
		 */
		RCS.add(0,1);
		RCS.add(0,5);
		RCS.add(1,7);
		RCS.add(3,2);
		RCS.add(3,4);
		RCS.add(3,8);
		RCS.add(6,0);
		RCS.add(6,1);
		RCS.add(6,2);
		RCS.add(8,4);
		RCS.add(8,7);
		RCS.add(9,4);
		
		/**
		 * Starts the sort
		 */
		RCS.doSort();
		
		/**
		 * Prediction values for 'assert' comparison
		 */
		predict.add(3);
		predict.add(6);
		predict.add(0);
		predict.add(1);
		predict.add(2);
		predict.add(5);
		predict.add(8);
		predict.add(7);
		predict.add(9);
		predict.add(4);
		
		/**
		 * Checks actual values against predicted values
		 */
		assertEquals(predict, RCS.sort());
	}
}
