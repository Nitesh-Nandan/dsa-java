package java11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ModuloTest {

    public static int solution(int[] V, int[] A, int[] B) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = A.length;
        for(int i=0; i<len; i++) {
            int e1 = A[i];
            int e2 = B[i];
            graph.putIfAbsent(e1, new ArrayList<>());
            graph.get(e1).add(e2);
            indegree.putIfAbsent(e1, 0);
            indegree.put(e2, indegree.getOrDefault(e2, 0) + 1);
        }
        Queue<Integer> pq = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) {
                pq.offer(entry.getKey());
            }
        }

        if(pq.isEmpty()) return 0;

        int ans = 0;
        List<Integer> ans2 = new ArrayList<>();

        while(!pq.isEmpty()) {
            int edge = pq.poll();
            ans2.add(V[edge]);
            ans += V[edge];
            List<Integer> neigh = graph.getOrDefault(edge, new ArrayList<>());
            for(int ed: neigh) {
                indegree.put(ed, indegree.get(ed) - 1);
                if(indegree.get(ed) == 0){
                    pq.offer(ed);
                }
            }
        }

        Collections.sort(ans2);

        return ans2.get(0) + ans2.get(1);
    }


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] V = new int[] {-3, 5, 7, 2, 3};
        int[] A = new int[] {3,1};
        int[] B = new int[] {2, 4};

        System.out.println(solution(V, A, B));

    }
}
