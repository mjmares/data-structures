import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {

        Map<String, Color> favColors = new HashMap<>();
        favColors.put("Henry", Color.blue);
        favColors.put("Jack", Color.red);
        favColors.put("Mitch", Color.green);
        favColors.put("Miller", Color.green);

        favColors.put("Jack", Color.pink);

        Set<Strings> keys = favColors.keySet();
        for (String key: keys) {
            System.out.println(key + " (" + key.hashCode() + "): " + favColors.get(key));
        }

    }
}
