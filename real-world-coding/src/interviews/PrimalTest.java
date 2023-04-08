package interviews;

import java.util.Arrays;
import java.util.List;

public class PrimalTest {

    static int[] getArrayAfterMOperation(int[] arr, List<Queries> queries) {
        int[] prefixSum = new int[arr.length + 1];
        for (Queries query : queries) {
            prefixSum[query.starInd] += query.num;
            prefixSum[query.endId + 1] -= query.num;
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i] + prefixSum[i - 1];
        }

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i] + prefixSum[i];
        }

        return res;
    }

    /**
     * [5, 6, -5 ,-6 ,0, 0]
     * [5, 11, 5, 0, 0, 0
     * <p>
     * [6, 13, 8, 4, 5, 6]
     */


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String tst  = "nitesh";
        System.out.println(tst.split(""));
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        List<Queries> queries = Arrays.asList(
                new Queries(0, 1, 5),
                new Queries(1, 2, 6),
                new Queries(0, 5, 10)
        );

        int[] ans = PrimalTest.getArrayAfterMOperation(arr, queries);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    static class Queries {
        int starInd;
        int endId;
        int num;

        public Queries(int sid, int eid, int num) {
            this.starInd = sid;
            this.endId = eid;
            this.num = num;
        }
    }
}
/**
 * You have given an array of Integer.
 * And List of m queries responsible for operation in array.
 * Each Query will have 3 value, first two value will represent range of subarray, and last value is a num, that need to added in the range.
 * You need to find out final array after all the operations.
 *
 * for eg: arr = [1, 2, 3, 4, 5, 6]
 * Queries [ [0,1,5] ]
 *
 * ans = [6, 7, 3, 4, 5, 6]
 *
 *
 *  Sample 2: arr = [1, 2, 3, 4, 5, 6]
 *  * Queries [ [0,1,5], [1,2,6] ]
 *  *
 *  * ans = [6, 13, 9, 4, 5, 6]
 *
 *  Sample 3: arr = [1, 2, 3, 4, 5, 6]
 *  *  Queries [ [0,1,5], [1,2,6], [0,5,10]  ]
 *  *
 *  *   ans = [16 23 19 14 15 16]
 *
 */
