package subsets;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

    public static ArrayList<String> generateCombinations(int n) {

        ArrayList<String> result = new ArrayList<String>();
        generateValidParenthesis("", n, n, result);
        return result;
    }

    static void generateValidParenthesis(String str, int open, int closed, List<String> ans) {
        if (closed < open || open < 0) {
            return;
        }
        if (open == 0 && closed == 0) {
            ans.add(str);
        }
        generateValidParenthesis(str + "(", open - 1, closed, ans);
        generateValidParenthesis(str + ")", open, closed - 1, ans);
    }

    public static void main(String[] args) {
        System.out.println(generateCombinations(3));
        System.out.println(generateCombinations(2));
        System.out.println(generateCombinations(1));
    }
}
