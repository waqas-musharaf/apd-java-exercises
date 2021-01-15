package intArrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortedListingTest extends ListingTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOneSize() {
		testSize(1,new SortedListing(1));
	}
	
	@Test
	public void testOneContents() {
		testContents(1,new SortedListing(1));
	}
	@Test
	public void testTwoSize() {
		testSize(2,new SortedListing(2));
	}
	
	@Test
	public void testTwoContents() {
		testContents(2,new SortedListing(2));
	}
	@Test
	public void testFourSize() {
		testSize(4,new SortedListing(4));
	}
	
	@Test
	public void testFourContents() {
		testContents(4,new SortedListing(4));
	}
	@Test
	public void testHundredSize() {
		testSize(100,new SortedListing(100));
	}
	
	@Test
	public void testHundredContents() {
		testContents(100,new SortedListing(100));
	}

	@Test
	public void testThousandSize() {
		testSize(1000,new SortedListing(1000));
	}
	
	@Test
	public void testThousandContents() {
		testContents(1000,new SortedListing(1000));
	}

	@Test
	public void testMillionSize() {
		testSize(1000000,new SortedListing(1000000));
	}
}
