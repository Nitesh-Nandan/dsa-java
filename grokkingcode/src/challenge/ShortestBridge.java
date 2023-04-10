package challenge;

import util.TestCaseUtil;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static int shortestBridge(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        boolean found = false;
        for (int i = 0; i < row; i++) {
            if (found) break;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    doDfs(grid, i, j, visited, queue);
                    found = true;
                }
            }
        }
        int[][] mv = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dis = 0;
        while (!queue.isEmpty()) {
            int itr = queue.size();
            while (itr-- > 0) {
                int[] cord = queue.poll();
                for (int i = 0; i < mv.length; i++) {
                    int nr = cord[0] + mv[i][0];
                    int nc = cord[1] + mv[i][1];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc]) {
                        if (grid[nr][nc] == 1) {
                            return dis;
                        }
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            dis++;
        }
        return -1;
    }

    private static void doDfs(int[][] grid, int r, int c, boolean[][] visited, Queue<int[]> queue) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        visited[r][c] = true;
        queue.offer(new int[]{r, c});
        doDfs(grid, r + 1, c, visited, queue);
        doDfs(grid, r - 1, c, visited, queue);
        doDfs(grid, r, c - 1, visited, queue);
        doDfs(grid, r, c + 1, visited, queue);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[][] grid = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 0, 1}};
        TestCaseUtil.test(1, shortestBridge(grid), 1);
    }

    private static void test2() {
        int[][] grid = new int[][]{{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
        TestCaseUtil.test(1, shortestBridge(grid), 2);

    }
}
