package disjoint;

import util.TestCaseUtil;

import java.util.ArrayDeque;
import java.util.Queue;

// This problem can be solved using union find also.
public class LastDayStillCross {

    public static int lastDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = cells.length;
        int days = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(row, col, cells, mid)) {
                days = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return days;
    }

    private static boolean canWalk(int row, int col, int[][] cells, int dayAt) {
        int[][] grid = new int[row][col];
        int[][] dx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < dayAt; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == row - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nrow = curr[0] + dx[i][0];
                int ncol = curr[1] + dx[i][1];

                if (nrow < 0 || nrow >= row || ncol < 0 || ncol >= col || grid[nrow][ncol] == 1) {
                    continue;
                }
                grid[nrow][ncol] = 1;
                queue.offer(new int[]{nrow, ncol});
            }
        }

        return false;
    }

    public static void main(String[] args) {
        test1();
    }


    private static void test1() {
        int[][] cells = new int[][]{{3, 2}, {1, 3}, {2, 2}, {3, 1}, {1, 1}, {1, 2}, {2, 3}, {3, 3}, {2, 1}};
        TestCaseUtil.test(3, lastDayToCross(3, 3, cells), 1);

    }
}
