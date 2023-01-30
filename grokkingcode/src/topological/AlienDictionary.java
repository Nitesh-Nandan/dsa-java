package topological;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    public static String alienOrder(List<String> words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.size() - 1; i++) {
            String currWord = words.get(i);
            String nextWord = words.get(i + 1);

            int len = Math.min(currWord.length(), nextWord.length());

            for (int k = 0; k < len; k++) {
                char ch1 = currWord.charAt(k);
                char ch2 = nextWord.charAt(k);

                if (ch1 != ch2) {
                    Set<Character> nbrs = graph.getOrDefault(ch1, new HashSet<>());
                    nbrs.add(ch2);
                    graph.put(ch1, nbrs);
                    indegree.put(ch2, indegree.get(ch2) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        if (queue.size() == indegree.size()) return "";

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            Set<Character> nbrs = graph.getOrDefault(ch, new HashSet<>());
            for (char ed : nbrs) {
                indegree.put(ed, indegree.get(ed) - 1);
                if (indegree.get(ed) == 0) {
                    queue.offer(ed);
                }
            }
        }
        return sb.toString().length() == indegree.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        test3();
    }

    static void test1() {
        List<String> words = Arrays.asList("wrt", "wrf", "er", "ett", "rftt");
        System.out.println(alienOrder(words));
    }

    static void test2() {
        List<String> words = Arrays.asList("xro", "xma", "per", "prt", "oxh", "olv");
        System.out.println(alienOrder(words));
    }

    static void test3() {
        List<String> words = Arrays.asList("m", "mx", "mxe", "mxer", "mxerl", "mxerlo", "mxerlos", "mxerlost", "mxerlostr", "mxerlostrpq", "mxerlostrp");
        System.out.println(alienOrder(words));
    }
}
