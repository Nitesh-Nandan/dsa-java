package cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class FindKSmallestMissingPositiveNumber {

    static List<Integer> firstKSmallestMissingPositiveNumber(int[] arr, int k) {
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] > 0 && arr[itr] <= arr.length && arr[itr] != arr[arr[itr] - 1]) {
                CyclicUtil.swap(arr, itr, arr[itr] - 1);
            } else {
                itr++;
            }
        }

        Vector

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (int i = 0; i < arr.length && missingNumbers.size() < k; i++)
            if (arr[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(arr[i]);
            }

        // add the remaining missing numbers
        for (int i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = i + arr.length;
            // ignore if the array contains the candidate number
            if (!extraNumbers.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }

        return missingNumbers;
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
