package dsa_stack_queue.bai_tap.countwordsbytreemap;

import java.util.Map;
import java.util.TreeMap;

public class CounterWord {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        String words = "GeeK for geeks";
        words = words.toLowerCase();

        for (var ch : words.toCharArray()) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
