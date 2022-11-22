package subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> ans  = new ArrayList<>();
        generateAllPermutations(word.toCharArray(), 0, word.length()-1, ans);
        return ans;
    }

    static void generateAllPermutations(char[] str, int low, int high, List<String> ans) {
        if (low == high) {
           ans.add(new String(str));
        } else {
            for (int i = low; i <= high; i++) {
                swap(str, low, i);
                generateAllPermutations(str, low + 1, high, ans);
                swap(str, low, i);
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char tt = str[i];
        str[i] = str[j];
        str[j] = tt;
    }

    public static void main(String[] args) {
        System.out.println(permuteWord("abc"));
    }
}
