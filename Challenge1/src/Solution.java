import java.util.Arrays;

/**
 * Given the size of the array and words, I found this approach adequate. But if the words were longer or the list
 * bigger, a better approach would be to calculate some sort of hash for each word and compare the hash values instead.
 * 
 * @author nbaalba
 *
 */
public class Solution {

    private static final String[] words = { "vase", "bat", "gods", "latte", "name", "apres", "spit", "joke", "ham",
        "dog", "act", "tale", "parse", "pits", "asper", "tab", "table", "mane", "late", "god", "cat", "table",
        "save", "spare" };

    /**
     * @param args
     */
    public static void main( String[] args ) {
        for ( int i = 0; i < words.length - 1; i++ ) {
            for ( int j = i + 1; j < words.length; j++ ) {
                if ( areAnagrams( words[i], words[j] ) ) {
                    System.out.printf( "%s %s \n", words[i], words[j] );
                }
            }
        }
    }

    /**
     * This method convert the strings to arrays, sort them and convert back to strings. The result is comparing the
     * values of the two strings.
     * 
     * @param word1
     * @param word2
     * @return boolean indicating whether the two words are anagrams
     */
    private static boolean areAnagrams( String word1, String word2 ) {
        char[] word1CharArr = word1.toCharArray();
        char[] word2CharArr = word2.toCharArray();

        Arrays.sort( word1CharArr );
        Arrays.sort( word2CharArr );

        word1 = Arrays.toString( word1CharArr ).trim();
        word2 = Arrays.toString( word2CharArr ).trim();
        return word1.equals( word2 );
    }

}
