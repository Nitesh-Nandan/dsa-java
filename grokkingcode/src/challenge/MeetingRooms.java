package challenge;

import util.TestCaseUtil;

import java.util.Arrays;

public class MeetingRooms {
    public static boolean attendAllMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[][] meetings = {{2, 5}, {1, 5}, {2, 8}, {7, 9}, {11, 12}};
        TestCaseUtil.test(false, attendAllMeetings(meetings), 1);

    }
}
