/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Student1");
        students.addFirst("Student2");
        students.addFirst("Student3");
        students.addFirst("Student4");

        System.out.println(students.toString());

    }
}
