import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> firstIterator = strings.listIterator();
        ListIterator<String> lastIterator = strings.listIterator(strings.size());

        for(int i = 0; i < strings.size() / 2; i++) {

            // Move iterators and swap elements
            String firstStr = firstIterator.next();
            String lastStr = lastIterator.previous();

            firstIterator.set(lastStr);
            lastIterator.set(firstStr);
        }
    }
}