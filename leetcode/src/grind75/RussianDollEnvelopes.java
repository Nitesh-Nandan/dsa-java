package grind75;

import util.TestCaseUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> lis = new ArrayList<>();
        int ans = 1;

        for (int i = 0; i < envelopes.length; i++) {
            int num = envelopes[i][1];

            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                findLowerBoundAndInsert(lis, num);
//                int indx = Collections.binarySearch(lis, num);
//                if(indx < 0) {
//                    indx = Math.abs(indx+1);
//                }
//                lis.set(indx, num);
            }
            ans = Math.max(ans, lis.size());
        }
        return ans;
    }

    public static int maxEnvelopes2(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        List<Integer> list = new ArrayList<>();
        int ans = 0;

        for(int[] envelope: envelopes) {
            insertInOrder(list, envelope[1]);
            ans = Math.max(ans, list.size());
        }
        return ans;
    }

    private static void insertInOrder(List<Integer> list, int num) {
        if(list.isEmpty() || num > list.get(list.size()-1)) {
            list.add(num);
        }

        int low = 0;
        int high = list.size()-1;
        int pos = -1;

        while(low <= high) {
            int mid = low + (high-low) /2 ;
            if(list.get(mid) >= num) {
                pos = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        // list.remove(pos);
        list.set(pos, num);
    }

    private static void findLowerBoundAndInsert(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size();


        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num <= lis.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < lis.size() && lis.get(left) < num) {
            left++;
        }
        lis.set(left, num);
    }

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        int[][] envelopes = new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}};
        TestCaseUtil.test(7, maxEnvelopes(envelopes), 1);
    }

    private static void test2() {
        int[][] envelopes = new int[][] {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        maxEnvelopes2(envelopes);

    }
}
