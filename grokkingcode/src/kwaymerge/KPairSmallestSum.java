package kwaymerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class HeapNode {
    int val;
    int firstIndex;
    int secondIndex;

    public HeapNode(int val, int firstIndex, int secondIndex) {
        this.val = val;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public String toString() {
        return "[ val= " + val + " row= " + firstIndex + " col= " + secondIndex + " ]";
    }
}

public class KPairSmallestSum {

    private static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<HeapData> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < list2.length; i++) {
            minHeap.offer(new HeapData(list1[0] + list2[i], 0, i));
        }

        while (target > 0 && !minHeap.isEmpty()) {
            HeapData currNode = minHeap.poll();
            ans.add(Arrays.asList(list1[currNode.row], list2[currNode.col]));

            if (currNode.row + 1 < list1.length) {
                minHeap.offer(new HeapData(list1[currNode.row + 1] + list2[currNode.col], currNode.row + 1, currNode.col));
            }
            target--;
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[] list1 = new int[]{1, 11, 20, 35, 300};
        int[] list2 = new int[]{1, 2, 300};

        // [[1, 1], [1, 2], [11, 1], [11, 2], [20, 1]]
        System.out.println(kSmallestPairs(list1, list2, 5));
    }

    private static void test2() {
        int[] list1 = new int[]{1, 1, 2};
        int[] list2 = new int[]{1, 2, 3};

        // [[1, 1], [1, 1], [1, 2], [2, 1]]
        System.out.println(kSmallestPairs(list1, list2, 4));
    }

    private static void test3() {
        int[] list1 = new int[]{1, 5, 9, 14, 24, 27, 35};
        int[] list2 = new int[]{1, 6, 8, 17, 30};

        // [[1, 1], [5, 1], [1, 6], [1, 8], [9, 1], [5, 6], [5, 8], [9, 6], [14, 1], [9, 8], [1, 17], [14, 6], [5, 17], [14, 8], [24, 1]]
        System.out.println(kSmallestPairs(list1, list2, 15));
    }
}
