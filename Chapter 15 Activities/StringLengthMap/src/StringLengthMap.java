import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args)
    {
        String filename = System.getProperty("user.dir") + "\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Character, Set<String>> firstLetterMap = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());

                // Update the map here
                // Modify Worked Example 15.1
                if (!word.isEmpty()) {
                    char firstLetter = word.charAt(0);

                    // Check if the map contains the first letter, if not, initialize it
                    Set<String> wordSet = firstLetterMap.get(firstLetter);
                    if (wordSet == null) {
                        wordSet = new TreeSet<>();
                        firstLetterMap.put(firstLetter, wordSet);
                    }
                wordSet.add(word);
                }
            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            for (Map.Entry<Character, Set<String>> entry : firstLetterMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
