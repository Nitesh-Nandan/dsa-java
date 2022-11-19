package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumber {

    // mutable
    static List<Integer> findAllDuplicateNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = findAllDuplicateNumbers(new int[]{3, 4, 4, 5, 5}); // [4,5]
        System.out.println("Duplicates are: " + duplicates);

        duplicates = findAllDuplicateNumbers(new int[]{5, 4, 7, 2, 3, 5, 3}); // [5,3]
        System.out.println("Duplicates are: " + duplicates);
    }
}
