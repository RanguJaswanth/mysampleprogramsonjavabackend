package Arraplist_package;
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 1. Create an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Mango");
        list.add("Orange");

        // Insert at specific index
        list.add(2, "Grapes"); // adds at index 2

        System.out.println("Initial ArrayList: " + list);

        // 3. Access elements
        System.out.println("Element at index 2: " + list.get(2));

        // 4. Modify element
        list.set(1, "Blueberry"); // replaces Banana with Blueberry
        System.out.println("After modification: " + list);

        // 5. Check size
        System.out.println("Size: " + list.size());

        // 6. Check existence
        System.out.println("Contains Mango? " + list.contains("Mango"));
        System.out.println("Index of Mango: " + list.indexOf("Mango"));

        // 7. Remove elements
        list.remove("Cherry");      // remove by value
        list.remove(3);             // remove by index
        System.out.println("After removals: " + list);

        // 8. Iteration using different methods
        System.out.println("\nIterating using for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nIterating using for-each loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nIterating using ListIterator (bidirectional):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Forward: " + listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println("Backward: " + listIterator.previous());
        }

        // 9. Sublist
        List<String> subList = list.subList(0, 2);
        System.out.println("SubList (0 to 2): " + subList);

        // 10. Conversion
        Object[] array = list.toArray();
        System.out.println("Converted to Array: " + Arrays.toString(array));

        // 11. Sorting
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // 12. Reverse order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Reversed Sorted List: " + list);

        // 13. Clear all elements
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty? " + list.isEmpty());
    }
}
