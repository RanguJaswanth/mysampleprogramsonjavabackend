package MapsDemo;
import java.util.*;

public class MapBehaviorDemo {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> hashtable = new Hashtable<>();

        // Adding same entries
        int[] keys = {5, 3, 9, 1, 7};
        for (int k : keys) {
            hashMap.put(k, "Value" + k);
            linkedHashMap.put(k, "Value" + k);
            treeMap.put(k, "Value" + k);
            hashtable.put(k, "Value" + k);
        }

        System.out.println("HashMap       : " + hashMap);
        System.out.println("LinkedHashMap : " + linkedHashMap);
        System.out.println("TreeMap       : " + treeMap);
        System.out.println("Hashtable     : " + hashtable);
    }
}
