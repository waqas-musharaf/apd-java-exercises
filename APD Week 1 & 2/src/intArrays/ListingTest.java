package intArrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListingTest extends ArrayTest {

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

	public void testContents(int n,Listing listing) {
		for (int i = 0; i < n; i++) {
			boolean containsi = false;
			for (int index = 0; index < listing.getArray().length; index++) {
				if (listing.getArray()[index] == i) {
					containsi = true;
				}
			}
			if (!containsi) {
				fail("array " + Arrays.toString(listing.getArray()) + " does not contain " + i);
			}
		}
	}
	
}
