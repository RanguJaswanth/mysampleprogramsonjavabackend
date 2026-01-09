package MapsDemo;
import java.util.*;

public class WordCountExample {
    public static void main(String[] args) {
        String text = "java is fun and java is powerful";
        String[] words = text.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + wordCount);
    }
}