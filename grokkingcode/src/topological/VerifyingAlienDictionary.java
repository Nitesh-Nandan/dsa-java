package topological;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    public static boolean verifyAlienDictionary(String[] words, String order) {
        Map<Character, Integer> charOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charOrder.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];

            int k = 0;
            int len = Math.min(cur.length(), next.length());
            while (k < len && cur.charAt(k) == next.charAt(k)) {
                k++;
            }
            if (k < len && charOrder.get(cur.charAt(k)) > charOrder.get(next.charAt(k))) {
                return false;
            }

            if (k == len && cur.length() > next.length()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TestCaseUtil.test(true, verifyAlienDictionary(new String[]{"marvel", "marvellous"}, "marvelbcdfghijknopqstuwxyz"), 1);
        TestCaseUtil.test(true, verifyAlienDictionary(new String[]{"jupyter", "ascending"}, "jabcdefghiklmnopqrstuvwxyz"), 2);
        TestCaseUtil.test(false, verifyAlienDictionary(new String[]{"passengers", "to", "the", "unknown"}, "ptuabcdefghijklmnoqrsvwxyz"), 3);
        TestCaseUtil.test(true, verifyAlienDictionary(new String[]{"martian"}, "mabcdefghijklnopqrstuvwxyz"), 4);
        TestCaseUtil.test(false, verifyAlienDictionary(new String[]{"marvellous", "marvel"}, "marvelbcdfghijknopqstuwxyz"), 5);
    }
}
