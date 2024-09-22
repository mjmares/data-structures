import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "./TagSample2.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            Stack<String> stack = new Stack<>();

            while (in.hasNext()) {
                String tag = in.next();

                if (tag.startsWith("</")) {
                    // This is a closing tag
                    if (stack.isEmpty()) {
                        System.out.println("Error: closing tag " + tag + " without matching opening tag.");
                        return;
                    }
                    String openTag = stack.pop();
                    String openTagName = openTag.substring(1, openTag.length() - 1);
                    String closeTagName = tag.substring(2, tag.length() - 1);

                    if (!openTagName.equals(closeTagName)) {
                        System.out.println("Error: tag " + openTag + " does not match closing tag " + tag);
                        return;
                    }
                } else if (tag.startsWith("<") && tag.endsWith(">")) {
                    // This is an opening tag
                    stack.push(tag);
                } else {
                    // Invalid tag format
                    System.out.println("Error: invalid tag format " + tag);
                    return;
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("Error: some tags were not closed: " + stack);
            } else {
                System.out.println("The tags are properly nested.");
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
