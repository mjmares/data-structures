import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
 */
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
     */
    public static String reverse(String sentence)
    {
        Scanner scanner = new Scanner(sentence);
        Stack<String> stack = new Stack<>();

        // Split the sentence into words and push them onto the stack
        String strObj = "";
        while (scanner.hasNext()) {
            String tempStr = scanner.next();
            strObj += tempStr + " ";
            if(tempStr.contains(".")) {
                stack.push(strObj);
                strObj = "";
            }
            // stack.push(scanner.next());
        }
        scanner.close();

        while (!stack.isEmpty()) {
            String currentString = stack.pop();

            // System.out.println(currentString);

        }

        return "";
    }
}
