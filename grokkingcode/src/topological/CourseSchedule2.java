package topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule2 {

    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            indegree.put(child, indegree.getOrDefault(child, 0) + 1);
            List<Integer> nbr = graph.getOrDefault(parent, new ArrayList<>());
            nbr.add(child);
            graph.put(parent, nbr);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree.getOrDefault(i, 0) == 0) {
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int sub = queue.poll();
            ans.add(sub);

            List<Integer> nbr = graph.getOrDefault(sub, new ArrayList<>());
            for (int dep : nbr) {
                indegree.put(dep, indegree.get(dep) - 1);
                if (indegree.get(dep) == 0) {
                    queue.offer(dep);
                }
            }
        }
        return ans.size() == n ? ans : Collections.emptyList();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[][] courses = {{1, 0}, {2, 0}, {2, 1}, {1, 2}};
        System.out.println(findOrder(3, courses)); // []
    }

    static void test2() {
        int[][] courses = {{1, 0}};
        System.out.println(findOrder(2, courses)); // [0, 1]
    }

    static void test3() {
        int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(findOrder(4, courses)); // [0, 1, 2, 3]
    }

    static void test4() {
        int[][] courses = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {7, 8}, {4, 9}};
        System.out.println(findOrder(10, courses)); // [2, 6, 8, 9, 0, 5, 7, 1, 3, 4]
    }
}
