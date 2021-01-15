package RandomArray;

import java.util.Random;
/**
 * Class for generating random strings.  The strings will be constructed
 * from characters in the RandomString object's alphabet field.
 * 
 * @author Hugh Osborne 
 * @version October 2016
 */
public class RandomString implements RandomArray<Character>
{
    private String alphabet;
    private Random random = new Random();
    
    public RandomString(String alphabet) {
        this.alphabet = alphabet;
    }
    
    public Character[] randomArray(int length) {
        Character[] string = new Character[length];
        for (int i = 0; i < length; i++) {
            string[i] = alphabet.charAt(random.nextInt(alphabet.length()));
        }
        return string;
    }
}
