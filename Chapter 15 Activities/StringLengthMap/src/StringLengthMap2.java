import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Use the Java 8 merge() method from Java 8 Note 15.1.
 */
public class StringLengthMap2
{
    public static void main(String[] args)
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Character, Set<String>> firstLetterMap = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                if (!word.isEmpty()) {
                    char firstLetter = word.charAt(0);

                    // Use merge to update the map with the first letter as the key
                    firstLetterMap.merge(firstLetter, new TreeSet<>(Arrays.asList(word)),
                            (existingSet, newSet) -> {
                                existingSet.addAll(newSet);
                                return existingSet;
                            });
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
