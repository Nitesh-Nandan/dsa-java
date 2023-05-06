package java11;

//Course Schedule There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
//        You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//        Return the ordering of courses you should take to finish all courses. If there are many valid answers,
//        return any of them. If it is impossible to finish all courses,
//        return an empty array.
//        Example 1: Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: [0,1] Explanation:
//        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
//
//
//        Example 2: Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] Output: [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
//        Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
//        Another correct ordering is [0,2,1,3]. Example 3: Input: numCourses = 1, prerequisites = [] Output: [0]
// indegree -> 2, 0
// outdegree -> 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Test2 {

    public static void getCourseOrder(int[][] courses, int totalCourses) {
        Map<Integer, List<Integer>> dependencyVsDependentGraph = new HashMap<>();
        Map<Integer, Integer> dependenyCount = new HashMap<>();

//        [ai, bi] indicates that you must take course bi first if you want to take course ai.


        for(int[] course: courses) {
            int dependent = course[0];
            int dependency = course[1];
            dependenyCount.put(dependent, dependenyCount.getOrDefault(dependent, 0) + 1);
            dependencyVsDependentGraph.putIfAbsent(dependency, new ArrayList<>());
            dependencyVsDependentGraph.get(dependency).add(dependent);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<totalCourses; i++) {
            if(!dependenyCount.containsKey(i)) {
                queue.offer(i);
            }
        }

        if(queue.isEmpty()) {
            System.out.println("Not Possible");
            return;
        }

        List<Integer> courseOrder = new ArrayList<>();

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            courseOrder.add(curr);
            List<Integer> dependents = dependencyVsDependentGraph.getOrDefault(curr, new ArrayList<>());

            for(int dep: dependents) {
                dependenyCount.put(dep, dependenyCount.get(dep) -1);
                if(dependenyCount.get(dep) == 0) {
                    queue.offer(dep);
                }
            }
        }

        if(courseOrder.size() == totalCourses) {
            System.out.println(courseOrder);
        } else {
            System.out.println("Not Possible");
        }
    }

    public static void main(String[] args) {
        int[][] courses = new int[][] {{0,1}};
        getCourseOrder(courses, 2);

        int[][] courses2 = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        getCourseOrder(courses2, 4);
    }




}



















