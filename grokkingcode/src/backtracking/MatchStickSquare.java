package backtracking;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.Collections;

public class MatchStickSquare {
    public static boolean matchstickToSquare(int[] nums) {
        int perimeter = Arrays.stream(nums).sum();
        if (perimeter % 4 != 0 || nums.length < 4) {
            return false;
        }
        int desiredLen = perimeter / 4;
        int[] sum = new int[4];
        int[] arr = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        return isPossible(arr, 0, sum, desiredLen);

    }

    static boolean isPossible(int[] arr, int index, int[] sums, int side) {
        if (index == arr.length) {
            return (sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3]);
        }

        int val = arr[index];
        for (int i = 0; i < 4; i++) {
            if (sums[i] + val <= side) {
                sums[i] = sums[i] + val;
                if (isPossible(arr, index + 1, sums, side)) {
                    return true;
                } else {
                    sums[i] = sums[i] - val;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(true, matchstickToSquare(new int[]{1, 1, 2, 2, 2}), 1);
        TestCaseUtil.test(false, matchstickToSquare(new int[]{3, 3, 3, 3, 4}), 2);
        TestCaseUtil.test(false, matchstickToSquare(new int[]{1, 1, 1, 2, 1}), 3);
        TestCaseUtil.test(true, matchstickToSquare(new int[]{3, 4, 4, 1, 2, 2}), 4);
        TestCaseUtil.test(false, matchstickToSquare(new int[]{5, 6, 1, 1, 2, 2}), 5);
    }
}
