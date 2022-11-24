package greedy;

import util.TestCaseUtil;

import java.util.Arrays;

public class GasStations {

    public static int gasStationJourney(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int startIndex = 0;
        int balance = 0;
        for (int i = 0; i < gas.length; i++) {
            balance += (gas[i] - cost[i]);
            if (balance < 0) {
                startIndex = i + 1;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(4, gasStationJourney(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}), 1);
        TestCaseUtil.test(-1, gasStationJourney(new int[]{2, 3, 4}, new int[]{3, 4, 3}), 2);
        TestCaseUtil.test(4, gasStationJourney(new int[]{1, 1, 1, 1, 10}, new int[]{2, 2, 1, 3, 1}), 3);
        TestCaseUtil.test(-1, gasStationJourney(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}), 4);
        TestCaseUtil.test(0, gasStationJourney(new int[]{1}, new int[]{1}), 5);
    }
}
