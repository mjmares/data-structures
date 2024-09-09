import java.util.*;


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

        Set<Integer> primes = new HashSet<Integer>();
        
        for(int i = 2; i <= n; i++) {
            boolean isPrime = true;
            
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                primes.add(i);
            }
        }

        System.out.println(primes);
    }
}
