package graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualStates {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        EventualStates es = new EventualStates();
        System.out.println(es.eventualSafeNodes(graph));

        int[][] graph2 = new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(es.eventualSafeNodes(graph2));

        int[][] graph3 = new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}};
        System.out.println(es.eventualSafeNodes(graph3));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int node = graph.length;
        int[] reached = new int[node];

        Arrays.fill(reached, 0);

        for (int i = 0; i < node; i++) {
            if (isTerminalReached(graph, i, new boolean[node], reached)) {
                reached[i] = 1;
            } else {
                reached[i] = -1;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < node; i++) {
            if (reached[i] == 1) ans.add(i);
        }
        return ans;
    }

    private boolean isTerminalReached(int[][] graph, int node, boolean[] visited, int[] reached) {
        if (visited[node]) {
            return false;
        }
        if (reached[node] != 0) {
            return reached[node] == 1;
        }
        int[] neighbours = graph[node];
        if (neighbours.length == 0) return true;

        visited[node] = true;
        boolean ans = true;

        for (int ed : neighbours) {
            ans &= isTerminalReached(graph, ed, visited, reached);
        }
        reached[node] = ans ? 1 : -1;
        visited[node] = false;

        return ans;
    }
}
