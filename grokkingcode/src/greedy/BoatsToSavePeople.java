package greedy;

import util.TestCaseUtil;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int rescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int low = 0;
        int high = people.length - 1;

        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
                high--;
            } else {
                high--;
            }
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(4, rescueBoats(new int[]{3, 1, 4, 2, 4}, 4), 1);
        TestCaseUtil.test(3, rescueBoats(new int[]{1, 1, 1, 1, 2}, 3), 2);
        TestCaseUtil.test(1, rescueBoats(new int[]{1, 2}, 3), 3);
        TestCaseUtil.test(4, rescueBoats(new int[]{5, 5, 5, 5}, 5), 4);
        TestCaseUtil.test(3, rescueBoats(new int[]{3, 2, 5, 5}, 5), 5);
    }
}
