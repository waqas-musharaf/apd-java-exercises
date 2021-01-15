package counter;

/** 
 * @author Hugh Osborne 
 * @version January 2013
 */
public class CounterException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4579504576337302201L;

	/**
     * Various errors may occur when defining a counter.  E.g.
     * <ul>
     * <li> counting in the wrong direction (e.g. from 0 to 10 in steps of -1)
     * <li> using an increment value of 0
     * </ul>
     * Define an Exception class for these errors.
     **/
     
     public CounterException(String s) {
         super(s);
    }
}
