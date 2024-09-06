import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class WordAnalysis {
    public static void main(String[] args)
            throws FileNotFoundException {
        // Read dict file and novel file
        Set<String> dictionaryWords = readWords("./src/words");
        Set<String> novelWords = readWords("./src/war-and-peace.txt");

        for (String word : novelWords) {
            if(dictionaryWords.contains(word)) {
                System.out.println(word);
            }
        }

        System.out.println("There are " + novelWords.size() + " unique words in novel. ");

        Iterator<String> interator = novelWords.iterator();
        while(interator.hasNext()) {
            if(interator.next().length() > 3) {
                interator.remove();
            }
        }
        System.out.println("There are " + novelWords.size() + " with more than 3 letters. ");

    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     *         word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException {
            // Hash set bc order does not matter
            Set<String> words = new HashSet<>();

            // Determine current working dir
            // System.out.println(System.getProperty("user.dir"));

            Scanner in = new Scanner(new File(filename), "UTF-8");

            in.useDelimiter("[^a-zA-Z+]");

            while(in.hasNext()) {
                // Dups are ignored
                words.add(in.next().toLowerCase());
            }

            return words;
        }
}
