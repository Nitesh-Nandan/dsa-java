package grind75;

import util.TestCaseUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(beginWord, 1));

        while (!queue.isEmpty()) {
            Data curr = queue.poll();

            if (curr.word.equals(endWord)) {
                return curr.step;
            }

            char[] curWordArray = curr.word.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < curWordArray.length; i++) {
                    char x = curWordArray[i];
                    curWordArray[i] = ch;
                    String str = new String(curWordArray);
                    curWordArray[i] = x;
                    if (dict.contains(str)) {
                        queue.offer(new Data(str, curr.step + 1));
                        dict.remove(str);
                    }

                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String begin = "hit";
        String end = "cog";
        List<String> wordsList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        TestCaseUtil.test(5, ladderLength(begin, end, wordsList), 1);
    }

    private static void test2() {
        String begin = "hit";
        String end = "cog";
        List<String> wordsList = Arrays.asList("hot", "dot", "dog", "lot", "log");

        TestCaseUtil.test(0, ladderLength(begin, end, wordsList), 2);
    }

    static class Data {
        String word;
        int step;

        public Data(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
