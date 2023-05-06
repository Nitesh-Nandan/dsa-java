package graphtheory;

public class MatrixDfs {
    public static void main(String[] args) {
        MatrixDfs dfs = new MatrixDfs();
        int[][] grid = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(dfs.getConnected(grid));
    }

    private int getConnected(int[][] grid) {
        int node = grid.length;
        boolean[] visited = new boolean[node];
        int ans = 0;

        for (int i = 0; i < node; i++) {
            if (!visited[i]) {
                ans++;
                doDfs(grid, visited, i);
            }
        }
        return ans;
    }

    public void doDfs(int[][] grid, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 0; i < grid[node].length; i++) {
            if (grid[node][i] == 1) {
                doDfs(grid, visited, i);
            }
        }
    }

}
