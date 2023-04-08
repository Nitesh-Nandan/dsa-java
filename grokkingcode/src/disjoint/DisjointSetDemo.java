package disjoint;

import java.util.HashMap;
import java.util.Map;

class Disjoint {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Integer> rank = new HashMap<>();

    private void init(String node1, String node2) {
        if (parent.containsKey(node1)) {
            parent.put(node1, node1);
            rank.put(node1, 0);
        }
        if (parent.containsKey(node2)) {
            parent.put(node2, node2);
            rank.put(node2, 0);
        }
    }

    private String findParent(String node) {
        if (!parent.get(node).equals(node)) {
            parent.put(node, findParent(node));
        }
        return parent.get(node);
    }

    private void union(String node1, String node2) {
        init(node1, node2);
        String parent1 = findParent(node1);
        String parent2 = findParent(node2);
        if (!parent1.equals(parent2)) {
            if (rank.get(parent1) > rank.get(parent2)) {
                parent.put(parent2, parent1);
            } else if (rank.get(parent2) > rank.get(parent1)) {
                parent.put(parent1, parent2);
            } else {
                parent.put(parent2, parent1);
                rank.put(parent1, rank.getOrDefault(parent1, 0) + 1);
            }
        }
    }
}

public class DisjointSetDemo {

}
