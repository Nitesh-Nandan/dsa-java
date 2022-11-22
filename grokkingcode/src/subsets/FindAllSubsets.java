package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllSubsets {

    public static List<HashSet<Integer>> findAllSubsets(List<Integer> nums) {
        List<HashSet<Integer>> setsList = new ArrayList<>();
        int setSize = (int) Math.pow(2, nums.size());
        int len = nums.size();
        for (int i = 0; i < setSize; i++) {
            HashSet<Integer> tmp = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (isBitSet(i, j)) {
                    tmp.add(nums.get(j));
                }
            }
            setsList.add(tmp);
        }
        return setsList;
    }

    static boolean isBitSet(int num, int bit) {
        int tmp = 1 << bit;
        return ((tmp & num) != 0);
    }

    public static void main(String[] args) {
        System.out.println(findAllSubsets(Arrays.asList(1, 2, 3)));
    }
}
