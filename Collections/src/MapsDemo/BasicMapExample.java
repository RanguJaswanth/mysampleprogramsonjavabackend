package MapsDemo;
import java.util.*;

public class BasicMapExample {
    public static void main(String[] args) {
        // 1. Create a HashMap
        Map<Integer, String> map = new HashMap<>();

        // 2. Add elements
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // 3. Get value
        System.out.println("Value for key 2: " + map.get(2));

        // 4. Check if key/value exists
        System.out.println("Contains key 3? " + map.containsKey(3));
        System.out.println("Contains value 'Apple'? " + map.containsValue("Apple"));

        // 5. Remove a key
        map.remove(1);

        // 6. Iterate over keys
        System.out.println("Keys:");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // 7. Iterate over values
        System.out.println("Values:");
        for (String value : map.values()) {
            System.out.println(value);
        }

        // 8. Iterate over key-value pairs
        System.out.println("Entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
