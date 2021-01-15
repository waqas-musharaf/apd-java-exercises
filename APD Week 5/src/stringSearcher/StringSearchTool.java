package stringSearcher;

/**
 * A partial implementation  of the StringSearch interface
 * 
 * Specific string search algorithms should be extensions of this abstract
 * class, implementing occursIn(string superstring)
 * 
 * @author Hugh Osborne
 * @version 2016
 */
public abstract class StringSearchTool implements StringSearch 
{
    private Character[] string;
    private int foundAt; // index where last substring was found;
    
    public StringSearchTool(Character[] string) {
        this.string = string;
    }
    
    public Character[] string() {
        return string;
    }
    
   /**
     * Report where the last substring was found
     * @return index at which the last substring was found (or -1 if no such substring)
     */
    public int foundAt() {
        return foundAt;
    }    

}