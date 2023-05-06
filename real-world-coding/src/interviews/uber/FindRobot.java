package interviews.uber;

class Solution {
    public void getTheRobot(char[][] grid, int[] limits) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'O' && doDfs(grid, i, j, limits)) {
                    System.out.println("i:" + i + " ,j:" + j);
                }
            }
        }
    }

    public boolean doDfs(char[][] grid, int x, int y, int[] limits) {
        boolean ans = true;
        ans = ans & traverse(grid, x, y, limits[0], "left");
        ans = ans & traverse(grid, x, y, limits[1], "top");
        ans = ans & traverse(grid, x, y, limits[2], "bottom");
        ans = ans & traverse(grid, x, y, limits[3], "right");

        return ans;

    }

    public boolean traverse(char[][] grid, int x, int y, int limit, String dir) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) {
            return true;
        }
        if (limit != 0 && grid[x][y] == 'X') {
            return false;
        }

        if (limit == 0 && grid[x][y] == 'X') {
            return true;
        }

        if (dir.equals("left")) {
            return traverse(grid, x, y - 1, limit - 1, dir);
        }

        if (dir.equals("right")) {
            return traverse(grid, x, y + 1, limit - 1, dir);
        }

        if (dir.equals("top")) {
            return traverse(grid, x - 1, y, limit - 1, dir);
        }
        return traverse(grid, x + 1, y, limit - 1, dir);
    }
}

public class FindRobot {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{{'O', 'E', 'E', 'E', 'X'}, {'E', 'O', 'X', 'X', 'X'}, {'E', 'E', 'E', 'E', 'E'}, {'X', 'E', 'O', 'E', 'E'}, {'X', 'E', 'X', 'E', 'X'}};
        solution.getTheRobot(grid, new int[]{2, 2, 4, 1});
    }
}

