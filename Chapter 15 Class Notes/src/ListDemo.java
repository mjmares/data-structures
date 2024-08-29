import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
 */
public class ListDemo {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");
        System.out.println(staff);

        ListIterator<String> iterator = staff.listIterator();
        iterator.next(); // returns tony

        String avenger = iterator.next(); // Natasha
        System.out.println(avenger);

        iterator.add("Steve");
        iterator.add("Clint");
        System.out.println(staff);

        iterator.next();
        iterator.remove();
        System.out.println(staff);

        iterator.previous();
        iterator.set("T'Challa");
        System.out.println(staff);

        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Natasha")) {
                iterator.remove();
            }
        }
        System.out.println(staff);

        for (String n : staff) {
            System.out.print(n + " ");
        }
        System.out.println();

        iterator = staff.listIterator();
        while(iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")) {
                // Remove
            }
        }

        for(String n : staff) {
            if (n.equals("Tony")) {
                staff.add("Tony");
            }
        }

    }
}
