import java.util.Scanner;
import java.util.ArrayList;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        ArrayList<Integer> nums = new ArrayList<Integer>(); // Create an ArrayList object
        nums.add(2);
        for(int i = 3; i <= n; i++) {
            if(i % 2 == 0) {
                continue;
            }
            if(i % 3 == 0) {
                continue;
            }
            nums.add(i);
        }

        System.out.println(nums);


    }
}
