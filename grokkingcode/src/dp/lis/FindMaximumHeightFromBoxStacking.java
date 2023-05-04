package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FindMaximumHeightFromBoxStacking {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        FindMaximumHeightFromBoxStacking sol = new FindMaximumHeightFromBoxStacking();
        int[][] cuboids = new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        System.out.println(sol.maxHeight(cuboids));
    }

    private static void test2() {
        FindMaximumHeightFromBoxStacking sol = new FindMaximumHeightFromBoxStacking();
        int[][] cuboids = new int[][]{{38, 25, 45}, {76, 35, 3}};
        System.out.println(sol.maxHeight(cuboids));
    }

    private static void test3() {
        int[][] cuboids = new int[][]{{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
        FindMaximumHeightFromBoxStacking sol = new FindMaximumHeightFromBoxStacking();
        System.out.println(sol.maxHeight(cuboids));

    }

    public int maxHeight(int[][] cuboids) {
        for(int[] dim : cuboids) {
            Arrays.sort(dim);
        }
        Arrays.sort(cuboids, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });
        int[] dp = new int[cuboids.length];
        int ans = 0;

        for(int i=0; i<cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for(int j=i-1; j>=0; j--) {
                if(cuboids[i][0] <= cuboids[j][0] && cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }



    public Box getAllBoxes(int[] dim) {
        Arrays.sort(dim);
        return new Box(dim[2], dim[1], dim[0]);
    }

//    public List<Box> getAllBoxes2(int w, int l, int h) {
//        return Arrays.asList(
//                new Box(h, w, l),
//                new Box(l, Math.max(w, h), Math.min(w, h)),
//                new Box(w, Math.max(l, h), Math.min(l, h))
//        );
//    }

    static class Box {
        int h;
        int w;
        int l;

        public Box(int w, int l, int h) {
            this.h = h;
            this.w = w;
            this.l = l;
        }
    }
}
