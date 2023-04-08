package interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DisjointSet {
    private final Map<Character, Character> parent = new HashMap<>();
    private final Map<Character, Integer> rank = new HashMap<>();

    private void init(char ch1, char ch2) {
        if (!parent.containsKey(ch1)) {
            parent.put(ch1, ch1);
            rank.put(ch1, 0);
        }
        if (!parent.containsKey(ch2)) {
            parent.put(ch2, ch2);
            rank.put(ch2, 0);
        }
    }

    public boolean isKeyPresent(char ch) {
        return parent.containsKey(ch);
    }

    public char getParent(char ch) {
        if (parent.get(ch) != ch) {
            parent.put(ch, getParent(parent.get(ch)));
        }
        return parent.get(ch);
    }

    public void union(char ch1, char ch2) {
        init(ch1, ch2);
        char parent1 = getParent(ch1);
        char parent2 = getParent(ch2);
        if (parent1 == parent2) {
            // this is the cycle
            return;
        }

        if (rank.get(parent1) > rank.get(parent2)) {
            parent.put(parent2, parent1);
        } else if (rank.get(parent1) < rank.get(parent2)) {
            parent.put(parent1, parent2);
        } else {
            parent.put(parent2, parent1);
            rank.put(parent1, rank.getOrDefault(parent1, 0) + 1);
        }
    }
}

public class LinkedListIntersection {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        DisjointSet ops2 = new DisjointSet();
        ops2.union('A', 'B');
        ops2.union('R', 'S');
        ops2.union('B', 'C');
        ops2.union('X', 'C');
        ops2.union('Q', 'R');
        ops2.union('Y', 'X');
        ops2.union('W', 'Z');

        List<List<Character>> queries = Arrays.asList(
                Arrays.asList('A', 'Q', 'W'),
                Arrays.asList('A', 'C', 'R'),
                Arrays.asList('Y', 'Z', 'A', 'R'),
                Arrays.asList('A', 'W')
        );
String[] n = new String[10];
int x = n.length;
        for(List<Character> query: queries) {
            Set<Character> parentsSet = new HashSet<>();
            for(char ed : query) {
                parentsSet.add(ops2.getParent(ed));
            }
            if(parentsSet.size() != query.size()) {
                System.out.println("Has Cycle: true");
            } else {
                System.out.println("Doesn't has cycle: false");
            }
        }
    }
}





