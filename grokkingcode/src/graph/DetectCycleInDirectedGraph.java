package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Kahn's Algorithm
class DetectCycleByBfs {
    public static boolean isCyclic(Map<Character, List<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();

        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            List<Character> edges = entry.getValue();
            if (!indegree.containsKey(entry.getKey())) {
                indegree.put(entry.getKey(), 0);
            }
            for (Character ch : edges) {
                indegree.put(ch, indegree.getOrDefault(ch, 0) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> incomingEdge : indegree.entrySet()) {
            if (incomingEdge.getValue() == 0) {
                queue.offer(incomingEdge.getKey());
            }
        }

        List<Character> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            topo.add(ch);
            List<Character> edges = graph.getOrDefault(ch, new ArrayList<>());
            for (char ed : edges) {
                indegree.put(ed, indegree.get(ed) - 1);
                if (indegree.get(ed) == 0) {
                    queue.offer(ed);
                }
            }
        }

        System.out.println(topo);

        return false;
    }
}


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
        test1();
        test2();
    }

    static void test1() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B'));
        graph.put('B', Arrays.asList('A'));

        System.out.println(isCyclic(graph));
    }

    static void test2() {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', new ArrayList<>());
        graph.put('B', List.of('A'));
        graph.put('C', List.of('A'));
        graph.put('D', List.of('B'));
        graph.put('E', Arrays.asList('B', 'C', 'D'));
        graph.put('F', Arrays.asList('D', 'C'));

        System.out.println(DetectCycleByBfs.isCyclic(graph));

    }
}
