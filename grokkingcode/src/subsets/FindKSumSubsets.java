package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKSumSubsets {

    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        List<List<Integer>> resultSet = new ArrayList<>();
        printSubsets(setOfIntegers, 0, new ArrayList<>(), targetSum, resultSet);
        return resultSet;
    }

    static void printSubsets(List<Integer> nums, int index, List<Integer> ans, int target, List<List<Integer>> resultSet) {
        if (target == 0) {
            resultSet.add(ans);
            return;
        }
        if (target < 0 || index == nums.size()) return;

        List<Integer> tmp = new ArrayList<>(ans);
        printSubsets(nums, index + 1, tmp, target, resultSet);
        tmp.add(nums.get(index));
        printSubsets(nums, index + 1, tmp, target - nums.get(index), resultSet);

    }

    public static void main(String[] args) {
        System.out.println(getKSumSubsets(Arrays.asList(8, 13, 3, 22, 17, 39, 87, 45, 36), 3));
    }
}
