package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumber {

    // mutable
    static List<Integer> findAllDuplicateNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                ans.add(index + 1);
            } else {
                arr[index] = -1 * arr[index];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = findAllDuplicateNumbers(new int[]{3, 4, 4, 5, 5}); // [4,5]
        System.out.println("Duplicates are: " + duplicates);

        duplicates = findAllDuplicateNumbers(new int[]{5, 4, 7, 2, 3, 5, 3}); // [5,3]
        System.out.println("Duplicates are: " + duplicates);
    }
}
