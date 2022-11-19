package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumber {

   static List<Integer> findNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing); // [4, 6, 7]

        missing = findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing); // [3]

        missing = findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing); // [4]
    }
}
