package dp.lis;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumLengthPairChain {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        LinkedList<List<Integer>> lis = new LinkedList<>();
        lis.add(Arrays.asList(pairs[0][0], pairs[0][1]));

        for (int i = 1; i < pairs.length; i++) {
            List<Integer> lastPair = lis.getLast();
            if (lastPair.get(1) < pairs[i][0]) {
                lis.add(Arrays.asList(pairs[i][0], pairs[i][1]));
            } else {
                if (pairs[i][1] < lastPair.get(1)) {
                    lis.removeLast();
                    lis.add(Arrays.asList(pairs[i][0], pairs[i][1]));
                }
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
//        System.out.println(findLongestChain(pairs));
        TestCaseUtil.test(2, findLongestChain(pairs), 1);

    }

    private static void test2() {
        int[][] pairs = new int[][]{{1, 2}, {7, 8}, {4, 5}};
//        System.out.println(findLongestChain(pairs));
        TestCaseUtil.test(3, findLongestChain(pairs), 2);
    }

    private static void test3() {
        int[][] pairs = new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
//        System.out.println(findLongestChain(pairs));
        TestCaseUtil.test(3, findLongestChain(pairs), 3);
    }
}
