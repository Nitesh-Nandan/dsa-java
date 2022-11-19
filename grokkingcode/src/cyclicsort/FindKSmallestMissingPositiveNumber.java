package cyclicsort;

import java.util.Collections;
import java.util.List;

public class FindKSmallestMissingPositiveNumber {

    static List<Integer> firstKSmallestMissingPositiveNumber(int[] arr, int k) {
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = firstKSmallestMissingPositiveNumber(new int[]{3, -1, 4, 5, 5}, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = firstKSmallestMissingPositiveNumber(new int[]{2, 3, 4}, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = firstKSmallestMissingPositiveNumber(new int[]{-2, -3, 4}, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
