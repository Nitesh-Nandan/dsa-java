package dbp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CandidateFind {
    private static List<Integer> getCandidates(List<Integer> candidates, List<Integer> factors, int threshold) {
        Collections.sort(factors);
        List<Integer> ans = new ArrayList<>();

        for(int cand : candidates) {

            int low = 0;
            int high = factors.size() - 1;
            int idx = -1;

            while (low <= high) {
                int mid = low + (high-low)/2;
                if(factors.get(mid) * cand > threshold) {
                    idx = mid;
                    high = mid-1;
                } else {
                    low = mid + 1;
                }
            }

            if(idx == -1) {
                ans.add(0);
            } else {
                ans.add(factors.size()-idx);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(getCandidates(Arrays.asList(1,2,3), Arrays.asList(8,0,8), 9));
    }

}
