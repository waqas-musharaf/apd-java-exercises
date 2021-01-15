package BoundedBuffer;


/**
 * A Factory that builds Integers.  The initial Integer has value zero.  The value of the
 * Integer produced increments for each Integer produced.
 * 
 * @author Hugh Osborne
 * @version January 2013
 */
public class IntegerFactory implements Factory<Integer>
{
    private int counter; 
    
    public IntegerFactory() {
        counter = 0;
    }
    
    public IntegerFactory(int n) {
        counter = n;
    }
    
    public Integer make() {
        Integer item = new Integer(counter);
        counter++;
        return item;
    }
}
