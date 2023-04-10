package challenge;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents {
    private static final Map<Integer, Integer> parents = new HashMap<>();
    private static final Map<Integer, Integer> ranks = new HashMap<>();

    private static void init(int n) {
        for (int i = 0; i <= n; i++) {
            parents.put(i, i);
            ranks.put(i, 0);
        }
    }

    private static int getParent(int node) {
        if (parents.get(node) != node) {
            parents.put(node, getParent(parents.get(node)));
        }
        return parents.get(node);
    }

    private static void union(int node1, int node2) {
        int parent1 = getParent(node1);
        int parent2 = getParent(node2);

        if (parent1 == parent2) return;

        if (ranks.get(parent1) > ranks.get(parent2)) {
            parents.put(parent2, parent1);
        } else if (ranks.get(parent1) < ranks.get(parent2)) {
            parents.put(parent1, parent2);
        } else {
            parents.put(parent2, parent1);
            ranks.put(parent1, ranks.get(parent1) + 1);
        }
    }

    public static int componentsCountInGraph(int n, int[][] edges) {
        init(n);
        for (int[] nodes : edges) {
            union(nodes[0], nodes[1]);
        }
        Set<Integer> set = new HashSet<>(parents.values());
        return set.size() - 1;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        TestCaseUtil.test(2, componentsCountInGraph(5, edges), 1);
    }

    private static void test2() {
        int[][] edges = new int[][]{{0, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}, {8, 9}};
        TestCaseUtil.test(4, componentsCountInGraph(10, edges), 2);
    }
}
