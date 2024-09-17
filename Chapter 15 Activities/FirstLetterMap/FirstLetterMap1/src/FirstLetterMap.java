import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
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
                Character firstLetter = word.charAt(0);

                // Update the map here using the Java 8 merge method
                firstLetterMap.merge(firstLetter, new TreeSet<>(Arrays.asList(word)), 
                    (existingSet, newSet) -> {
                        existingSet.addAll(newSet);
                        return existingSet;
                    });
            }

            // Print the map here in this form
            // a: [a, able, aardvark]
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
