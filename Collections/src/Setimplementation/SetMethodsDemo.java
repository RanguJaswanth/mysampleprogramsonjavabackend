package Setimplementation;
import java.util.*;
import java.util.stream.Collectors;

public class SetMethodsDemo {
    public static void main(String[] args) {
        // 1. Create a HashSet
        Set<String> set = new HashSet<>();
        System.out.println("Initial Set: " + set);

        // 2. Add elements
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // duplicate ignored
        set.add(null);   // HashSet allows one null
        System.out.println("After add(): " + set);

        // 3. Check contains
        System.out.println("Contains Python? " + set.contains("Python"));

        // 4. Size and isEmpty
        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());

        // 5. Convert to array
        Object[] array = set.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        // 6. Add all elements from another collection
        Set<String> anotherSet = new HashSet<>(Arrays.asList("Go", "Rust", "Python"));
        set.addAll(anotherSet);
        System.out.println("After addAll(): " + set);

        // 7. Remove element
        set.remove("C++");
        System.out.println("After remove(): " + set);

        // 8. Remove all elements present in another collection
        Set<String> toRemove = new HashSet<>(Arrays.asList("Java", "Go"));
        set.removeAll(toRemove);
        System.out.println("After removeAll(): " + set);

        // 9. Retain only elements present in another collection (intersection)
        Set<String> intersectionSet = new HashSet<>(Arrays.asList("Python", "Rust", "Scala"));
        set.retainAll(intersectionSet);
        System.out.println("After retainAll(): " + set);

        // 10. Iteration using iterator
        System.out.print("Iteration using iterator: ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 11. Iteration using forEach
        System.out.print("Iteration using forEach: ");
        set.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 12. Using stream to filter elements
        Set<String> filteredSet = set.stream()
                                     .filter(e -> e.startsWith("P"))
                                     .collect(Collectors.toSet());
        System.out.println("Filtered (starts with 'P'): " + filteredSet);

        // 13. Remove elements using removeIf
        set.removeIf(e -> e.startsWith("R"));
        System.out.println("After removeIf (starts with 'R'): " + set);

        // 14. Clear the set
        set.clear();
        System.out.println("After clear(): " + set);
        System.out.println("Is empty now? " + set.isEmpty());
    }
}
