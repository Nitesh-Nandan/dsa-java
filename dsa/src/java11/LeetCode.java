package java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = seats[0] == 0 ? 1 : 0;

        for(int i=1; i<n; i++) {
            if(seats[i] == 1) {
                left[i] = 0;
            } else {
                left[i] = 1 + left[i-1];
            }
        }

        right[n-1] = seats[n-1] == 0 ? n : 0;

        for(int i=n-2; i>=0; i--) {
            if(seats[i] == 1) {
                right[i] = 0;
            } else {
                right[i] = 1 + right[i+1];
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++) {
            ans = Math.max(ans, Math.min(left[i], right[i]));
        }

        return ans;
    }
}

public class LeetCode {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] courses = new int[]{1, 0, 0 ,1};
        Solution solution = new Solution();
        System.out.println(solution.maxDistToClosest(courses));
    }

}
