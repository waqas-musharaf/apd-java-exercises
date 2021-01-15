package linkedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void testAdd() throws ListAccessError {
		SinglyLinkedList<Integer> testSLL = new SinglyLinkedList<Integer>();
		
		/**
		 * Adds values to the testSinglyLinkedList
		 */
		testSLL.add(0, 1);
		testSLL.add(1, 10);
		testSLL.add(2, 100);
		testSLL.add(3, 1000);
		
		/**
		 * Sets the test answer to value at the index(3)
		 * Sets the test answer's prediction value to 1000
		 */
		Integer answer = testSLL.get(3);
		Integer predict = 1000;
		
		/**
		 * Compares the answer value with the prediction value
		 */
		assertEquals(answer, predict);
	}
	
	@Test
	public void testRemove() throws ListAccessError {
		SinglyLinkedList<Integer> testSLL = new SinglyLinkedList<Integer>();
		
		/**
		 * Adds values to the testSinglyLinkedList
		 */
		testSLL.add(0, 1);
		testSLL.add(1, 10);
		testSLL.add(2, 100);
		testSLL.add(3, 1000);
		
		/**
		 * Removes value at index(2) from the testSinglyLinkedList
		 * This should result in index(3) with value(1000) moving down into index(2)
		 */
		testSLL.remove(2);
		
		/**
		 * Sets the test answer to value at the index(1)
		 * Sets the test answer's prediction value to 1000
		 * This is to see if index(3) has moved to index(2) due to the removal the old index(2)
		 */
		
		Integer answer = testSLL.get(2);
		Integer predict = 1000;
		
		/**
		 * Compares the answer value with the prediction value
		 */
		assertEquals(answer, predict);
	}
}

