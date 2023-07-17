package topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CompilationOrder {
    public static List<Character> findCompilationOrder(List<ArrayList<Character>> dependencies) {
        Map<Character, Boolean> visited = new TreeMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        Stack<Character> stacks = new Stack<>();

        for (List<Character> edge : dependencies) {
            graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>());
            graph.get(edge.get(0)).add(edge.get(1));
            visited.put(edge.get(0), false);
            visited.put(edge.get(1), false);
        }

        if (isCyclic(graph)) {
            return Collections.emptyList();
        }

        List<Character> ans = new ArrayList<>();

        for (Map.Entry<Character, Boolean> node : visited.entrySet()) {
            if (Boolean.FALSE.equals(node.getValue())) {
                doTopologicalSort(graph, node.getKey(), visited, stacks);
            }
        }

        while (!stacks.isEmpty()) {
            ans.add(stacks.pop());
        }
        Collections.reverse(ans);

        return ans;
    }

    static void doTopologicalSort(Map<Character, List<Character>> graph, char src,
                                  Map<Character, Boolean> visited, Stack<Character> stacks) {

        visited.put(src, true);
        List<Character> edges = graph.get(src);
        if (edges != null) {
            for (Character node : edges) {
                if (Boolean.FALSE.equals(visited.get(node))) {
                    doTopologicalSort(graph, node, visited, stacks);
                }
            }
        }

        stacks.add(src);
    }

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
//        test1();
//        test2();
//        test3();
    }

//    static void test1() {
//        ArrayList<ArrayList<Character>> dependencies = new ArrayList<>();
//        dependencies.add(new ArrayList<>(List.of('B', 'A')));
//        dependencies.add(new ArrayList<>(List.of('C', 'A')));
//        dependencies.add(new ArrayList<>(List.of('D', 'B')));
//        dependencies.add(new ArrayList<>(List.of('E', 'B')));
//        dependencies.add(new ArrayList<>(List.of('E', 'D')));
//        dependencies.add(new ArrayList<>(List.of('E', 'C')));
//        dependencies.add(new ArrayList<>(List.of('F', 'D')));
//        dependencies.add(new ArrayList<>(List.of('E', 'E')));
//        dependencies.add(new ArrayList<>(List.of('F', 'C')));
//
//        System.out.println(findCompilationOrder(dependencies));
//
//    }
//
//    static void test2() {
//        ArrayList<ArrayList<Character>> dependencies = new ArrayList<>();
//        dependencies.add(new ArrayList<>(List.of('B', 'A')));
//        dependencies.add(new ArrayList<>(List.of('C', 'A')));
//        dependencies.add(new ArrayList<>(List.of('D', 'C')));
//        dependencies.add(new ArrayList<>(List.of('E', 'D')));
//        dependencies.add(new ArrayList<>(List.of('E', 'B')));
//
//        System.out.println(findCompilationOrder(dependencies));
//
//    }
//
//    static void test3() {
//        ArrayList<ArrayList<Character>> dependencies = new ArrayList<>();
//        dependencies.add(new ArrayList<>(List.of('B', 'A')));
//        dependencies.add(new ArrayList<>(List.of('A', 'B')));
//
//        System.out.println(findCompilationOrder(dependencies));
//
//    }
}


