package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words,
 * find all the starting indices of substrings in the given string that are a concatenation of all the given words
 * exactly once without any overlapping of words. It is given that all words are of the same length.
 * <p>
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 */
public class WordConcatenationProblem4 {
    public static void main(String[] args) {
        String str = "catfoxcat";
        String[] words = {"cat", "fox"};
        System.out.println(getIndexes(str, words));
    }

    static List<Integer> getIndexes(String str, String[] words) {
        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordCount = words.length;

        for (int i = 0; i <= str.length() - (wordCount * wordLen); i++) {
            Map<String, Integer> tmpMap = new HashMap<>();

            for (int j = 0; j < wordCount; j++) {
                int nextWordIndex = i + (j * wordLen);
                String nextWord = str.substring(nextWordIndex, nextWordIndex + wordLen);
                if (!wordMap.containsKey(nextWord)) {
                    break;
                }
                tmpMap.put(nextWord, tmpMap.getOrDefault(nextWord, 0) + 1);
                if (tmpMap.get(nextWord) > wordMap.getOrDefault(nextWord, 0)) {
                    break;
                }
                if (j + 1 == wordCount) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}
