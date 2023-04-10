package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> estimateWaterFlow(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];

        for (int i = 0; i < heights[0].length; i++) {
            doDfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            doDfs(heights, heights.length - 1, i, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            doDfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            doDfs(heights, i, heights[0].length - 1, Integer.MIN_VALUE, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private static void doDfs(int[][] heights, int x, int y, int prev, boolean[][] ocean) {
        if (x < 0 || y < 0 || x >= heights.length || y >= heights[0].length || ocean[x][y] || prev > heights[x][y]) {
            return;
        }
        ocean[x][y] = true;
        doDfs(heights, x + 1, y, heights[x][y], ocean);
        doDfs(heights, x - 1, y, heights[x][y], ocean);
        doDfs(heights, x, y + 1, heights[x][y], ocean);
        doDfs(heights, x, y - 1, heights[x][y], ocean);
    }


    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(estimateWaterFlow(heights));
    }

    private static void test2() {
//        [[0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [1, 1], [1, 3], [1, 4], [2, 3], [3, 2], [3, 3], [3, 4], [4, 0], [4, 1], [4, 3]]
        int[][] heights = new int[][]{{4, 4, 4, 3, 1}, {1, 5, 3, 7, 7}, {3, 1, 3, 7, 5}, {1, 2, 4, 4, 7}, {4, 3, 1, 7, 1}};
        System.out.println(estimateWaterFlow(heights));
    }
}
