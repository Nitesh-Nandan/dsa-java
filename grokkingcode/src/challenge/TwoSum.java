package challenge;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] arr, int t) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int req = t - arr[i];
            if (indexMap.containsKey(req)) {
                return new int[]{i, indexMap.get(req)};
            }
            indexMap.put(arr[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] arr = {3, 9, 11, 12, 17, 21};
        TestCaseUtil.compareArrayIgnoreOrder(new int[]{1,4}, twoSum(arr, 26), 1);
    }
}
