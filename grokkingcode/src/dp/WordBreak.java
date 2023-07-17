package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordBreak1 {
    public static List<String> wordBreak(String str, String[] wordDict) {
        Map<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) {
            dict.put(word, true);
        }
        List<String> ans = new ArrayList<>();
        wordBreakHelper(str, 0, "", dict, ans);
        return ans;
    }

    static void wordBreakHelper(String str, int index, String res, Map<String, Boolean> dict, List<String> ans) {
        if (index == str.length()) {
            ans.add(res.substring(0, res.length() - 1));
        }
        int itr = index;
        StringBuilder sb = new StringBuilder();
        while (itr < str.length()) {
            sb.append(str.charAt(itr));
            if (dict.containsKey(sb.toString())) {
                String nres = res + sb + " ";
                wordBreakHelper(str, itr + 1, nres, dict, ans);
            }
            itr++;
        }
    }
}

class WordBreak2 {
    public static List<String> wordBreak(String str, List<String> wordDict) {
        Map<String, List<String>> dp = new HashMap<>();
        return wordBreakHelper(str, wordDict, dp);
    }

    private static List<String> wordBreakHelper(String str, List<String> wordDict, Map<String, List<String>> dp) {
        if (str.isEmpty()) {
            return Arrays.asList("");
        }

        if (dp.containsKey(str)) {
            return dp.get(str);
        }

        List<String> intermediateRes = new ArrayList<>();
        for (String word : wordDict) {
            if (str.startsWith(word)) {
                List<String> suffix = wordBreakHelper(str.substring(word.length()), wordDict, dp);
                for (String sstr : suffix) {
                    String space = sstr.isEmpty() ? "" : " ";
                    intermediateRes.add(word + space + sstr);
                }
            }
        }
        dp.put(str, intermediateRes);
        return intermediateRes;
    }
}

public class WordBreak {


    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        String str = "pineapplepenapple";
        String[] dict = {"apple", "pen", "applepen", "pine", "pineapple" };
        List<String> dicList = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

//        [pine apple pen apple, pine applepen apple, pineapple pen apple]
        System.out.println(WordBreak1.wordBreak(str, dict));
        System.out.println(WordBreak2.wordBreak(str, dicList));
    }

    static void test2() {
        String str = "catsandog";
        String[] dict = {"cats", "dog", "sand", "and", "cat" };
        List<String> dicList = Arrays.asList("cats", "dog", "sand", "and", "cat");

//        []
        System.out.println(WordBreak1.wordBreak(str, dict));
        System.out.println(WordBreak2.wordBreak(str, dicList));
    }
}


