package dp;

import util.TestCaseUtil;

import java.util.PriorityQueue;

class MinimumFuel1 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = minRefuelStopsHelper(target, startFuel, stations, 0);
        return ans == 999999 ? -1 : ans;
    }

    static int minRefuelStopsHelper(int target, int far, int[][] stations, int index) {
        if (far >= target) {
            return 0;
        }
        int ans = 999999;
        for (int i = index; i < stations.length; i++) {
            int fuelDist = stations[i][0];
            int fuel = stations[i][1];
            if (far >= fuelDist) {
                int withStop = 1 + minRefuelStopsHelper(target, far + fuel, stations, index + 1);
                int withoutStop = minRefuelStopsHelper(target, far, stations, index + 1);
                return Math.min(withStop, withoutStop);
            }
        }
        return ans;
    }
}

class MinimumFuel2 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int far = startFuel;
        int stop = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        while (far < target) {
            while (idx < stations.length && far >= stations[idx][0]) {
                pq.offer(stations[idx][1]);
                idx++;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            far += pq.poll();
            stop++;
        }

        return stop;
    }
}


public class MinimumRefuelStops {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[][] stations = {{10, 60}, {20, 25}, {30, 30}, {60, 40}};
        TestCaseUtil.test(3, MinimumFuel1.minRefuelStops(120, 10, stations), 1);
        TestCaseUtil.test(3, MinimumFuel2.minRefuelStops(120, 10, stations), 1);
    }

    static void test2() {
        int[][] stations = {{2, 5}, {3, 1}, {6, 3}, {12, 6}};
        TestCaseUtil.test(4, MinimumFuel1.minRefuelStops(15, 3, stations), 2);
        TestCaseUtil.test(4, MinimumFuel2.minRefuelStops(15, 3, stations), 2);
    }

    static void test3() {
        int[][] stations = {{25, 25}, {50, 50}};
        TestCaseUtil.test(1, MinimumFuel1.minRefuelStops(100, 50, stations), 3);
        TestCaseUtil.test(1, MinimumFuel2.minRefuelStops(100, 50, stations), 3);
    }
}
