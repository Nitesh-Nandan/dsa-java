package backtracking;

import util.TestCaseUtil;

public class WordSearch {
    public static boolean wordSearch(char[][] grid, String word) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (searchHelper(grid, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean searchHelper(char[][] grid, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        boolean ans = false;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (isValid(grid, nrow, ncol, word.charAt(index))) {
                ans = ans | searchHelper(grid, nrow, ncol, word, index + 1);
            }
        }

        return ans;
    }

    private static boolean isValid(char[][] grid, int row, int col, char ch) {
        return row < grid.length && col < grid[0].length && col >= 0 && row >= 0 && grid[row][col] == ch;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        char[][] grid = {
                {'N', 'W', 'L', 'I', 'M'}, {'V', 'I', 'L', 'Q', 'O'},
                {'O', 'L', 'A', 'T', 'O'}, {'R', 'T', 'A', 'I', 'N'},
                {'O', 'I', 'T', 'N', 'C'}
        };

        TestCaseUtil.test(true, wordSearch(grid, "LATIN"), 1);
    }

    static void test2() {
        char[][] grid = {
                {'C', 'Q', 'N', 'A'},
                {'P', 'S', 'E', 'I'},
                {'Z', 'A', 'P', 'E'},
                {'J', 'V', 'T', 'K'}
        };

        TestCaseUtil.test(false, wordSearch(grid, "SAVE"), 2);
    }

    static void test3() {
        char[][] grid = {
                {'N', 'W', 'L', 'I', 'M'}, {'V', 'I', 'L', 'Q', 'O'},
                {'O', 'L', 'A', 'T', 'O'}, {'R', 'T', 'A', 'I', 'N'},
                {'O', 'I', 'T', 'N', 'C'}
        };

        TestCaseUtil.test(true, wordSearch(grid, "LATIN"), 3);
    }

    static void test4() {
        char[][] grid = {
                {'E', 'D', 'X', 'I', 'W'},
                {'P', 'A', 'F', 'M', 'Q'},
                {'I', 'C', 'A', 'S', 'F'},
                {'M', 'A', 'L', 'C', 'A'},
                {'J', 'T', 'I', 'V', 'E'}
        };

        TestCaseUtil.test(false, wordSearch(grid, "EDUCATIVE"), 4);
    }

    static void test5() {
        char[][] grid = {
                {'O', 'Y', 'O', 'I'},
                {'B', 'I', 'E', 'M'},
                {'K', 'D', 'Y', 'R'},
                {'M', 'T', 'W', 'I'},
                {'Z', 'I', 'T', 'O'}
        };

        TestCaseUtil.test(false, wordSearch(grid, "DYNAMIC"), 5);
    }
}
