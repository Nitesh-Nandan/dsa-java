package backtracking;

import util.TestCaseUtil;

import java.util.ArrayList;
import java.util.List;

class NQSolution {

    static int count = 0;
    static int printSolution(int n) {
        count=0;
        backTrackAndGetSol(0, n, new ArrayList<>());
        return count;
    }

    static void backTrackAndGetSol(int row, int n, List<Integer> existingCols) {
        if (row == n) {
            count++;
//            System.out.print(existingCols);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, existingCols)) {
                existingCols.add(col);
                backTrackAndGetSol(row + 1, n, existingCols);
                existingCols.remove(existingCols.size() - 1);
            }
        }
    }

    static boolean isValid(int row, int col, List<Integer> existingCols) {
        for (int i = 0; i < existingCols.size(); i++) {
            int existingCol = existingCols.get(i);
            if (existingCol == col || (Math.abs(i - row) == Math.abs(existingCol - col))) {
                return false;
            }
        }
        return true;
    }
}

public class NQueue {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        TestCaseUtil.test(2, NQSolution.printSolution(4), 1);
    }

    static void test2() {
        TestCaseUtil.test(10, NQSolution.printSolution(5), 2);
    }

    static void test3() {
        TestCaseUtil.test(4, NQSolution.printSolution(6), 3);
    }

    static void test4() {
        TestCaseUtil.test(40, NQSolution.printSolution(7), 4);
    }

    static void test5() {
        TestCaseUtil.test(92, NQSolution.printSolution(8), 5);
    }
}
