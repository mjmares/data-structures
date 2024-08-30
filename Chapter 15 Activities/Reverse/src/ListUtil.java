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
        ListIterator<String> lastIterator = strings.listIterator();

        String currentStr = firstIterator.next(); 
        String lastStr = "";

        // Move last to last
        while(lastIterator.hasNext()) {
            lastStr = lastIterator.next();
        }

        for(int i = 0; i <= (strings.size() - 1) / 2; i++) {
            
            int switchIndex = Math.abs(i - strings.size()) - 1;
            
            System.out.println(currentStr + " " + lastStr);

            firstIterator.set(lastStr);
            lastIterator.set(currentStr);

            currentStr = firstIterator.next(); 
            lastStr = lastIterator.previous();
        }

    }
}