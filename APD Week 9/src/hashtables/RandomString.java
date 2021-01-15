package hashtables;
import java.util.Random;

/**
 * A facility for generating random strings.
 * The string will be constructed from randomly chosen characters
 * from '0'-'9', 'a'-'z', 'A'-'Z' and '_'.
 * The strings generated will all be of a predetermined length.
 * 
 * @author Hugh Osborne 
 * @version October 2011
 */
public class RandomString implements RandomGenerator<String>
{
    private int length; // the length of string to generate
    private static final int DEFAULT_LENGTH = 1;
    private char[] permissibleCharacters; // array of permissible characters
    private static final char[] DEFAULT_CHARACTERS = defaultPermissibleCharacters();
    private Random random = new Random(); // the random generator
    
    /**
     * @param length the length of the strings to be generated
     * @param permissibleCharacters the characters the random strings are to be generated from
     */
    public RandomString(int length,char[] permissibleCharacters) throws RandomGenerator.Error {
        setLength(length); // set the length
        this.permissibleCharacters = permissibleCharacters; // set the default permissible characters
    }
    
    public RandomString(int length) throws RandomGenerator.Error {
        this(length,DEFAULT_CHARACTERS);
    }
    
    public RandomString(char[] permissibleCharacters) throws RandomGenerator.Error {
        this(DEFAULT_LENGTH,permissibleCharacters);
    }
    
    public RandomString() throws RandomGenerator.Error {
        this(DEFAULT_LENGTH,DEFAULT_CHARACTERS);
    }
    
    /**
     * Set the length of the strings to be generated
     * @param length the length of the strings to be generated
     */
    private void setLength(int length) throws RandomGenerator.Error {
        if (length <= 0) {
            throw new RandomGenerator.Error("generated string length must be greater than zero");
        } else {
            this.length = length;
        }
    }
    
    /**
     * Create an array of permissible characters.  These are
     * '0'-'9', 'a'-'z', 'A'-'Z' and '_' (in total 63 characters)
     */
    private static char[] defaultPermissibleCharacters() {
        char[] characters = new char[63];
        int index;
        // add digits
        for (index = 0; index < 10; index++) {
            characters[index] = (char) ('0' + index);
        }
        // add lower case characters
        for (char c = 'a'; c <= 'z'; c++, index++) {
            characters[index] = c;
        }
        // add upper case characters
        for (char c = 'A'; c <= 'Z'; c++, index++) {
            characters[index] = c;
        }
        // add underscore
        characters[index] = '_';
        return characters;
    }
    
    /**
     * Generates a random string the set length 
     * @returns a random String of the given length
     */
    public String generate() {
        // generate as a char array, then convert to string
        char[] string = new char[length];
        for (int i = 0; i < length; i++) {
            // add a random character from the permissible characters
            string[i] = permissibleCharacters[random.nextInt(permissibleCharacters.length)];
        }
        return new String(string);
    } // end of method generate
}
