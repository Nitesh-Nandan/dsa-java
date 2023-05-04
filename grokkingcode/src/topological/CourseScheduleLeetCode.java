package topological;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleLeetCode {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencyVsDependentGraph = new HashMap<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();

        for (int[] course : prerequisites) {
            int dependent = course[0];
            int dependency = course[1];
            dependencyVsDependentGraph.putIfAbsent(dependency, new ArrayList<>());
            dependencyVsDependentGraph.get(dependency).add(dependent);
            inDegreeMap.put(dependent, inDegreeMap.getOrDefault(dependent, 0) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegreeMap.getOrDefault(i, 0) == 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) return false;

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            List<Integer> dependents = dependencyVsDependentGraph.getOrDefault(course, new ArrayList<>());

            for (int dep : dependents) {
                inDegreeMap.put(dep, inDegreeMap.get(dep) - 1);
                if (inDegreeMap.get(dep) == 0) {
                    queue.offer(dep);
                }
            }
        }

        return order.size() == numCourses;
    }
}
