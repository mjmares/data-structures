import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        driveway = new Stack<Integer>();
        street = new Stack<Integer>();
    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method
        driveway.push(licensePlate);

    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // Complete this method
        // Flag to check if the license plate is found
        boolean found = false;
        // Move cars from driveway to street until we find the car
        while (!driveway.isEmpty()) {
            int topCar = driveway.peek();
            if (topCar == licensePlate) {
                // Found the car, remove it
                driveway.pop();
                found = true;
                break;
            } else {
                // Move car to street
                street.push(driveway.pop());
            }
        }

        if (!found) {
            System.out.println("License plate " + licensePlate + " not found in the driveway.");
        }

        // Move cars back from street to driveway
        while (!street.isEmpty()) {
            driveway.push(street.pop());
        }

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        if (driveway.isEmpty()) {
          System.out.println("Empty");
      } else {
          for (int i = 0; i < driveway.size(); i++) {
              System.out.println(driveway.get(i));
          }
      }
        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        // Print the cars in the driveway here
        if (street.isEmpty()) {
          System.out.println("Empty");
      } else {
          for (int i = 0; i < street.size(); i++) {
              System.out.println(street.get(i));
          }
      }
    }
}
