package disjoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RedundantConnectionSolution {
    private final Map<Integer, Integer> parent = new HashMap<>();
    private final Map<Integer, Integer> rank = new HashMap<>();

    public Integer find(int node) {
        int iParent = parent.getOrDefault(node, node);
        if (iParent != node) {
            parent.put(node, find(iParent));
        }
        return parent.getOrDefault(node, node);
    }

    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 == parent2) {
            System.out.println("Redundant Edge: [" + node1 + ", " + node2 + "]");
        } else {
            if (rank.getOrDefault(parent1, 0) > rank.getOrDefault(parent2, 0)) {
                parent.put(parent2, parent1);
            } else if (rank.getOrDefault(parent1, 0) < rank.getOrDefault(parent2, 0)) {
                parent.put(parent1, parent2);
            } else {
                parent.put(parent2, parent1);
                rank.put(parent1, rank.getOrDefault(parent1, 0) + 1);
            }
        }
    }
}


public class RedundantConnection {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        RedundantConnectionSolution sol = new RedundantConnectionSolution();
        List<Edge> edgeList = Arrays.asList(new Edge(1, 2),
                new Edge(2, 3), new Edge(3, 4), new Edge(1, 4), new Edge(1, 5));

        for (Edge edge : edgeList) {
            sol.union(edge.src, edge.dest);
        }
    }

    static void test2() {
        RedundantConnectionSolution sol = new RedundantConnectionSolution();
        List<Edge> edgeList = Arrays.asList(new Edge(1, 2),
                new Edge(2, 3), new Edge(2, 4), new Edge(2, 5), new Edge(3, 5));

        for (Edge edge : edgeList) {
            sol.union(edge.src, edge.dest);
        }
    }

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}
