package kwaymerge;

import util.TestCaseUtil;

import java.util.PriorityQueue;

class HeapData {
    int val;
    int row;
    int col;

    public HeapData(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "[ val= " + val + " row= " + row + " col= " + col + " ]";
    }
}

public class KSmallestElementsInSortedMatrix {
    public static int kthSmallestElement(int[][] matrix, int k) {
        int ans = -1;
        PriorityQueue<HeapData> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new HeapData(matrix[i][0], i, 0));
        }
        while (k > 0 && !minHeap.isEmpty()) {
            HeapData curr = minHeap.poll();
            ans = curr.val;

            if (curr.col + 1 < matrix[curr.row].length) {
                minHeap.offer(new HeapData(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
            k--;
        }


        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        int[][] matrix = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};

        TestCaseUtil.run(5, kthSmallestElement(matrix, 3), 1);
    }

    static void test2() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        TestCaseUtil.run(4, kthSmallestElement(matrix, 4), 2);
    }

    static void test3() {
        int[][] matrix = {{}, {}};

        TestCaseUtil.run(-1, kthSmallestElement(matrix, 1), 3);
    }

    static void test4() {
        int[][] matrix = {{2, 2, 6, 6, 8, 9}, {1, 4, 7, 10, 10, 22}, {5, 7, 9, 11, 13, 15}, {44, 55, 66, 77, 88, 99}};

        TestCaseUtil.run(7, kthSmallestElement(matrix, 8), 4);
    }
}
