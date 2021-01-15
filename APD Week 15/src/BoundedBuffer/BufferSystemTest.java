package BoundedBuffer;



/**
 * The test class BufferSystemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BufferSystemTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BufferSystemTest
     */
    public BufferSystemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Buffer of size 10.  Run time 20 seconds.
     * Producer and consumer equally fast.
     */
	public void test10_10_1_1()
	{
	    String[] args = {"10","20","1","1"};
	    BufferSystem.main(args);
	}
	
    /**
     * Buffer of size 10.  Run time 20 seconds.
     * Producer initially fast and consumer initially slow.
     */
	public void test10_20_half_2()
	{
	    String[] args = {"10","20","0.5","2"};
	    BufferSystem.main(args);
	}
	
    /**
     * Buffer of size 10.  Run time 20 seconds.
     * Producer initially slow and consumer initially fast.
     */
	public void test10_20_2_half()
	{
	    String[] args = {"10","20","2","0.5"};
	    BufferSystem.main(args);
	}
}

