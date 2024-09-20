import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<String> jobs = new LinkedList<>();
        
        // Add print jobs
        jobs.add("Joe: Quarter 2 Expense Report");
        jobs.add("Cathy: top Secret Docuent");

        System.out.println("Printing: " + jobs.remove());

        // Add some more jobs
        jobs.add("Cathy: Really Top Secret Docs");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I get fired for this");

        System.out.println("Printing" + jobs.remove());

        jobs.add("Boss: Cathy Term Letter");

        // Print rest of jobs in queue
        while(jobs.size() > 0) {
            System.out.println("Printing: " + jobs.remove());
        }
    }
}
