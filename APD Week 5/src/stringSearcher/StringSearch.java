package stringSearcher;


/**
 * StringSearch essentially extends the functionality of a String
 * to search for that String in a superstring.
 * 
 * Since the java String class is final we cannot extend it.  StringSearch
 * provides access to its String object with the string() method.
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */

public interface StringSearch
{
    /**
     * @return this StringSearch's String object
     */
    public Character[] string();
    
    /**
     * Check for an occurrence of this StringSearch's string in a
     * superstring
     * @param superstring the superstring to be searched
     * @return the index of the leftmost occurrence of this StringSearch's
     * string in the superstring, if this exists
     * @throws NotFound if no such occurrence can be found
     */
    public int occursIn(Character[] superstring) throws NotFound;
}