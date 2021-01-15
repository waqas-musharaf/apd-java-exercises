package resourceManager;


/**
 * This JUnitTest does <i>not</i> test the resource system in the sense of reporting a pass or a fail
 * in a test.  It simply runs the resource system specified in the test.  It is up to the user to inspect
 * the output produced by this test to check that the system displays the behaviour expected.
 *
 * @author  Hugh Osborne
 * @version February 2013
 */
public class ResourceSystemTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class ResourceSystemTest
     */
    public ResourceSystemTest()
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
     * Four users sharing one resource.
     */
	public void test4_1() throws ResourceError
	{
		ResourceSystem resource1 = new ResourceSystem();
		resource1.addResource("A", 20); // The resource - may be used up to 20 times
		resource1.addUser("1",0.1); // User 1 uses the resource for up to 1/10 second each time
		resource1.addUser("2",0.1); // User 2 uses the resource for up to 1/10 second each time
		resource1.addUser("3",0.2); // User 3 uses the resource for up to 1/5 second each time
		resource1.addUser("4",0.2); // User 4 uses the resource for up to 1/5 second each time
		resource1.run();
	}
}

