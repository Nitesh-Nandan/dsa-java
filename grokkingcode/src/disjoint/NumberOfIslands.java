package disjoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

    public static int numIslands(ArrayList<ArrayList<Character>> grid) {
        int ans = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == '1') {
                    ans++;
                    doDfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private static void doDfs(ArrayList<ArrayList<Character>> grid, int row, int col) {
        if (row >= grid.size() || row < 0 || col >= grid.get(row).size() || col < 0
                || grid.get(row).get(col) == '*' || grid.get(row).get(col) == '0') {
            return;
        }
        grid.get(row).set(col, '*');

        doDfs(grid, row + 1, col);
        doDfs(grid, row - 1, col);
        doDfs(grid, row, col + 1);
        doDfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList('1', '1', '1')));
        grid.add(new ArrayList<>(Arrays.asList('0', '1', '0')));
        grid.add(new ArrayList<>(Arrays.asList('1', '0', '0')));
        grid.add(new ArrayList<>(Arrays.asList('1', '0', '1')));
        System.out.println(numIslands(grid));

    }
}
