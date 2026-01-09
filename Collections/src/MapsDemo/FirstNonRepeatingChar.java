package MapsDemo;
import java.util.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "swiss";
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating character: " + entry.getKey());
                break;
            }
        }
    }
}
