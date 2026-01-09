package Vectordemo;
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        // 1. Create a Vector
        Vector<String> vector = new Vector<>();

        // 2. Add elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        vector.add("Mango");
        vector.add("Orange");

        // Insert at specific index
        vector.add(2, "Grapes"); // adds at index 2

        System.out.println("Initial Vector: " + vector);

        // 3. Access elements
        System.out.println("Element at index 2: " + vector.get(2));
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());

        // 4. Modify element
        vector.set(1, "Blueberry"); // replaces Banana with Blueberry
        System.out.println("After modification: " + vector);

        // 5. Check size and capacity
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        // 6. Check existence
        System.out.println("Contains Mango? " + vector.contains("Mango"));
        System.out.println("Index of Mango: " + vector.indexOf("Mango"));

        // 7. Remove elements
        vector.remove("Cherry");      // remove by value
        vector.remove(3);             // remove by index
        System.out.println("After removals: " + vector);

        // 8. Iteration using different methods
        System.out.println("\nIterating using for loop:");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        System.out.println("\nIterating using for-each loop:");
        for (String fruit : vector) {
            System.out.println(fruit);
        }

        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nIterating using Enumeration (Legacy way):");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // 9. Sublist
        List<String> subList = vector.subList(0, 2);
        System.out.println("SubList (0 to 2): " + subList);

        // 10. Conversion
        Object[] array = vector.toArray();
        System.out.println("Converted to Array: " + Arrays.toString(array));

        // 11. Clear all elements
        vector.clear();
        System.out.println("After clear: " + vector);
        System.out.println("Is empty? " + vector.isEmpty());
    }
}
