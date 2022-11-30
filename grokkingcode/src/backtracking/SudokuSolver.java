package backtracking;

public class SudokuSolver {

    public static char[][] solveSudoku(char[][] board) {
        solveSudokuHelper(board);
        return board;
    }

    static boolean solveSudokuHelper(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solveSudokuHelper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) return false;
            if (board[i][col] == ch) return false;
        }

        row = row - (row % 3);
        col = col - (col % 3);

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == ch) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
        System.out.println('\n');
        test2();
    }

    static void test1() {
        char[][] board = {
                {'.', '.', '.', '.', '2', '7', '.', '5', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '.'},
                {'2', '7', '5', '.', '.', '.', '3', '1', '4'},
                {'9', '8', '.', '.', '.', '.', '.', '3', '1'},
                {'.', '3', '1', '8', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '8', '.', '5'},
                {'7', '.', '6', '2', '.', '.', '1', '8', '.'},
                {'.', '9', '.', '7', '.', '.', '.', '.', '.'},
                {'4', '1', '.', '.', '.', '5', '.', '.', '7'}
        };

        solveSudoku(board);
        print(board);
    }

    static void test2() {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        solveSudoku(board);
        print(board);
    }

    static void print(char[][] board) {
        for(int i=0; i< 9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(String.valueOf(board[i][j]) + "   ");
            }
            System.out.println();
        }
    }
}
