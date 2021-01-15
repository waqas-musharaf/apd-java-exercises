package counter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountTest {
	
	private ThreadSet<Counter> countSet;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Counter.traceOn();
		Counter.setDelay(1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		countSet = new ThreadHashSet<Counter>();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void test_5_10_and_5_0() throws InterruptedException {
		countSet.add(new Counter(5,10));
		countSet.add(new Counter(5,0));
		countSet.runSet();
	}*/

	@Test
	public void doubleCounterTrace() throws CounterException, InterruptedException {
		
		/**
		 * Creates two Counter variables
		 * c1 counts from 0 to 10 in increments of 1
		 * c2 counts from 10 to 0 in decrements of 1
		 */
    	Counter c1 = new Counter("Counter 1", 0, 10, 1);
    	Counter c2 = new Counter("Counter 2", 10, 0,-1);
    	
    	/**
    	 * Instantiates a new ThreadHashSet
    	 */
    	ThreadHashSet<Counter> ths = new ThreadHashSet<Counter>();
    	
    	/**
    	 * Adds both counters to the ThreadHashSet
    	 */
    	ths.add(c1);
    	ths.add(c2);
    	
    	/**
    	 * Starts the trace and runs the count
    	 */
    	Counter.traceOn();
    	ths.runSet();
    }
}
