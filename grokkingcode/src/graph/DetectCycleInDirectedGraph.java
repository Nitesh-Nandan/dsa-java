package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DetectCycleInDirectedGraph {

    public static boolean isCyclic(Map<Character, List<Character>> graph) {
        Map<Character, Boolean> visited = new HashMap<>();

        for (Map.Entry<Character, List<Character>> edge : graph.entrySet()) {
            char src = edge.getKey();
            if (visited.get(src) == null || Boolean.FALSE.equals(visited.get(src))) {
                Map<Character, Boolean> dfsVisited = new HashMap<>();
                if (detectCycle(graph, src, visited, dfsVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycle(Map<Character, List<Character>> graph, char src,
                                       Map<Character, Boolean> visited, Map<Character, Boolean> dfsVisited) {

        visited.put(src, true);
        dfsVisited.put(src, true);

        List<Character> edges = graph.getOrDefault(src, new ArrayList<>());

        for (Character node : edges) {
            if (Boolean.TRUE.equals(dfsVisited.get(node))) {
                return true;
            }
            if (visited.get(node) == null || Boolean.FALSE.equals(visited.get(node))) {
                return detectCycle(graph, node, visited, dfsVisited);
            }
        }

        dfsVisited.put(src, false);
        return false;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B'));
        graph.put('B', Arrays.asList('A'));

        System.out.println(isCyclic(graph));
    }

}
