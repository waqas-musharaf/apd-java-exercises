package stringSearcher;


/**
 * Implements the simple sequential substring search algorithm
 * 
 * @author Hugh Osborne
 * @version October 2016
 */
public class SequentialStringSearch extends StringSearchTool
{
    public SequentialStringSearch(Character[] string) {
        super(string);
    }
    
    public int occursIn(Character[] superstring) throws NotFound {
        for (int index = 0; index < superstring.length - string().length; index++) {
            if (occursAt(superstring,index)) {
                return index;
            }
        }
        throw new NotFound();
    }
    
    private boolean occursAt(Character[] superstring,int index) {
        for (int i = 0; i < string().length; i++) {
            if (string()[i] != superstring[i+index]) {
                return false;
            }
        }
        return true;
    }
}